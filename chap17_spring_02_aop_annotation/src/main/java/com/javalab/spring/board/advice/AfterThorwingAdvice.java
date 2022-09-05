package com.javalab.spring.board.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThorwingAdvice {
	public AfterThorwingAdvice() {}
	
	@Pointcut("execution(* com.javalab.spring..*Impl.*(..))")
	public void allPointCut() {}
	
	@AfterThrowing(pointcut = "allPointCut()", throwing = "exceptObj")
	public void execeptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] " + method + "()메소드 수행 중 예외 발생");
		
		if(exceptObj instanceof IllegalAccessException) {
			System.out.println("부적절한 값이 입력되었습니다.");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		} else if(exceptObj instanceof RuntimeException) {
			System.out.println("[RuntimeException SQL 오류]" + exceptObj.getMessage());
		} else if(exceptObj instanceof Exception) {
			System.out.println("알 수 없는 문제가 발생했습니다.");
		}
	}
}
