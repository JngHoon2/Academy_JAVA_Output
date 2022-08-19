package chap01;

public class MathRoundMethod {
	public static void main(String args[]) {
		double pi = 3.141592265;
		System.out.println(Math.round(pi)); // 반올림된 정수
		System.out.println(Math.round(pi * 100)); // 314
		System.out.println(Math.round(pi * 100) / (double) 100); // 314/100.0 = 3.14
		System.out.println(Math.round(pi * 1000) / (double) 1000); // 3.142
	}
}
