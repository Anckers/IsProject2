package IS;

public class Controller {
	
	//remove this code?
	
	/*
	ProductRegister productRegister = new ProductRegister();
	CustomerRegister customerRegister = new CustomerRegister();
	*/
	
	private ProductRegister productRegister;
	private CustomerRegister customerRegister;
	
	public Controller (CustomerRegister customerRegister, ProductRegister productRegister) {
		this.customerRegister = customerRegister;
		this.productRegister = productRegister;
	}
	
	
	public Boolean addCustomer(Customer temp) {
		Boolean  success = customerRegister.addCustomer(temp);
		return success;
		
	}

	public Integer addOrder(String orderId, String orderDate, String customerId) {
		Customer customer = customerRegister.findCustomer(customerId);
		if(customer!=null) {
			Order order = new Order (orderId, orderDate, customer);
			if(customerRegister.findOrder(orderId) != null) {
			customerRegister.addOrder(order);
			return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return -1;
		}
	}

	public OrderLine addOrderLine(OrderLine temp) {
		customerRegister.addOrderLine(temp);
		return temp;
	}

	public Product addProduct(Product temp) {
		productRegister.addProduct(temp);
		return temp;
	}

	public void addItem(Item temp) {
		productRegister.addItem(temp);
		
	}

	public Customer findCustomer(String customerId) {
		Customer customer = customerRegister.findCustomer(customerId);
		if(customer != null) {
			return customer;
		}
		else {
			return null;
		}
	}

	public Product findProduct(String productName) {
		return productRegister.findProduct(productName);
	}

	public Order findOrder(String orderId) {
		return customerRegister.findOrder(orderId);
	}

	public Customer removeCustomer(String customerId) {
		Customer customer = customerRegister.removeCustomer(customerId);
		if(customer != null) {
			return customer;
		}
		else {
			return null;
		}
	}

	public Order removeOrder(String orderId) {
		return customerRegister.removeOrder(orderId);
	}

	public Product removeProduct(String productName) {
		return productRegister.removeProduct(productName);
	}

	public Item removeItem(String serialNumber) {
		return productRegister.removeItem(serialNumber);
	}

	public OrderLine removeOrderLine(String orderLineId) {
		return customerRegister.removeOrderLine(orderLineId);
	}

	public Customer editCustomer(String customerId, String name, String adress) {
		Customer customer = customerRegister.editCustomer(customerId, name, adress);
		if(customer != null) {
			return customer;
		}
		else {
			return null;
		}
	}

	public Product editProduct(String productName, String category, int price) {
		return productRegister.editProduct(productName, category, price);
	}

}
