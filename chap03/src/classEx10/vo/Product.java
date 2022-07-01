package classEx10.vo;

public class Product {
	
	private int id;
	private String name;
	private int price;
	private int quantity;
	
	//기본 생성자 
	
	public Product() {super();}
	
	
	// 오버로딩 생성자 
	public Product(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}


	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public int getPrice() {return price;}

	public void setPrice(int price) {this.price = price;}

	public int getQuantity() {return quantity;}

	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	public void showInfo() {
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		System.out.println("price : " + price);
		System.out.println("quantity : " + quantity);
	}
}
