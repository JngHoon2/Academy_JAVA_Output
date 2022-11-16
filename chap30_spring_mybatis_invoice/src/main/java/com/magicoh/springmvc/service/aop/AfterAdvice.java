package com.magicoh.springmvc.service.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class AfterAdvice {

	// [포인트컷]
	@Pointcut("execution(* com.magicoh.biz..*Impl.*(..))")
	public void allPointcut(){}

	//Aspect
	@After("allPointcut()")
	public void finallyLog(){
		System.out.println("[AfterAdvice - 사후처리] 비지니스 로직 수행 후 무조건 동작");
	}
}
