package IS;

public class Order {

	private String orderId;
	private String orderDate;
	private Customer customer;

	public Order(String orderId, String orderDate, Customer customer) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.setCustomer(customer);

		// constructor//

	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String newOrderId) {
		orderId = newOrderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String newOrderDate) {
		orderDate = newOrderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}