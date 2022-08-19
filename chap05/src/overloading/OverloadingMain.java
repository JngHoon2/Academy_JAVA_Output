package overloading;

public class OverloadingMain {

	public static void main(String[] args) {
		OverloadingMethod mm = new OverloadingMethod();
		
		System.out.println("mm.add(3, 3)의 결과 : " + mm.add(3, 3));
		System.out.println("mm.add(3L, 3)의 결과 : " + mm.add(3L, 3));
		System.out.println("mm.add(3, 3L)의 결과 : " + mm.add(3, 3L));
		System.out.println("mm.add(3L, 3L)의 결과 : " + mm.add(3L, 3L));
	}

}
