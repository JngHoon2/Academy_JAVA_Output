package file.vo;

public class NewsClass {
	private String press = "";		// 신문사 이름
	private String img = "";			// 대표이미지
	private String url = "";			// URL 
	private String category = ""; 	// 종류
	
	public NewsClass() {}

	public NewsClass(String img, String url) {
		super();
		this.img = img;
		this.url = url;
	}
	
	public NewsClass(String press, String img, String url, String category) {
		super();
		this.press = press;
		this.img = img;
		this.url = url;
		this.category = category;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "NewsClass [press=" + press + ", img=" + img + ", url=" + url + ", category=" + category + "]";
	}
	
	
}
