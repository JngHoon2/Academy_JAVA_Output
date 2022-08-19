package chap01;
import java.util.Scanner;

/**
 * 두 수를 입력 받아서 어느 수가 큰지 판별하시오.
 */

public class LogicNegationExample {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("두 개의 숫자를 입력하시오.");

		int a = scanner.nextInt(); // 첫번째 숫자
		int b = scanner.nextInt(); // 두번째 숫자
		
		numberDescision(a, b); // -> 들어가는 것이 파라미터 혹은 인자 
	}
	
	public static void numberDescision(int a, int b) { // 는 부분이 매개변수 
		if (!(a < b)) {
			aIsBig();
		} else {
			bIsBig();
		}
	}
	
	public static void aIsBig() {
		System.out.println("첫 번째 숫자가 큽니다.");
	}
	
	public static void bIsBig() {
		System.out.println("두 번째 숫자가 큽니다.");
	}
	
}