package IS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface {

	private JFrame frame;
	private Controller controller = new Controller(); // controller connected to the interface//
	private JTextField textField_costumernumber;
	private JTextField textField_name;
	private JTextField textField_address;
	private JTextField textField_ProductName;
	private JTextField textField_Category;
	private JTextField textField_Price;
	private JTextField textField_Ordernumber;
	private JTextField textField_date;
	private JTextField textField_Orderline;
	private JTextField textField_Amount;
	private JTextField textField_SerialNumber;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 929, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblKundnummer = new JLabel(" Kundnummer:");
		lblKundnummer.setBounds(3, 22, 139, 16);
		frame.getContentPane().add(lblKundnummer);

		textField_costumernumber = new JTextField();
		textField_costumernumber.setBounds(119, 17, 130, 26);
		frame.getContentPane().add(textField_costumernumber);
		textField_costumernumber.setColumns(10);

		JLabel lblNamn = new JLabel(" Namn:");
		lblNamn.setBounds(3, 50, 61, 16);
		frame.getContentPane().add(lblNamn);

		textField_name = new JTextField();
		textField_name.setBounds(119, 45, 130, 26);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);

		JLabel lblAdress = new JLabel(" Adress:");
		lblAdress.setBounds(3, 77, 61, 16);
		frame.getContentPane().add(lblAdress);

		textField_address = new JTextField();
		textField_address.setBounds(119, 72, 130, 26);
		frame.getContentPane().add(textField_address);
		textField_address.setColumns(10);

		JButton btnCreate = new JButton("Skapa");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerId = textField_costumernumber.getText();
				String name = textField_name.getText();
				String address = textField_address.getText();

				Customer A = new Customer(customerId, name, address);

				controller.addCustomer(A);

				textArea_1.setText("Kunden är tillagd i systemet");

			}
		});
		btnCreate.setBounds(3, 111, 117, 29);
		frame.getContentPane().add(btnCreate);

		JButton btnSearch = new JButton("S\u00F6k");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = textField_costumernumber.getText();

				Customer temp = controller.findCustomer(customId);

				textArea_1.setText("Personens info: " + temp.getAddress() + " " + temp.getName());

			}
		});
		btnSearch.setBounds(3, 151, 117, 29);
		frame.getContentPane().add(btnSearch);

		JButton btnDelete = new JButton("Ta bort");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = textField_costumernumber.getText();

				controller.removeCustomer(customId);

				textArea_1.setText("Kunden är borttagen");

			}
		});
		btnDelete.setBounds(132, 111, 117, 29);
		frame.getContentPane().add(btnDelete);

		JButton btnChange = new JButton("Ändra ");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = textField_costumernumber.getText();
				String name = textField_name.getText();
				String address = textField_address.getText();

				controller.editCutomer(customId, name, address);

				textArea_1.setText("Uppgifter om kunden är ändrad");

			}
		});
		btnChange.setBounds(132, 151, 117, 29);
		frame.getContentPane().add(btnChange);

		JLabel lblKund = new JLabel(" Kund");
		lblKund.setBounds(3, 0, 61, 16);
		frame.getContentPane().add(lblKund);
		
		

		// The TextField, Button, Label and functions for the Customer is added to the interface//
		
		
		
		

		JLabel lblProduct = new JLabel("Produkt");
		lblProduct.setBounds(317, 0, 61, 16);
		frame.getContentPane().add(lblProduct);

		JLabel lblProductName = new JLabel("Produktnamn:");
		lblProductName.setBounds(317, 22, 95, 16);
		frame.getContentPane().add(lblProductName);

		textField_ProductName = new JTextField();
		textField_ProductName.setBounds(427, 45, 130, 26);
		frame.getContentPane().add(textField_ProductName);
		textField_ProductName.setColumns(10);

		JLabel lblCategory = new JLabel("Kategori:");
		lblCategory.setBounds(317, 50, 61, 16);
		frame.getContentPane().add(lblCategory);

		textField_Category = new JTextField();
		textField_Category.setBounds(427, 17, 130, 26);
		frame.getContentPane().add(textField_Category);
		textField_Category.setColumns(10);

		JLabel lblPrice = new JLabel("Pris:");
		lblPrice.setBounds(317, 78, 61, 16);
		frame.getContentPane().add(lblPrice);

		textField_Price = new JTextField();
		textField_Price.setBounds(427, 72, 130, 26);
		frame.getContentPane().add(textField_Price);
		textField_Price.setColumns(10);

		JButton btnCreate_1 = new JButton("Skapa");
		btnCreate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Namn = textField_ProductName.getText();
				String Kategori = textField_Category.getText();
				Integer pris = new Integer(textField_Price.getText());

				Product B = new Product(Namn, Kategori, pris);

				controller.addProduct(B);

				textArea_1.setText("Produkten är tillagd");

			}
		});
		btnCreate_1.setBounds(316, 111, 117, 29);
		frame.getContentPane().add(btnCreate_1);

		JButton btnSearch_1 = new JButton("S\u00F6k");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productNamn = textField_ProductName.getText();

				Product temp = controller.findProduct(productNamn);

				textArea_1.setText("Produktens info: " + temp.getCategory() + " " + temp.getPrice());

			}
		});
		btnSearch_1.setBounds(316, 152, 117, 29);
		frame.getContentPane().add(btnSearch_1);

		JButton btnDelete_1 = new JButton("Ta bort");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productNamn = textField_ProductName.getText();

				controller.removeProduct(productNamn);

				textArea_1.setText("Produkten är borttagen");

			}
		});
		btnDelete_1.setBounds(440, 111, 117, 29);
		frame.getContentPane().add(btnDelete_1);

		JButton btnChange_1 = new JButton("Ändra ");
		btnChange_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Namn = textField_ProductName.getText();
				String Kategori = textField_Category.getText();
				Integer pris = new Integer(textField_Price.getText());

				controller.editProduct(Namn, Kategori, pris);

				textArea_1.setText("Produkten är ändrad");
			}
		});
		btnChange_1.setBounds(440, 151, 117, 29);
		frame.getContentPane().add(btnChange_1);
		
		
		
		
		// The TextField, Button, Label and functions for the Product is added to the interface//
		
		
		

		JLabel lblOrder = new JLabel("Order");
		lblOrder.setBounds(635, 0, 61, 16);
		frame.getContentPane().add(lblOrder);

		JLabel lblOrdernumber = new JLabel("Ordernummer:");
		lblOrdernumber.setBounds(635, 22, 95, 16);
		frame.getContentPane().add(lblOrdernumber);

		textField_Ordernumber = new JTextField();
		textField_Ordernumber.setBounds(745, 17, 130, 26);
		frame.getContentPane().add(textField_Ordernumber);
		textField_Ordernumber.setColumns(10);

		JLabel lblDate = new JLabel("Datum:");
		lblDate.setBounds(635, 50, 61, 16);
		frame.getContentPane().add(lblDate);

		textField_date = new JTextField();
		textField_date.setBounds(745, 45, 130, 26);
		frame.getContentPane().add(textField_date);
		textField_date.setColumns(10);

		JButton btnCreate_2 = new JButton("Skapa");
		btnCreate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String orderId = textField_Ordernumber.getText();
				String orderDate = textField_date.getText();
				String customerId = textField_costumernumber.getText();

				Customer temp = controller.findCustomer(customerId);

				Order C = new Order(orderId, orderDate, temp);

				controller.addOrder(C);

				textArea_1.setText("Ordern är tillagd");

			}

		});
		btnCreate_2.setBounds(635, 111, 117, 29);
		frame.getContentPane().add(btnCreate_2);

		JButton btnSearch_2 = new JButton("S\u00F6k");
		btnSearch_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = textField_Ordernumber.getText();

				Order temp = controller.findOrder(orderId);

				textArea_1.setText("Order info: " + temp.getOrderDate());

			}
		});
		btnSearch_2.setBounds(635, 151, 117, 29);
		frame.getContentPane().add(btnSearch_2);

		JButton btnDelete_2 = new JButton("Ta bort");
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = textField_Ordernumber.getText();

				controller.removeOrder(orderId);

				textArea_1.setText("Ordern är borttagen");

			}
		});
		btnDelete_2.setBounds(758, 111, 117, 29);
		frame.getContentPane().add(btnDelete_2);
		
		
		// The TextField, Button, Label and functions for the Order is added to the interface//
		
		

		JLabel lblOrderrad = new JLabel(" Orderrad");
		lblOrderrad.setBounds(3, 241, 61, 16);
		frame.getContentPane().add(lblOrderrad);

		JLabel lblOrderline = new JLabel(" Orderradsnummer:");
		lblOrderline.setBounds(3, 268, 148, 16);
		frame.getContentPane().add(lblOrderline);

		textField_Orderline = new JTextField();
		textField_Orderline.setBounds(119, 263, 130, 26);
		frame.getContentPane().add(textField_Orderline);
		textField_Orderline.setColumns(10);

		JLabel lblAmount = new JLabel(" Antal:");
		lblAmount.setBounds(3, 295, 61, 16);
		frame.getContentPane().add(lblAmount);

		textField_Amount = new JTextField();
		textField_Amount.setBounds(119, 290, 130, 26);
		frame.getContentPane().add(textField_Amount);
		textField_Amount.setColumns(10);

		JButton btnCreate_3 = new JButton("Skapa");
		btnCreate_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idNummer = textField_Orderline.getText();
				Integer antal = new Integer(textField_Amount.getText());
				String orderId = textField_Ordernumber.getText();
				String productName = textField_ProductName.getText();

				Order temp1 = controller.findOrder(orderId);
				Product temp2 = controller.findProduct(productName);

				OrderLine D = new OrderLine(idNummer, antal, temp1, temp2);

				controller.addOrderLine(D);

				textArea_1.setText("Orderraden är tillagd");

			}
		});
		btnCreate_3.setBounds(3, 332, 117, 29);
		frame.getContentPane().add(btnCreate_3);

		JButton btnDelete_3 = new JButton("Ta bort");
		btnDelete_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idNummer = textField_Orderline.getText();
				controller.removeOrderLine(idNummer);

				textArea_1.setText("Orderraden är borttagen");
			}
		});
		btnDelete_3.setBounds(132, 332, 117, 29);
		frame.getContentPane().add(btnDelete_3);
		
		
		
		// The TextField, Button, Label and functions for the Orderline is added to the interface//
		
		

		JLabel lblItem = new JLabel("Exemplar ");
		lblItem.setBounds(317, 241, 116, 16);
		frame.getContentPane().add(lblItem);

		JLabel lblSerialNumber = new JLabel("Serienummer:");
		lblSerialNumber.setBounds(317, 268, 108, 16);
		frame.getContentPane().add(lblSerialNumber);

		textField_SerialNumber = new JTextField();
		textField_SerialNumber.setBounds(422, 263, 130, 26);
		frame.getContentPane().add(textField_SerialNumber);
		textField_SerialNumber.setColumns(10);

		JButton btnCreate_4 = new JButton("Skapa");
		btnCreate_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serialNumber = textField_SerialNumber.getText();
				String productId = textField_ProductName.getText();

				Product temp3 = controller.findProduct(productId);

				Item E = new Item(serialNumber, temp3);

				controller.addItem(E);

				textArea_1.setText("Exemplaret är tillagt");

			}
		});
		btnCreate_4.setBounds(316, 335, 117, 29);
		frame.getContentPane().add(btnCreate_4);

		JButton btnDelete_4 = new JButton("Ta bort");
		btnDelete_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serialNumber = textField_SerialNumber.getText();

				controller.removeItem(serialNumber);

				textArea_1.setText("Exemplet är borttaget");
			}
		});
		btnDelete_4.setBounds(435, 335, 117, 29);
		frame.getContentPane().add(btnDelete_4);
		
		
		
		// The TextField, Button, Label and functions for the Item is added to the interface//

		
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(199, 399, 499, 162);
		frame.getContentPane().add(textArea_1);
	}
	
	// The textArea where the output comes out //
}
