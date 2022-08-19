package classEx03.vo;

public class Book {
	private String name;
	private String author;
	private String publisher;
	private int price;
	private int quantity;
	
	public Book() {}

	public Book(String name, String author, String publisher, int price, int quantity) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", publisher=" + publisher + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
}
