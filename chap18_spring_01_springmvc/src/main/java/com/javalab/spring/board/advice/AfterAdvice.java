package com.javalab.spring.board.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * [애스펙트 객체]
 * [어드바이스 클래스]
 *  - 스프링 설정파일에 빈(Bean)으로 등록될 수 있게 설정하거나
 *  - 어드바이스 클래스에 @Service @Aspect 어노테이션이 붙어 있어야 스프링 컨테이너에 등록될 수 있다.
 */

//@Service
//@Aspect
public class AfterAdvice {

	public AfterAdvice() {
	}

	/*
	 * [포인트컷]
	 * - 포인트컷 적용 대상 메소드 : com.javalab.spring..*Impl.*(..))
	 */
	@Pointcut("execution(* com.javalab.spring..*Impl.*(..))")
	public void allPointCut(){}	// 포인트컷 참조 메소드
	
	/*
	 * [Aspect]
	 *  - Advice 메소드
	 *  - 위에서 선언한 allPointCut의 메소드가 정해놓은 메소드들이 실행되고 난 후에
	 *    이 메소드(부가적인 관심사)가 실행(호출)된다.
	 */
	@After("allPointCut()")
	public void finallyLog(){
		System.out.println("[AfterAdvice - 사후처리] 비지니스 로직 수행 후 무조건 동작");
	}
}
