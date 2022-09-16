package com.javalab.spring.board.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.javalab.spring.board.vo.BoardVO;


/**
 * [어드바이스 클래스]
 *  - 스프링 설정파일에 빈(Bean)등록되어 있거나
 *  - 어드바이스 클래스에 @Service 어노테이션이 붙어 있어야 스프링 컨테이너에 등록될 수 있다.
 */
//@Service
//@Aspect
public class AfterReturningAdvice {

	public AfterReturningAdvice() {
	}
	/*
	 * [포인트컷]
	 * - 포인트컷 적용 대상 메소드 : PointCutCommon 클래스의 getPointCut()
	 * - 포인트컷 대상 메소드들이 정상 실행되고 난후에 이 메소드가 실행된다.
	 * - 실행 후에 결과를 반환 받는다.(returning="returnObj")
	 * - getPointCut()이기 때문에 insert 문에서는 작동안함.
	 */
	@AfterReturning(pointcut="PointCutCommon.getPointCut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj){
		String method = jp.getSignature().getName();

		System.out.println("[AfterReturningAdvice - 사후처리] " + method +"() 메서드 리턴 값 : " + returnObj.toString());
		
		// 코드 수정필요(UserVo -> BoardVO)
		if(returnObj instanceof BoardVO){
			BoardVO board = (BoardVO) returnObj;
			
			System.out.println(board.getTitle());
			
			//if(board.getTitle().equals("새로운 게시물")){
			//	System.out.println(board.getTitle());
			//}
		}
	}
}
