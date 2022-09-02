package com.javalab.spring.common;

public class Log4JAdvice {
	public Log4JAdvice() {}
	
	public void printLogging() {
		System.out.println("[공통로직-Log4j] 비즈니스 로직 수행전 동작");
	}
}
