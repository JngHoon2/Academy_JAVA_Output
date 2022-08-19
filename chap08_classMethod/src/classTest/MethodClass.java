package classTest;

import java.util.ArrayList;

public class MethodClass {
	private static Customer[] cArray = new Customer[3];
	private static ArrayList<Customer> cArrayList = new ArrayList<Customer>();
	
	public static void initData() {
		Customer c1 = new Customer("dream2", "정명훈2");
		Customer c2 = new Customer("marry2", "이미나2");
		Customer c3 = new Customer("tango2", "문정선2");
		
		cArray[0] = c1;
		cArray[1] = c2;
		cArray[2] = c3;
		
		cArrayList.add(c1);
		cArrayList.add(c2);
		cArrayList.add(c3);
	}
	
	public static void module1() {
		System.out.println("=========MethodClass 객체 배열 메소드를 이용한 출력==========");
		for(Customer c : cArray) {
			System.out.println(c.toString());
		}
	}
	
	public static void module2() {
		System.out.println("=========MethodClass ArrayList 메소드를 이용한 출력==========");
		for(Customer c : cArrayList) {
			System.out.println(c.toString());
		}
	}

	public static Customer[] getcArray() {
		return cArray;
	}

	public static void setcArray(Customer[] cArray) {
		MethodClass.cArray = cArray;
	}

	public static ArrayList<Customer> getcArrayList() {
		return cArrayList;
	}

	public static void setcArrayList(ArrayList<Customer> cArrayList) {
		MethodClass.cArrayList = cArrayList;
	}
	
	
}
