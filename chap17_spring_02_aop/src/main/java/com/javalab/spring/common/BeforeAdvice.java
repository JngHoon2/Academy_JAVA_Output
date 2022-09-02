package com.javalab.spring.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	public BeforeAdvice() {}
	
	public void beforeLog() {
		System.out.println("[BeforeAdvice - 사전 처리] 비즈니스 로직 수행 전 동작");
	}
	
	public void beforeLogJp(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[BeforeAdvice -  사전 처리] " + method 
				+ "() 메소드 Args 정보 : " + args[0].toString());
	}
}
