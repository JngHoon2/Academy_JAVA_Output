package com.javalab.spring.board.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	
	public AfterReturningAdvice() {}
	
	@AfterReturning(pointcut = "PointCutCommon.getPointCut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			
			if(user.getRole().equals("admin")) {
				System.out.println(user.getName() + "로그인(admin)");
			}
		}
		System.out.println("[공통로그 - 사후처리] " + method + "() 메서드 리턴 값 : " + returnObj.toString());
	}
}
