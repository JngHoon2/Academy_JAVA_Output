package classEx05;

public class ProductMain {

	public static void main(String[] args) {
		
		Product product = new Product();
		product.id = 202103001;
		product.name = "냉장고";
		product.price = 450;
		product.quantity = 5;
		product.showInfo();
		System.out.println();
		
		Product product2 = new Product(202103002, "세탁기", 250, 15);
		product2.showInfo();
		
		System.out.println();
		
		System.out.println("p1 Amount : " + product.getAmount());
		System.out.println("p2 Amount : " + product2.getAmount());
	}

}
