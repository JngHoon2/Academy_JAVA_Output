package board.vo;

public class Board {

	private int number;
	private String title;
	private String author;
	private int pay;
	
	public Board() {}

	public Board(int number, String title, String author, int pay) {
		super();
		this.number = number;
		this.title = title;
		this.author = author;
		this.pay = pay;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return number + "\t" + title + "\t" + author + "\t" + pay;
		 
	}
	
}
