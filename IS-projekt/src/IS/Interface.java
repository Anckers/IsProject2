package IS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Interface {

	private JFrame frame;
	private Controller controller; 
	private ProductRegister productRegister;
	private CustomerRegister customerRegister;
	private JTextField txtField_CustomerNumber;
	private JTextField txtFeild_Name;
	private JTextField txtField_Address;
	private JTextField textField_ProductName;
	private JTextField textField_ProductCategory;
	private JTextField txtField_ProductPrice;
	private JTextField textField_OrderNumber;
	private JTextField textField_OrderDate;
	private JTextField textField_Orderline;
	private JTextField textField_OrderLineAmount;
	private JTextField textField_ItemSerialNumber;
	private JTextArea textArea_1;
	private JTextField txtField_OrderCustomerId;

	
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
		
		customerRegister = new CustomerRegister();
		productRegister = new ProductRegister();
		controller = new Controller (customerRegister, productRegister);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 929, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCustomerNbr = new JLabel(" Kundnummer:");
		lblCustomerNbr.setBounds(3, 37, 139, 16);
		frame.getContentPane().add(lblCustomerNbr);

		txtField_CustomerNumber = new JTextField();
		txtField_CustomerNumber.setBounds(119, 32, 130, 26);
		frame.getContentPane().add(txtField_CustomerNumber);
		txtField_CustomerNumber.setColumns(10);

		JLabel lblName = new JLabel(" Namn:");
		lblName.setBounds(3, 65, 61, 16);
		frame.getContentPane().add(lblName);

		txtFeild_Name = new JTextField();
		txtFeild_Name.setBounds(119, 60, 130, 26);
		frame.getContentPane().add(txtFeild_Name);
		txtFeild_Name.setColumns(10);

		JLabel lblAdress = new JLabel(" Adress:");
		lblAdress.setBounds(3, 92, 61, 16);
		frame.getContentPane().add(lblAdress);

		txtField_Address = new JTextField();
		txtField_Address.setBounds(119, 87, 130, 26);
		frame.getContentPane().add(txtField_Address);
		txtField_Address.setColumns(10);

		JButton btnCreateCustomer = new JButton("Skapa");
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerId = txtField_CustomerNumber.getText();
				String name = txtFeild_Name.getText();
				String address = txtField_Address.getText();
				Customer A = new Customer(customerId, name, address);
				//adds Customer creates a argument that allow for actions to be performed if successful
				Boolean success = controller.addCustomer(A);
				//Controls that required fields are not empty
				if(!txtField_CustomerNumber.getText().isEmpty() && !txtFeild_Name.getText().isEmpty() && !txtField_Address.getText().isEmpty()) {
					//performs action when button is successful
					if (success) {
						//changes color of the txtArea
						textArea_1.setForeground(new Color(0, 128, 0));
						//success message in txtArea
						textArea_1.setText(name + " är tillagd i systemet");
						//empties txtFeild's
						txtField_CustomerNumber.setText("");
						txtFeild_Name.setText("");
						txtField_Address.setText("");
					}
					//if action is not successful this message will be shown
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Kundnummer " + customerId + " finns redan i systemet");
					}
				}
				//if any field is empty this message will be shown
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("inga fält under Kund får vara tom");
				}
			}
		});
		btnCreateCustomer.setBounds(3, 126, 117, 29);
		frame.getContentPane().add(btnCreateCustomer);

		JButton btnSearchCustomer = new JButton("S\u00F6k");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = txtField_CustomerNumber.getText();
				Customer temp = controller.findCustomer(customId);
				if(!txtField_CustomerNumber.getText().isEmpty()) {
					if(temp != null) {
						txtField_CustomerNumber.setText("");
						textArea_1.setForeground(new Color(0, 0, 0));
						textArea_1.setText("Personens info: " + temp.getAddress() + " " + temp.getName());
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen kund med kundnummer: " + customId);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Kundnummer krävs");
				}
			}
		});
		btnSearchCustomer.setBounds(3, 166, 117, 29);
		frame.getContentPane().add(btnSearchCustomer);

		JButton btnDeleteCustomer = new JButton("Ta bort");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = txtField_CustomerNumber.getText();
				Customer temp = controller.findCustomer(customId);
				controller.removeCustomer(customId);				
				if(!txtField_CustomerNumber.getText().isEmpty()) {
					if(temp != null) {
						txtField_CustomerNumber.setText("");
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText(temp.getName() + " har blivit borttagen");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen kund med kundnummer: " + customId);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Kundnummer krävs");
				}
			}
		});
		btnDeleteCustomer.setBounds(132, 126, 117, 29);
		frame.getContentPane().add(btnDeleteCustomer);

		JButton btnChangeCustomer = new JButton("Ändra ");
		btnChangeCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = txtField_CustomerNumber.getText();
				String name = txtFeild_Name.getText();
				String address = txtField_Address.getText();
				Customer temp = controller.findCustomer(customId);
				if(!txtField_CustomerNumber.getText().isEmpty() && !txtFeild_Name.getText().isEmpty() && !txtField_Address.getText().isEmpty()) {
					if(temp != null) {
						controller.editCustomer(customId, name, address);
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Kundnummer: " + customId + " Har blivit ändrad");
						txtField_CustomerNumber.setText("");
						txtFeild_Name.setText("");
						txtField_Address.setText("");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen kund med kundnummer: " + customId);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("inga fält under Kund får vara tomma");
				}
			}
		});
		btnChangeCustomer.setBounds(132, 166, 117, 29);
		frame.getContentPane().add(btnChangeCustomer);

		JLabel lblCustomer = new JLabel(" Kund");
		lblCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomer.setBounds(3, 0, 148, 26);
		frame.getContentPane().add(lblCustomer);
		
		

		// The TextField, Button, Label and functions for the Customer is added to the interface
		
		
		
		

		JLabel lblProduct = new JLabel("Produkt");
		lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProduct.setBounds(317, 0, 116, 23);
		frame.getContentPane().add(lblProduct);

		JLabel lblProductName = new JLabel("Produktnamn:");
		lblProductName.setBounds(317, 36, 95, 16);
		frame.getContentPane().add(lblProductName);

		textField_ProductName = new JTextField();
		textField_ProductName.setBounds(427, 59, 130, 26);
		frame.getContentPane().add(textField_ProductName);
		textField_ProductName.setColumns(10);

		JLabel lblProductCategory = new JLabel("Kategori:");
		lblProductCategory.setBounds(317, 64, 61, 16);
		frame.getContentPane().add(lblProductCategory);

		textField_ProductCategory = new JTextField();
		textField_ProductCategory.setBounds(427, 31, 130, 26);
		frame.getContentPane().add(textField_ProductCategory);
		textField_ProductCategory.setColumns(10);

		JLabel lblProductPrice = new JLabel("Pris:");
		lblProductPrice.setBounds(317, 92, 61, 16);
		frame.getContentPane().add(lblProductPrice);

		txtField_ProductPrice = new JTextField();
		txtField_ProductPrice.setBounds(427, 86, 130, 26);
		frame.getContentPane().add(txtField_ProductPrice);
		txtField_ProductPrice.setColumns(10);

		JButton btnCreateProduct = new JButton("Skapa");
		btnCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_ProductName.getText();
				String category = textField_ProductCategory.getText();
				Integer price = new Integer(txtField_ProductPrice.getText());				
				Product B = new Product(name, category, price);
				Boolean success = controller.addProduct(B);
				if(!textField_ProductName.getText().isEmpty() && !textField_ProductCategory.getText().isEmpty() && !txtField_ProductPrice.getText().isEmpty()) {
					if(success) {
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText(name + " är tillagd i systemet");
						textField_ProductName.setText("");
						textField_ProductCategory.setText("");
						txtField_ProductPrice.setText("");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Produkt: " + name + " finns redan i systemet");
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("inga fält under Produkt får vara tomma");
				}
			}
		});
		btnCreateProduct.setBounds(316, 125, 117, 29);
		frame.getContentPane().add(btnCreateProduct);

		JButton btnSearchProduct = new JButton("S\u00F6k");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = textField_ProductName.getText();			
				Product temp = controller.findProduct(productName);
				if(!textField_ProductName.getText().isEmpty()) {
					if(temp != null) {
						textField_ProductName.setText("");
						textArea_1.setForeground(new Color(0, 0, 0));
						textArea_1.setText("Produkt info \n ------------------------------------------ \n Namn: " + temp.getProductName() + "\n Kategori: " + temp.getCategory() + "\n Pris: " + temp.getPrice());
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen produkt med namn: " + productName);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Produktnamn krävs");
				}
			}
		});
		btnSearchProduct.setBounds(316, 166, 117, 29);
		frame.getContentPane().add(btnSearchProduct);

		JButton btnDeleteProduct = new JButton("Ta bort");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productName = textField_ProductName.getText();
				Product temp = controller.findProduct(productName);
				controller.removeProduct(productName);
				if(!textField_ProductName.getText().isEmpty()) {
					if(temp != null) {
						textField_ProductName.setText("");
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText(temp.getProductName() + " har blivit borttagen");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen produkt med namn: " + productName);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Produktnamn krävs");
				}
			}
		});
		btnDeleteProduct.setBounds(440, 125, 117, 29);
		frame.getContentPane().add(btnDeleteProduct);

		JButton btnChangeProduct = new JButton("Ändra ");
		btnChangeProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_ProductName.getText();
				String category = textField_ProductCategory.getText();
				Integer price = new Integer(txtField_ProductPrice.getText());
				Product temp = controller.findProduct(name);
				if(!textField_ProductName.getText().isEmpty() && !textField_ProductCategory.getText().isEmpty() && !txtField_ProductPrice.getText().isEmpty()) {
					if(temp != null) {
						controller.editProduct(name, category, price);
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Produkten: " + name + " Har blivit ändrad");
						textField_ProductName.setText("");
						textField_ProductCategory.setText("");
						txtField_ProductPrice.setText("");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen produkt med namn " + name);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("inga fält under Produkt får vara tomma");
				}
			}
		});
		btnChangeProduct.setBounds(440, 165, 117, 29);
		frame.getContentPane().add(btnChangeProduct);
		
		
		
		
		// The TextField, Button, Label and functions for the Product is added to the interface
		
		
		

		JLabel lblOrder = new JLabel("Order");
		lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrder.setBounds(633, 0, 89, 26);
		frame.getContentPane().add(lblOrder);

		JLabel lblOrderNumber = new JLabel("Ordernummer:");
		lblOrderNumber.setBounds(633, 64, 95, 16);
		frame.getContentPane().add(lblOrderNumber);

		textField_OrderNumber = new JTextField();
		textField_OrderNumber.setBounds(743, 59, 130, 26);
		frame.getContentPane().add(textField_OrderNumber);
		textField_OrderNumber.setColumns(10);

		JLabel lblOrderDate = new JLabel("Datum:");
		lblOrderDate.setBounds(633, 92, 61, 16);
		frame.getContentPane().add(lblOrderDate);

		textField_OrderDate = new JTextField();
		textField_OrderDate.setBounds(743, 87, 130, 26);
		frame.getContentPane().add(textField_OrderDate);
		textField_OrderDate.setColumns(10);

		JButton btnCreate_Order = new JButton("Skapa");
		btnCreate_Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = textField_OrderNumber.getText();
				String orderDate = textField_OrderDate.getText();
				String customerId = txtField_OrderCustomerId.getText();
				//Using Integer so that it is possible to discern if the order or the customer don't exist
				Integer returnValue = controller.addOrder(orderId, orderDate, customerId);
				if(!txtField_OrderCustomerId.getText().isEmpty() && !textField_OrderNumber.getText().isEmpty() && !textField_OrderDate.getText().isEmpty()) {
					//Successful action 
					if(returnValue == 1) {
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Order: " + orderId + " har skapats och tillhör kund: " + customerId);
						textField_OrderNumber.setText("");
						textField_OrderDate.setText("");
						txtField_OrderCustomerId.setText("");
					}
					//order missing
					else if(returnValue == 0) {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("finns ingen order på kund: " + customerId + " med ordernummer: " + orderId);
					}
					//customer missing
					else if(returnValue == -1) {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen kund med kundnummer: " + customerId);
					}
				}
				//text field entry missing
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Inga fält kan vara tomma");
				}
			}

		});
		btnCreate_Order.setBounds(633, 126, 117, 29);
		frame.getContentPane().add(btnCreate_Order);

		JButton btnSearch_Order = new JButton("S\u00F6k");
		btnSearch_Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = textField_OrderNumber.getText();
				Order temp = controller.findOrder(orderId);
				if(!textField_OrderNumber.getText().isEmpty()) {
					if(temp != null) {
						Customer customer = temp.getCustomer();
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Order: " + orderId + "\n Datum: " + temp.getOrderDate() + "\n Tillhör kund: " + customer.getCustomerId() + ", " + customer.getName());
						textField_OrderNumber.setText("");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen order med ordernummer: " + orderId);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Ordernummer krävs för att hitta order");

				}
			}
		});
		btnSearch_Order.setBounds(633, 166, 117, 29);
		frame.getContentPane().add(btnSearch_Order);

		JButton btnDelete_Order = new JButton("Ta bort");
		btnDelete_Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = textField_OrderNumber.getText();
				Order order = controller.removeOrder(orderId);
				if(!textField_OrderNumber.getText().isEmpty()) {
					if(order != null) {
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Order: " + orderId + " är borttagen");
						textField_OrderNumber.setText("");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen order med ordernummer: " + orderId);

					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Ordernummer krävs för att ta bort order");
				}
			}
		});
		btnDelete_Order.setBounds(756, 126, 117, 29);
		frame.getContentPane().add(btnDelete_Order);
		
		
		// The TextField, Button, Label and functions for the Order is added to the interface
		
		

		JLabel lblOrderLine = new JLabel(" Orderrad");
		lblOrderLine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrderLine.setBounds(3, 231, 139, 26);
		frame.getContentPane().add(lblOrderLine);

		JLabel lblOrderline = new JLabel(" Orderradsnummer:");
		lblOrderline.setBounds(3, 268, 148, 16);
		frame.getContentPane().add(lblOrderline);

		textField_Orderline = new JTextField();
		textField_Orderline.setBounds(153, 263, 130, 26);
		frame.getContentPane().add(textField_Orderline);
		textField_Orderline.setColumns(10);

		JLabel lblOrderLineAmount = new JLabel(" Antal:");
		lblOrderLineAmount.setBounds(3, 295, 61, 16);
		frame.getContentPane().add(lblOrderLineAmount);

		textField_OrderLineAmount = new JTextField();
		textField_OrderLineAmount.setBounds(153, 290, 130, 26);
		frame.getContentPane().add(textField_OrderLineAmount);
		textField_OrderLineAmount.setColumns(10);

		JButton btnCreate_OrderLine = new JButton("Skapa");
		btnCreate_OrderLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idNumber = textField_Orderline.getText();
				Integer amount = new Integer(textField_OrderLineAmount.getText());
				String orderId = textField_OrderNumber.getText();
				String productName = textField_ProductName.getText();
				//fix!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				Order temp1 = controller.findOrder(orderId);
				Product temp2 = controller.findProduct(productName);

				OrderLine D = new OrderLine(idNumber, amount, temp1, temp2);

				controller.addOrderLine(D);

				textArea_1.setText("Orderraden är tillagd");

			}
		});
		btnCreate_OrderLine.setBounds(3, 332, 130, 29);
		frame.getContentPane().add(btnCreate_OrderLine);

		JButton btnDelete_OrderLine = new JButton("Ta bort");
		btnDelete_OrderLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idNumber = textField_Orderline.getText();
				controller.removeOrderLine(idNumber);
				//fix!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				textArea_1.setText("Orderraden är borttagen");
			}
		});
		btnDelete_OrderLine.setBounds(153, 332, 130, 29);
		frame.getContentPane().add(btnDelete_OrderLine);
		
		
		
		// The TextField, Button, Label and functions for the Orderline is added to the interface
		
		

		JLabel lbl_Item = new JLabel("Exemplar ");
		lbl_Item.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Item.setBounds(317, 231, 116, 26);
		frame.getContentPane().add(lbl_Item);

		JLabel lbl_ItemSerialNumber = new JLabel("Serienummer:");
		lbl_ItemSerialNumber.setBounds(317, 268, 108, 16);
		frame.getContentPane().add(lbl_ItemSerialNumber);

		textField_ItemSerialNumber = new JTextField();
		textField_ItemSerialNumber.setBounds(422, 263, 130, 26);
		frame.getContentPane().add(textField_ItemSerialNumber);
		textField_ItemSerialNumber.setColumns(10);

		JButton btnCreate_Item = new JButton("Skapa");
		btnCreate_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serialNumber = textField_ItemSerialNumber.getText();
				String productId = textField_ProductName.getText();
				//fix!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				Product temp3 = controller.findProduct(productId);

				Item E = new Item(serialNumber, temp3);

				controller.addItem(E);

				textArea_1.setText("Exemplaret är tillagt");

			}
		});
		btnCreate_Item.setBounds(316, 335, 117, 29);
		frame.getContentPane().add(btnCreate_Item);

		JButton btnDelete_Item = new JButton("Ta bort");
		btnDelete_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serialNumber = textField_ItemSerialNumber.getText();
				//fix!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				controller.removeItem(serialNumber);

				textArea_1.setText("Exemplet är borttaget");
			}
		});
		btnDelete_Item.setBounds(435, 335, 117, 29);
		frame.getContentPane().add(btnDelete_Item);
		
		
		
		// The TextField, Button, Label and functions for the Item is added to the interface

		
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(199, 399, 499, 162);
		frame.getContentPane().add(textArea_1);
		
		txtField_OrderCustomerId = new JTextField();
		txtField_OrderCustomerId.setBounds(743, 32, 130, 26);
		frame.getContentPane().add(txtField_OrderCustomerId);
		txtField_OrderCustomerId.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("Kundnummer:");
		lblCustomerNumber.setBounds(633, 38, 89, 14);
		frame.getContentPane().add(lblCustomerNumber);
	}
}
