package IS;

public class OrderLine {
	private int quantity;
	private Order order; // connected Order class to OrderLine//
	private Product product; // connected Product class to OrderLine
	private String idNumber;


	public OrderLine(String idNumber, int quantity, Order order, Product product) {
		this.idNumber = idNumber;
		this.quantity = quantity;
		this.order = order;
		this.product = product;

		// constructor//
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getPruduct() {
		return product;
	}

	public void setPruduct(Product pruduct) {
		this.product = pruduct;
	}

}
