package com.javalab.lambda;

// 함수형 인터페이스
@FunctionalInterface
interface MyFunctionalInterface {
	public void run();  // 유일한 추상 메소드
}

// 매개 변수가 없고 return 키워드가 없는 람다 함수
public class Lambda003 {

	public static void main(String[] args) {
		MyFunctionalInterface fi;	// 함수형 인터페이스 타입 참조변수

		/*
		 * [1] 매개 변수가 없으면 빈 괄호() 사용 가능
		 *  - 구현 내용이 여러 문장이면 중괄호{}로 감싸야 함. 
		 */
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.run();
		
		// [2] 구현(실행) 내용이 한 줄이면 중괄호{}를 써도 되고
		fi = () -> {System.out.println("method call2");};
		fi.run();
		
		// [3] 구현(실행) 내용이 한 줄이면 중괄호 {} 생략 가능
		fi = () -> System.out.println("method call3");
		fi.run();
	}
}