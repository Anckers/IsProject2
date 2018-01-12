package IS;

import java.util.ArrayList;

public class CustomerRegister {
	private ArrayList<Order> orderList = new ArrayList<>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();

	// Added order-, customer- and orderList to CustomerRegister to make it easier
	// to search and less code in the controller//

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public ArrayList<OrderLine> getOrdeLineList() {
		return orderLineList;
	}

	public void setOrdeLineList(ArrayList<OrderLine> ordeLineList) {
		this.orderLineList = ordeLineList;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> OrderList) {
		orderList = OrderList;

	}

	public Customer findCustomer(String customerId) {
		for (Customer temp : customerList) {
			if (temp.getCustomerId().equals(customerId)) {
				return temp;
			}
		}
		return null;
	}

	// method to find a Customer with their customer id"

	public Order findOrder(String orderId) {
		for (Order temp : orderList) {
			if (temp.getOrderId().equals(orderId)) {
				return temp;
			}
		}
		return null;
	}

	// method to find an Order with the order id //

	public OrderLine findOrderLine(String idNumber) {
		for (OrderLine temp : orderLineList) {
			if (temp.getIdNumber().equals(idNumber)) {
				return temp;
			}
		}
		return null;
	}

	// method to find an Orderline with id number//

	public Customer removeCustomer(String customerId) {
		Customer temp = this.findCustomer(customerId);
		if (temp != null) {
			this.customerList.remove(temp);
		}
		return null;
	}

	// method to remove a Customer from the customer list with their customerId//

	public Order removeOrder(String orderId) {
		Order temp = this.findOrder(orderId);
		if (temp != null) {
			this.orderList.remove(temp);
		}
		return null;
	}

	// method to remove an order from the order list with order id //

	public OrderLine removeOrderLine(String idNumber) {
		OrderLine temp = this.findOrderLine(idNumber);
		if (temp != null) {
			this.orderLineList.remove(temp);
		}
		return null;
	}

	// method to remove an orderline from the orderline list with the id number//

	public Boolean addCustomer(Customer customer) {
		if(!customerList.contains(customer)) {
			this.customerList.add(customer);
			return true;
		}
		else {
			return false;
		}
	}

	public void addOrderLine(OrderLine orderLineList) {
		this.orderLineList.add(orderLineList);
	}
	
	public OrderLine editOrderLineAmount(String idNumber, Integer quantity) {
		OrderLine temp = this.findOrderLine(idNumber);
		if (temp != null) {
			temp.setQuantity(quantity);
			return temp;
		}
		return null;
	}

	public void addOrder(Order orderList) {
		this.orderList.add(orderList);
	}

	// methods to add a new Customer, Orderline or Order to their lists //

	public Customer editCustomer(String customerId, String name, String address) {
		Customer temp = this.findCustomer(customerId);
		if (temp != null) {
			temp.setName(name);
			temp.setAddress(address);
			return temp;
		}
		return null;
	}

	// method to edit or change a Customers name or address with their customer id
	// //

}