package classEx11.vo;

public class Fruit {
	
	private int id;
	private String name;
	private int price;
	
	public Fruit() {}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public int getPrice() {return price;}

	public void setPrice(int price) {this.price = price;}
	
	
	
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	public Fruit(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public void showInfo() {
		System.out.println("ID : " + id);
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price);
	}
}
