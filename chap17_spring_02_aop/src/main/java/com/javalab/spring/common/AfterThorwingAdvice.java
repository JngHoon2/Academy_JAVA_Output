package com.javalab.spring.common;

public class AfterThorwingAdvice {
	public AfterThorwingAdvice() {}
	
	public void execeptionLog() {
		System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
