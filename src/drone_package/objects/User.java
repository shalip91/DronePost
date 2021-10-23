package drone_package.objects;

public class User {
	private String name;
	private String addr;
	private String phoneNumber;
	private int orders;
	
	public User(String name, String addr, String phoneNumber, int orders) {
		super();
		this.setName(name);
		this.setAddr(addr);
		this.setPhoneNumber(phoneNumber);
		this.setOrders(orders);
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
