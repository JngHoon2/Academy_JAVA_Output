package com.javalab.spring.board.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class AfterAdvice {
	public AfterAdvice() {}
	
	@Pointcut("execution(* com.javalab.spring..*Impl.*(..))")
	public void allPointCut() {}
	
	@After("allPointCut()")
	public void finallyLog() {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 무조건 동작");
	}
}
