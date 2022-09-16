package com.javalab.spring.board.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * [공통으로 사용되는 어드바이스 클래스]
 *  - 여러개의 포인트컷을 정의하고 있다.
 */
@Service
@Aspect
public class PointCutCommon {

	public PointCutCommon() {
	}

	@Pointcut("execution(* com.javalab.spring..*Impl.*(..))")
	public void allPointCut(){}
	
	@Pointcut("execution(* com.javalab.spring..*Impl.get*(..))")
	public void getPointCut(){}
	
}
