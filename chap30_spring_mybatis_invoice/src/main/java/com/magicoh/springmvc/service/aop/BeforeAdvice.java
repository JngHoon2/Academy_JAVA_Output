package com.magicoh.springmvc.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class BeforeAdvice {

	public BeforeAdvice() {
	}
	
	//PointCutCommon allPointcut
	@Before("PointCutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp){
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[BeforeAdvice - 사전처리] "+method+"() 메서드 파라미터 정보 : "+args[0].toString());
	}

}
