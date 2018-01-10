package IS;

public class OrderLine {
	private String idNummer;
	private int quantity;
	private Order order; // connected Order class to OrderLine//
	private Product product; // connected Product class to OrderLine

	public OrderLine(String IdNummer, int quantity, Order order, Product product) {
		this.idNummer = idNummer;
		this.quantity = quantity;
		this.order = order;
		this.product = product;

		// constructor//
	}

	public String getIdNummer() {
		return idNummer;
	}

	public void setIdNummer(String idNummer) {
		idNummer = idNummer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		quantity = quantity;
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
