package javabean;

public class SingleTonMain {
	public static void main(String[] args) {
		
		SingleTonClass x = SingleTonClass.getInstance();
		SingleTonClass y = SingleTonClass.getInstance();
		SingleTonClass z = SingleTonClass.getInstance();
		
		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
		System.out.println(z.hashCode());
		
		if(x == y && y == z) {
			System.out.println("3 객체의 메모리 주소는 같으므로 모두 같은 객체");
		} else {
			System.out.println("메모리 주소 상이");
		}
	}
}
