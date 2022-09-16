package com.javalab.spring.board.advice;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {

	public AfterThrowingAdvice() {
	}
	
	@Pointcut("execution(* com.javalab.spring..*Impl.*(..))")
	public void allPointCut(){}
	
	@AfterThrowing(pointcut="allPointCut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj){
		
		String method=jp.getSignature().getName();
		System.out.println("[AfterThrowingAdvice - 예외처리] " + method +"() 메서드 수행 중 예외 발생! 상세한 오류는 다음 참조");

		if(exceptObj instanceof IllegalArgumentException){
			System.out.println("부적절한 값이 입력되었습니다.");
		}else if(exceptObj instanceof NumberFormatException){
			System.out.println("숫자 형식의 값이 아닙니다.");
		}else if(exceptObj instanceof RuntimeException){
			System.out.println("[RuntimeException SQL 오류]" + exceptObj.getMessage());
		}else if (exceptObj instanceof Exception) {
			System.out.println("문제가 발생했습니다.");
		}
	}
	
}
