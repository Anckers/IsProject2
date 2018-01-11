package IS;

public class Customer {
	private String customerId;
	private String name;
	private String address;



	public Customer(String customerId, String name, String address) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;

		// constructor //

	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String CustomerId) {
		customerId = CustomerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		name = Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String Address) {
		address = Address;
	}
}