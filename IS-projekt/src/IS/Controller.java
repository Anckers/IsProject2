package IS;

public class Controller {
	ProductRegister productRegister = new ProductRegister();
	CustomerRegister customerRegister = new CustomerRegister();

	public void addCustomer(Customer temp) {
		customerRegister.addCustomer(temp);
	}

	public void addOrder(Order temp) {
		customerRegister.addOrder(temp);
	}

	public void addOrderLine(OrderLine temp) {
		customerRegister.addOrderLine(temp);
	}

	public void addProduct(Product temp) {
		productRegister.addProduct(temp);
	}

	public void addItem(Item temp) {
		productRegister.addItem(temp);
	}

	public Customer findCustomer(String customerId) {
		return customerRegister.findCustomer(customerId);
	}

	public Product findProduct(String productName) {
		return productRegister.findProduct(productName);
	}

	public Order findOrder(String orderId) {
		return customerRegister.findOrder(orderId);
	}

	public Customer removeCustomer(String customerId) {
		return customerRegister.removeCustomer(customerId);
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

	public Customer editCutomer(String CutomerId, String name, String adress) {
		return customerRegister.editCustomer(CutomerId, name, adress);
	}

	public Product editProduct(String productName, String category, int price) {
		return productRegister.editProduct(productName, category, price);
	}

}
