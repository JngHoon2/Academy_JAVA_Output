package com.javalab.spring.board.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AroundAdvice {
	public AroundAdvice() {}
	
	@Pointcut("execution(* com.javalab.spring..*Impl.*(..))")
	public void allPointCut() {}
	
	@Around("allPointCut")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[AroundAdvdvice - BEFORE] : 비즈니스 로직 수행전 동작...");
		
		Object returnObj = pjp.proceed();
		
		System.out.println("[AroundAdvdvice - AFTER] : 비즈니스 로직 수행후 동작...");
		return returnObj;
	}
}
