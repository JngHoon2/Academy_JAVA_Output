package exception;

public class ExceptionEx01 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		try {
			for(int i = 0; i < 10; i++) {
				result = number/ (int)(Math.random() *10);
				System.out.println(result);
			}
		} catch (ArithmeticException ae) {
			System.out.println("연산 오류");
		}
	}
}
