package classTest;

import java.util.ArrayList;

public class CustomerMain {

	public static void main(String[] args) {

		//회원 row data
		//("dream", "정명훈")
		//("marry", "이미나")
		//("tango", "문정선")
		
		// 1. 위의 raw데이터를 이용해서 클래스를 디자인하시오.
		
		// 2. 위의 raw 데이터를 이용해서 Customer 객체 3개 생성하시오
		Customer c1 = new Customer("dream", "정명훈");
		Customer c2 = new Customer("marry", "이미나");
		Customer c3 = new Customer("tango", "문정선");
		
		// 3. 생성된 3 객체를 Customer 타입 객체 배열에 담으시오.
		Customer[] cArray = {c1, c2, c3};
		
		// 4. 배열 객체를 통해서 회원 객체를 출력하시오.
		System.out.println("=========객체 배열을 이용한 출력==========");
		for(Customer c : cArray) {
			System.out.println(c.toString());
		}
		
		// 5. 2.번에서 생성된 Customer 객체 3개를 ArrayList에 담으시오.
		ArrayList<Customer> cArrayList = new ArrayList<Customer>();
		cArrayList.add(c1);
		cArrayList.add(c2);
		cArrayList.add(c3);
		
		// 6. ArrayList 통해서 회원 객체를 출력하시오.
		System.out.println("========= ArrayList를 이용한 출력==========");
		for(Customer c : cArrayList) {
			System.out.println(c.toString());
		}
		
		MethodClass mc = new MethodClass();
		
		mc.initData();
		// 7. 4.번을 메소드로 빼서 모듈화 하시오.
		mc.module1();
		
		// 8. 6.번을 메소드로 빼서 모듈화 하시오.
		mc.module2();
		
		
		
		
	}
	
	
}