package classTest;

public class Customer {
	private String item;
	private String name;
	
	public Customer() {}

	public Customer(String a, String name) {
		super();
		this.item = a;
		this.name = name;
	}

	public String getA() {
		return item;
	}

	public void setA(String a) {
		this.item = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [item=" + item + ", name=" + name + "]";
	}
}
