package classEx06.vo;

public class Product {
	public int id;
	public String name;
	public int price;
	public int quantity;
	
	public Product() {System.out.println("여기는 기본생성자입니다.");}
	
	public Product(int id, String name, int price, int quantitiy) {
		System.out.println("여기는 오버로딩 생성자입니다.");
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantitiy;
	}
	
	public int getAmount() {
		return price * quantity;
	}
	
	public void showInfo() {
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		System.out.println("price : " + price);
		System.out.println("quantity : " + quantity);
	}
	
}
