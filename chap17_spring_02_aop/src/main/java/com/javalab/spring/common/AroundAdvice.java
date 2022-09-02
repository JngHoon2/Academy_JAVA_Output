package com.javalab.spring.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public AroundAdvice() {}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[AroundAdvdvice - BEFORE] : 비즈니스 로직 수행전 동작...");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AroundAdvdvice - AFTER] : 비즈니스 로직 수행후 동작...");
		return returnObj;
	}
}
