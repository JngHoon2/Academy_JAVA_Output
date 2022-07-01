package classEx10;

import classEx10.vo.*;

public class ProductMain {

	public static void main(String[] args) {
		Product product = new Product();
		product.setId(202103001);
		product.setName("냉장고");
		product.setPrice(450);
		product.setQuantity(5);
		
		product.showInfo();
		System.out.println();
		
		Product product2 = new Product(202103002, "세탁기", 250, 9);
		product2.showInfo();
		System.out.println();

		Product product3 = new Product(202103003, "OLED TV", 300, 5);
		product3.showInfo();
		System.out.println();
		
		System.out.println("============= 객체배열을 통한 일괄조회 =============");
		
		Product[] array = {product, product2, product3};
		
		for(Product item: array) {
			item.showInfo();
			System.out.println("===============");
		}
	}

}
