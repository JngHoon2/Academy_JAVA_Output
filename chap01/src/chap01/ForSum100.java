package chap01;

public class ForSum100 {

	public static void main(String[] args) {

		int a = 0;
		int b = 0;
		
		// 2의 배수
		for (int i = 1; i <= 100; i++) {
			if(i % 2 == 0)
				a += i;
		}

		// 3의 배수
		for (int i = 1; i <= 100; i++) {
			if(i % 3 == 0)
				b += i;
		}
		
		System.out.println("2의 배수들의 합: " + a);
		System.out.println("3의 배수들의 합: " + b);
	}

}
