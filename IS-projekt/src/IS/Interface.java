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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Interface {

	private JFrame frame;
	private Controller controller; 
	private ProductRegister productRegister;
	private CustomerRegister customerRegister;
	private JTextField textField_CustomerNumber;
	private JTextField textFeild_Name;
	private JTextField textField_Address;
	private JTextField textField_ProductName;
	private JTextField textField_ProductCategory;
	private JTextField textField_ProductPrice;
	private JTextField textField_OrderNumber;
	private JTextField textField_OrderDate;
	private JTextField textField_OrderlineId;
	private JTextField textField_OrderLineAmount;
	private JTextField textField_ItemSerialNumber;
	private JTextArea textArea_1;
	private JTextField textField_OrderCustomerId;
	private JTextField textField_OrderLineProductName;

	
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
		customerRegister = new CustomerRegister();
		productRegister = new ProductRegister();
		controller = new Controller (customerRegister, productRegister);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 929, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCustomerNbr = new JLabel(" Kundnummer:");
		lblCustomerNbr.setBounds(3, 37, 139, 16);
		frame.getContentPane().add(lblCustomerNbr);

		textField_CustomerNumber = new JTextField();
		textField_CustomerNumber.setBounds(119, 33, 130, 26);
		frame.getContentPane().add(textField_CustomerNumber);
		textField_CustomerNumber.setColumns(10);

		JLabel lblName = new JLabel(" Namn:");
		lblName.setBounds(3, 65, 61, 16);
		frame.getContentPane().add(lblName);

		textFeild_Name = new JTextField();
		textFeild_Name.setBounds(119, 60, 130, 26);
		frame.getContentPane().add(textFeild_Name);
		textFeild_Name.setColumns(10);

		JLabel lblAdress = new JLabel(" Adress:");
		lblAdress.setBounds(3, 92, 61, 16);
		frame.getContentPane().add(lblAdress);

		textField_Address = new JTextField();
		textField_Address.setBounds(119, 87, 130, 26);
		frame.getContentPane().add(textField_Address);
		textField_Address.setColumns(10);

		JButton btnCreateCustomer = new JButton("Skapa");
		btnCreateCustomer.setFocusable(false);
		btnCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerId = textField_CustomerNumber.getText();
				String name = textFeild_Name.getText();
				String address = textField_Address.getText();
				Customer A = new Customer(customerId, name, address);
				//adds Customer creates a argument that allow for actions to be performed if successful
				Boolean success = controller.addCustomer(A);
				//Controls that required fields are not empty
				if(!textField_CustomerNumber.getText().isEmpty() && !textFeild_Name.getText().isEmpty() && !textField_Address.getText().isEmpty()) {
					//performs action when button is successful
					if (success) {
						//changes color of the txtArea
						textArea_1.setForeground(new Color(0, 128, 0));
						//success message in txtArea
						textArea_1.setText(name + " är tillagd i systemet");
						//empties txtFeild's
						textField_CustomerNumber.setText("");
						textFeild_Name.setText("");
						textField_Address.setText("");
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
		btnSearchCustomer.setFocusable(false);
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = textField_CustomerNumber.getText();
				Customer temp = controller.findCustomer(customId);
				if(!textField_CustomerNumber.getText().isEmpty()) {
					if(temp != null) {
						textField_CustomerNumber.setText("");
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
		btnDeleteCustomer.setFocusable(false);
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = textField_CustomerNumber.getText();
				Customer temp = controller.findCustomer(customId);
				controller.removeCustomer(customId);				
				if(!textField_CustomerNumber.getText().isEmpty()) {
					if(temp != null) {
						textField_CustomerNumber.setText("");
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
		btnChangeCustomer.setFocusable(false);
		btnChangeCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customId = textField_CustomerNumber.getText();
				String name = textFeild_Name.getText();
				String address = textField_Address.getText();
				Customer temp = controller.findCustomer(customId);
				if(!textField_CustomerNumber.getText().isEmpty() && !textFeild_Name.getText().isEmpty() && !textField_Address.getText().isEmpty()) {
					if(temp != null) {
						controller.editCustomer(customId, name, address);
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Kundnummer: " + customId + " Har blivit ändrad");
						textField_CustomerNumber.setText("");
						textFeild_Name.setText("");
						textField_Address.setText("");
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
		textField_ProductName.setBounds(427, 33, 130, 26);
		frame.getContentPane().add(textField_ProductName);
		textField_ProductName.setColumns(10);

		JLabel lblProductCategory = new JLabel("Kategori:");
		lblProductCategory.setBounds(317, 64, 61, 16);
		frame.getContentPane().add(lblProductCategory);

		textField_ProductCategory = new JTextField();
		textField_ProductCategory.setBounds(427, 60, 130, 26);
		frame.getContentPane().add(textField_ProductCategory);
		textField_ProductCategory.setColumns(10);

		JLabel lblProductPrice = new JLabel("Pris:");
		lblProductPrice.setBounds(317, 92, 61, 16);
		frame.getContentPane().add(lblProductPrice);

		textField_ProductPrice = new JTextField();
		textField_ProductPrice.setBounds(427, 87, 130, 26);
		frame.getContentPane().add(textField_ProductPrice);
		textField_ProductPrice.setColumns(10);

		JButton btnCreateProduct = new JButton("Skapa");
		btnCreateProduct.setFocusable(false);
		btnCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_ProductName.getText();
				String category = textField_ProductCategory.getText();
				String priceTemp = textField_ProductPrice.getText();
				if(!textField_ProductName.getText().isEmpty() && !textField_ProductCategory.getText().isEmpty() && !textField_ProductPrice.getText().isEmpty()) {
					//checks if "textField_ProductPrice" only consists of numbers otherwise error message on line 300 apears
					if(priceTemp.matches("[0-9]+")) {
						//changes the text from "String priceTemp = textField_ProductPrice.getText();" to Integer format. had to be done inside the line 279 to not cause an error
						int price = Integer.parseInt(priceTemp);
						Product B = new Product(name, category, price);
						Boolean success = controller.addProduct(B);
						if(success) {
							textArea_1.setForeground(new Color(0, 128, 0));
							textArea_1.setText(name + " är tillagd i systemet");
							textField_ProductName.setText("");
							textField_ProductCategory.setText("");
							textField_ProductPrice.setText("");
						}
						else {
							textArea_1.setForeground(new Color(255, 0, 0));
							textArea_1.setText("Produkt: " + name + " finns redan i systemet");
						}
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Pris får endast anges i siffror");
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
		btnSearchProduct.setFocusable(false);
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
		btnDeleteProduct.setFocusable(false);
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
		btnChangeProduct.setFocusable(false);
		btnChangeProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_ProductName.getText();
				String category = textField_ProductCategory.getText();
				String priceTemp = textField_ProductPrice.getText();
				Product temp = controller.findProduct(name);
				if(!textField_ProductName.getText().isEmpty() && !textField_ProductCategory.getText().isEmpty() && !textField_ProductPrice.getText().isEmpty()) {
					if(priceTemp.matches("[0-9]+")) {
					int price = Integer.parseInt(priceTemp);
					if(temp != null) {
						controller.editProduct(name, category, price);
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Produkten: " + name + " Har blivit ändrad");
						textField_ProductName.setText("");
						textField_ProductCategory.setText("");
						textField_ProductPrice.setText("");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen produkt med namn " + name);
						}
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Pris får endast anges i siffror");
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
		lblOrder.setBounds(623, 0, 89, 26);
		frame.getContentPane().add(lblOrder);

		JLabel lblOrderNumber = new JLabel("Ordernummer:");
		lblOrderNumber.setBounds(623, 64, 95, 16);
		frame.getContentPane().add(lblOrderNumber);

		textField_OrderNumber = new JTextField();
		textField_OrderNumber.setBounds(733, 60, 170, 26);
		frame.getContentPane().add(textField_OrderNumber);
		textField_OrderNumber.setColumns(10);

		JLabel lblOrderDate = new JLabel("Datum:");
		lblOrderDate.setBounds(623, 92, 61, 16);
		frame.getContentPane().add(lblOrderDate);

		textField_OrderDate = new JTextField();
		textField_OrderDate.setBounds(733, 87, 170, 26);
		frame.getContentPane().add(textField_OrderDate);
		textField_OrderDate.setColumns(10);

		JButton btnCreate_Order = new JButton("Skapa");
		btnCreate_Order.setFocusable(false);
		btnCreate_Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = textField_OrderNumber.getText();
				String orderDate = textField_OrderDate.getText();
				String customerId = textField_OrderCustomerId.getText();
				//Using Integer so that it is possible to discern if the order or the customer don't exist
				Integer returnValue = controller.addOrder(orderId, orderDate, customerId);
				if(!textField_OrderCustomerId.getText().isEmpty() && !textField_OrderNumber.getText().isEmpty() && !textField_OrderDate.getText().isEmpty()) {
					//Successful action 
					if(returnValue == 1) {
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Order: " + orderId + " har skapats och tillhör kund: " + customerId);
						textField_OrderNumber.setText("");
						textField_OrderDate.setText("");
						textField_OrderCustomerId.setText("");
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
		btnCreate_Order.setBounds(623, 126, 130, 29);
		frame.getContentPane().add(btnCreate_Order);

		JButton btnSearch_Order = new JButton("S\u00F6k");
		btnSearch_Order.setFocusable(false);
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
		btnSearch_Order.setBounds(623, 166, 130, 29);
		frame.getContentPane().add(btnSearch_Order);

		JButton btnDelete_Order = new JButton("Ta bort");
		btnDelete_Order.setFocusable(false);
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
		btnDelete_Order.setBounds(773, 126, 130, 29);
		frame.getContentPane().add(btnDelete_Order);
		
		
		// The TextField, Button, Label and functions for the Order is added to the interface
		
		

		JLabel lblOrderLine = new JLabel(" Orderrad");
		lblOrderLine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOrderLine.setBounds(623, 231, 139, 26);
		frame.getContentPane().add(lblOrderLine);

		JLabel lblOrderline = new JLabel(" Orderradsnummer:");
		lblOrderline.setBounds(623, 268, 148, 16);
		frame.getContentPane().add(lblOrderline);

		textField_OrderlineId = new JTextField();
		textField_OrderlineId.setBounds(746, 263, 157, 26);
		frame.getContentPane().add(textField_OrderlineId);
		textField_OrderlineId.setColumns(10);

		JLabel lblOrderLineAmount = new JLabel(" Antal:");
		lblOrderLineAmount.setBounds(623, 295, 61, 16);
		frame.getContentPane().add(lblOrderLineAmount);

		textField_OrderLineAmount = new JTextField();
		textField_OrderLineAmount.setBounds(746, 290, 157, 26);
		frame.getContentPane().add(textField_OrderLineAmount);
		textField_OrderLineAmount.setColumns(10);

		JButton btnCreate_OrderLine = new JButton("Skapa");
		btnCreate_OrderLine.setFocusable(false);
		btnCreate_OrderLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = textField_OrderNumber.getText();
				String idNumber = textField_OrderlineId.getText();
				String amountTemp = textField_OrderLineAmount.getText();
				String productName = textField_OrderLineProductName.getText();
				if(!textField_OrderNumber.getText().isEmpty()) {
					if(!textField_OrderLineAmount.getText().isEmpty() && !textField_OrderlineId.getText().isEmpty() && !textField_OrderLineProductName.getText().isEmpty()) {
						if(amountTemp.matches("[0-9]+")) {
							Order temp1 = controller.findOrder(orderId);
							if(temp1 != null) {
								Product temp2 = controller.findProduct(productName);
								if(temp2 != null) {
									int amount = Integer.parseInt(amountTemp);
									OrderLine D = new OrderLine(idNumber, amount, temp1, temp2);
									controller.addOrderLine(D);
									textArea_1.setForeground(new Color(0, 0, 0));
									textArea_1.setText("följande är information är nu tillagd\n" + "Order: " + orderId + "\n" + "Orderrad: " + idNumber + "\n" + "Produkt: " + productName + "\n" + "Antal: " + amountTemp);
									textField_OrderlineId.setText("");
									textField_OrderLineAmount.setText("");
									textField_OrderLineProductName.setText("");
								}
								else {
									textArea_1.setForeground(new Color(255, 0, 0));
									textArea_1.setText("Finns ingen Produkt med namn: " + orderId);
								}
							}
							else {
								textArea_1.setForeground(new Color(255, 0, 0));
								textArea_1.setText("Finns ingen Order med ordernummer: " + orderId);
							}
						}
						else {
							textArea_1.setForeground(new Color(255, 0, 0));
							textArea_1.setText("Antal får endast anges i siffror");
						}
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Alla fält i Orderrad måste vara fyllda för att kunna lägga till en ny orderrad");
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Ordernummer under Order krävs för att kunna lägga till en orderrad");

				}
			}
		});
		btnCreate_OrderLine.setBounds(623, 368, 130, 29);
		frame.getContentPane().add(btnCreate_OrderLine);

		JButton btnDelete_OrderLine = new JButton("Ta bort");
		btnDelete_OrderLine.setFocusable(false);
		btnDelete_OrderLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idNumber = textField_OrderlineId.getText();
				if(!textField_OrderlineId.getText().isEmpty()) {
					OrderLine oL = controller.removeOrderLine(idNumber);
					if(oL != null) {
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Orderraden: " + idNumber + " är nu borttagen");
						textField_OrderlineId.setText("");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns ingen Orderrad med nummer: " + idNumber);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Orderradsnummer krävs för att kunna ta bort orderrad");
				}
			}
		});
		btnDelete_OrderLine.setBounds(773, 368, 130, 29);
		frame.getContentPane().add(btnDelete_OrderLine);
		
		
		
		// The TextField, Button, Label and functions for the OrderLine is added to the interface
		
		

		JLabel lbl_Item = new JLabel("Exemplar ");
		lbl_Item.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Item.setBounds(317, 231, 116, 26);
		frame.getContentPane().add(lbl_Item);

		JLabel lbl_ItemSerialNumber = new JLabel("Serienummer:");
		lbl_ItemSerialNumber.setBounds(317, 268, 108, 16);
		frame.getContentPane().add(lbl_ItemSerialNumber);

		textField_ItemSerialNumber = new JTextField();
		textField_ItemSerialNumber.setBounds(427, 263, 130, 26);
		frame.getContentPane().add(textField_ItemSerialNumber);
		textField_ItemSerialNumber.setColumns(10);

		JButton btnCreate_Item = new JButton("Skapa");
		btnCreate_Item.setFocusable(false);
		btnCreate_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serialNumber = textField_ItemSerialNumber.getText();
				String productId = textField_ProductName.getText();
				Product temp3 = controller.findProduct(productId);
				Item E = new Item(serialNumber, temp3);
				if(!textField_ItemSerialNumber.getText().isEmpty() && !textField_ProductName.getText().isEmpty()) {
					if(temp3 != null) {
						controller.addItem(E);
						textArea_1.setForeground(new Color(0, 0, 0));
						textArea_1.setText(productId + "\n" + "Exemplar: " + serialNumber + "\n" + "Är tillagt");
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("finns ingen produkt med namn: " + productId);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Produktnam och Serienummer krävs");
				}
			}
		});
		btnCreate_Item.setBounds(316, 335, 117, 29);
		frame.getContentPane().add(btnCreate_Item);

		JButton btnDelete_Item = new JButton("Ta bort");
		btnDelete_Item.setFocusable(false);
		btnDelete_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serialNumber = textField_ItemSerialNumber.getText();
				if(!textField_ItemSerialNumber.getText().isEmpty()) {
					Item item = controller.findItem(serialNumber);
					if(item != null) {
						textArea_1.setForeground(new Color(0, 128, 0));
						textArea_1.setText("Exemplar med Serienummer: " + serialNumber + "är borttaget");
						controller.removeItem(serialNumber);
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Finns inget exemplar med Serienummer: " + serialNumber);
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Serienummer krävs");
				}
			}
		});
		btnDelete_Item.setBounds(435, 335, 117, 29);
		frame.getContentPane().add(btnDelete_Item);
		
		
		
		// The TextField, Button, Label and functions for the Item is added to the interface

		
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(10, 399, 499, 162);
		frame.getContentPane().add(textArea_1);
		
		textField_OrderCustomerId = new JTextField();
		textField_OrderCustomerId.setBounds(733, 33, 170, 26);
		frame.getContentPane().add(textField_OrderCustomerId);
		textField_OrderCustomerId.setColumns(10);
		
		JLabel lblCustomerNumber = new JLabel("Kundnummer:");
		lblCustomerNumber.setBounds(623, 38, 89, 14);
		frame.getContentPane().add(lblCustomerNumber);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(586, 0, 1, 465);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(586, 463, 327, 2);
		frame.getContentPane().add(separator_1);
		
		textField_OrderLineProductName = new JTextField();
		textField_OrderLineProductName.setBounds(746, 317, 157, 26);
		frame.getContentPane().add(textField_OrderLineProductName);
		textField_OrderLineProductName.setColumns(10);
		
		JLabel lblOrderLineProductName = new JLabel("Produktnamn:");
		lblOrderLineProductName.setBounds(625, 322, 89, 14);
		frame.getContentPane().add(lblOrderLineProductName);
		
		JButton btnClearTextArea = new JButton("T\u00F6m textrutan");
		btnClearTextArea.setFocusable(false);
		btnClearTextArea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");	
			}
		});
		btnClearTextArea.setBounds(10, 349, 132, 37);
		frame.getContentPane().add(btnClearTextArea);
		
		JButton btnClearAllTextFeildsAndTextArea = new JButton("T\u00F6m alla f\u00E4lt");
		btnClearAllTextFeildsAndTextArea.setFocusable(false);
		btnClearAllTextFeildsAndTextArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");
				textFeild_Name.setText("");
				textField_Address.setText("");
				textField_CustomerNumber.setText("");
				textField_ItemSerialNumber.setText("");
				textField_OrderCustomerId.setText("");
				textField_OrderDate.setText("");
				textField_OrderlineId.setText("");
				textField_OrderLineAmount.setText("");
				textField_OrderLineProductName.setText("");
				textField_OrderNumber.setText("");
				textField_ProductCategory.setText("");
				textField_ProductName.setText("");
				textField_ProductPrice.setText("");
			}
		});
		btnClearAllTextFeildsAndTextArea.setBounds(10, 299, 132, 37);
		frame.getContentPane().add(btnClearAllTextFeildsAndTextArea);
		
		JButton btnOrderLineChangeAmount = new JButton("\u00C4ndra antal");
		btnOrderLineChangeAmount.setFocusable(false);
		btnOrderLineChangeAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serialNumer = textField_OrderlineId.getText();
				String amountTemp = textField_OrderLineAmount.getText();
				if(!textField_OrderlineId.getText().isEmpty() && !textField_OrderLineAmount.getText().isEmpty()) {
					if(amountTemp.matches("[0-9]+")) {
						OrderLine oL = controller.findOrderLine(serialNumer);
						int quantity = Integer.parseInt(amountTemp);
						if(oL != null) {
							controller.editOrderLineAmount(serialNumer, quantity);
							textArea_1.setForeground(new Color(255, 0, 0));
							textArea_1.setText("Orderrad: " + serialNumer + "\n" + "Produkt: " + oL.getPruduct() + "\n" + "Antal: " + oL.getQuantity());
						}
						else {
							textArea_1.setForeground(new Color(255, 0, 0));
							textArea_1.setText("finns ingen orderrad med nummer: " + serialNumer);
						}
					}
					else {
						textArea_1.setForeground(new Color(255, 0, 0));
						textArea_1.setText("Antal får endast anges i siffror");
					}
				}
				else {
					textArea_1.setForeground(new Color(255, 0, 0));
					textArea_1.setText("Orderradsnummer och Antal krävs");
				}
			}
		});
		btnOrderLineChangeAmount.setBounds(623, 408, 130, 29);
		frame.getContentPane().add(btnOrderLineChangeAmount);
	}
}
