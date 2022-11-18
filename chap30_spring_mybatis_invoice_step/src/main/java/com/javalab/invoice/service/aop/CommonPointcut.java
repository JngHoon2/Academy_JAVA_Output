package com.javalab.invoice.service.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
/**
 * 포인트컷만 모아놓은 클래스
 */
public class CommonPointcut {
	
	// 서비스 Layer의 전체 *Impl.java 클래스가 적용대상
	@Pointcut("execution(* com.javalab.invoice.service..*Impl.*(..))")
	public void allPointcut(){}
	
	//서비스 Layer의 *Impl.java 클래스중에서 get*()가 적용대상
	@Pointcut("execution(* com.javalab.invoice.service..*Impl.get*(..))")
	public void getPointcut(){}

}
