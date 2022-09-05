package com.javalab.spring.board.advice;

public class LogAdvice {
	public LogAdvice() {
		
	}
	
	public void printLog() {
		System.out.println("[공통로직 - 로그기록] 비즈니스 로직 수행전 동작");
	}
}
