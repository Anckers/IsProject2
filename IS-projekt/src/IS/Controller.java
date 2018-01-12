package IS;

public class Controller {
	
	//remove this code?
	
//	ProductRegister productRegister = new ProductRegister();
//	CustomerRegister customerRegister = new CustomerRegister();

	
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
			if(customerRegister.findOrder(orderId) == null) {
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
	
	public OrderLine editOrderLineAmount(String idNumber, Integer quantity) {
		OrderLine oL = customerRegister.editOrderLineAmount(idNumber, quantity);
		if(oL != null) {
			return oL;
		}
		else {
			return null;
		}
	}
	
	public OrderLine findOrderLine(String idNumber) {
		OrderLine oL = customerRegister.findOrderLine(idNumber);
		if(oL != null) {
			return oL;
		}
		else {
			return null;
		}
	}

	public Boolean addProduct(Product temp) {
		Boolean success = productRegister.addProduct(temp);
		return success;
	}

	public void addItem(Item temp) {
		productRegister.addItem(temp);
		
	}
	
	public Item findItem(String serialNumber) {
		Item item = productRegister.findItem(serialNumber);
		if(item != null) {
			return item;
		}
		else {
			return null;
		}
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
		Product product = productRegister.findProduct(productName);
		if(product != null) {
			return product;
		}
		else {
			return null;
		}
	}

	public Order findOrder(String orderId) {
		Order order = customerRegister.findOrder(orderId);
		if(order != null) {
			return order;
		}
		else {
			return null;
		}
	}
	
	public Customer getOrderOwner(String orderId) {
		Order order = customerRegister.findOrder(orderId);
		if(order != null) {
			return order.getCustomer();
		}
		else {
			return null;
		}
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
		Product product = productRegister.removeProduct(productName);
		if(product != null) {
			return product;
		}
		else {
			return null;
		}
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
