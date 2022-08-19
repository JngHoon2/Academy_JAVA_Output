package database.vo;

public class CafeClass {
	private int rank;
	private String cafe;
	private String menu;
	private double price;
	private String address;
	private String img;
	private String url;
	
	public CafeClass() {}

	public CafeClass(int rank, String cafe, String menu, double price, String address, String url) {
		super();
		this.rank = rank;
		this.cafe = cafe;
		this.menu = menu;
		this.price = price;
		this.address = address;
		this.url = url;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getCafe() {
		return cafe;
	}

	public void setCafe(String cafe) {
		this.cafe = cafe;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
