package IS;

public class Item {

	private String serialNumber;
	private Product product; // connected Product class to Item//

	public Item(String serialNumber, Product product) {
		this.serialNumber = serialNumber;
		this.product = product;

		// constructor//
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
