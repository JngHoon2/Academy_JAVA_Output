package classEx02;

import classEx02.vo.*;

public class ProductMain {
	public static void main(String[] args) {
		ProductData pData = new ProductData();
		
		// 1
		System.out.println("1. 세탁기제품의 가격은 " + laundryPrice(pData) + "원입니다.");
		System.out.println();
		
		// 2
		System.out.println("2. 구매하신 모든제품의 총액은 " + allPrice(pData) + "원입니다.");
		System.out.println();
		
		// 3
		showExpProducts(pData);
		System.out.println();
		
		//4
		expQuntityAndSumPrice(pData);
		
	}
	
	public static int laundryPrice(ProductData pData) {
		for(Product p : pData.products) {
			if(p.getName().equals("세탁기")) {
				return p.getPrice();
			}
		}
		return 9999999;
	}
	
	public static int allPrice(ProductData pData) {
		int sum = 0;
		for(Product p : pData.products) {
			sum += p.getPrice();
		}

		return sum;
	}
	
	public static void showExpProducts(ProductData pData) {
		System.out.println("3. 100만원이 넘는 제품은 다음과 같습니다.");
		for(Product p : pData.products) {
			if(p.getPrice() > 1000000) {
				System.out.println("-----------------------------------------------------");
				System.out.println("제품ID : " + p.getId() + "\t제품Name : " + p.getName() + "\t제품Price : " + p.getPrice());
			}
		}
		System.out.println("-----------------------------------------------------");
	}
	
	public static void expQuntityAndSumPrice(ProductData pData) {
		int cnt = 0;
		int sum = 0;
		
		for(Product p : pData.products) {
			if(p.getPrice() > 1000000) {
				cnt++;
				sum += p.getPrice();
			}
		}
		System.out.println("4. 100만원이 넘는 제품의 수량은 " + cnt + "이며, 합계 금액은 " + sum + "원입니다.");
	}
}
