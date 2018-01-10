package IS;

import java.util.ArrayList;

public class ProductRegister {

	private ArrayList<Product> productList = new ArrayList<Product>();
	private ArrayList<Item> itemList = new ArrayList<Item>();

	// Added product- and itemList to ProductRegister to make it easier to search and less code in the controller//

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public Product findProduct(String productName) {
		for (Product temp : productList) {
			if (temp.getProductName().equals(productName)) {
				return temp;
			}
		}
		return null;

	}

	// method to find a product//

	public Item findItem(String serialNumber) {
		for (Item temp : itemList) {
			if (temp.getSerialNumber().equals(serialNumber)) {
				return temp;
			}
		}
		return null;
	}

	// method to find Item//

	public Product removeProduct(String productName) {
		Product temp = this.findProduct(productName);
		if (temp != null) {
			this.productList.remove(temp);
		}
		return null;
	}

	// method to remove a Product with product name //

	public Item removeItem(String serialNumber) {
		Item temp = this.findItem(serialNumber);
		if (temp != null) {
			this.itemList.remove(temp);
		}
		return null;
	}

	// method to remove an Item with serial number //

	public void addProduct(Product productList) {
		this.productList.add(productList);
	}

	public void addItem(Item itemList) {
		this.itemList.add(itemList);
	}

	// methods to add a Product or Item to their lists //

	public Product editProduct(String productName, String category, int price) {
		Product temp = this.findProduct(productName);
		if (temp != null) {
			temp.setCategory(category);
			temp.setPrice(price);
			return temp;
		}
		return null;
	}

	// method to change and edit a products category or price //

}