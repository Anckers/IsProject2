package IS;

public class Product {
	private String productName;
	private String category;
	private int price;

	public Product(String productName, String category, int price) {
		this.productName = productName;
		this.category = category;
		this.price = price;

		// constructor//
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
