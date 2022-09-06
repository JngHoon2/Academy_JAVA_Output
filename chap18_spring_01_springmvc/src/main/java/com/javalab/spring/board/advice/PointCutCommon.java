package com.javalab.spring.board.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class PointCutCommon {
	public PointCutCommon() {}
	
	@Pointcut("execution(* com.javalab.spring..*Impl.*(..))")
	public void allPointCut() {}
	
	@Pointcut("execution(* com.javalab.spring..*Impl.get*(..))")
	public void getPointCut() {}
}
