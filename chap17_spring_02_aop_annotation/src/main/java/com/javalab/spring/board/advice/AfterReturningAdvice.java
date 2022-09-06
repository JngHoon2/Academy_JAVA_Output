package com.javalab.spring.board.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.javalab.spring.board.vo.BoardVo;

@Service
@Aspect
public class AfterReturningAdvice {
	
	public AfterReturningAdvice() {}
	
	@AfterReturning(pointcut = "PointCutCommon.getPointCut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		
		if(returnObj instanceof BoardVo) {
			BoardVo board = (BoardVo) returnObj;
			
			System.out.println(board.getTitle());
		}
		System.out.println("[공통로그 - 사후처리] " + method + "() 메서드 리턴 값 : " + returnObj.toString());
	}
}
