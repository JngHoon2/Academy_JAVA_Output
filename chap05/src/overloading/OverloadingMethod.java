package overloading;

public class OverloadingMethod {
	
	public int add(int a, int b) {
		System.out.println("int add(int a, int b) - " + (a+b));
		return a + b;
	}
	
	public long add(int a, long b) {
		System.out.println("int add(int a, long b) - " + (a+b));
		return a + b;
	}
	
	public long add(long a, int b) {
		System.out.println("int add(long a, int b) - " + (a+b));
		return a + b;
	}
	
	public long add(long a, long b) {
		System.out.println("int add(long a, long b) - " + (a+b));
		return a + b;
	}
}
