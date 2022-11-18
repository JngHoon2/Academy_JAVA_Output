package com.javalab.invoice.service.aop;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.javalab.invoice.dto.User;

import lombok.extern.slf4j.Slf4j;

/**
 * [Advice 집합] 
 *  - @Aspect : 나는 Advice, 부가기능(횡단관심사)입니다.라는 의미 
 *  - @Service : Advice로 적용되어야 하므로 미리 빈으로 생성한다.
 */

@Service
@Aspect
@Slf4j
public class CommonAopAdvice {

	public CommonAopAdvice() {
	}

	/**
	 * [어드바이스 - Before] 포인트컷 메소드 수행전 의무 실행 어드바이스
	 */
	@Before("CommonPointcut.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		log.info("[사전처리 @Before 어드바이스] SpringSecurityAdvice" + "() 메소드명과 인자정보 : " + method + " "
				+ Arrays.toString(jp.getArgs()));
	}

	/**
	 * [어드바이스 - AfterThrowing] 포인트컷 메소드 수행중 예외 발생시 실행될 어드바이스
	 * @param joinPoint
	 * @param exceptObj
	 */
	@AfterThrowing(pointcut = "CommonPointcut.allPointcut()", throwing = "exceptObj")
	public void exceptionLog(JoinPoint joinPoint, Exception exceptObj) {

		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		String stuff = signature.toString();
		String arguments = Arrays.toString(joinPoint.getArgs());

		log.error("[@AfterThrowing - 수행중예외] exceptObj.getMessage() : " + exceptObj.getMessage());

		if (exceptObj instanceof IllegalArgumentException) {
			log.error("[SpringSecurityAdvice - 수행중예외]  >> IllegalArgumentException " + " 부적합한 값이 입력되었습니다. 예외발생 메소드명 : "
					+ methodName);
		} else if (exceptObj instanceof NumberFormatException) {
			log.error("[SpringSecurityAdvice - 수행중예외]  >> NumberFormatException " + " 숫자 형식의 값이 아닙니다. 예외발생 메소드명 : "
					+ methodName);
		} else if (exceptObj instanceof SQLDataException) {
			log.error("[SpringSecurityAdvice - 수행중예외]  >> SQLDataException "
					+ " SQL 문제가 발생했습니다. exceptObj.toString() : " + exceptObj.toString() + " 예외발생 메소드명 : " + methodName);
		} else if (exceptObj instanceof SQLException) {
			log.error("[SpringSecurityAdvice - 수행중예외]  >> SQLException " + " SQL 문제가 발생했습니다. exceptObj.toString() : "
					+ exceptObj.toString() + " 예외발생 메소드명 : " + methodName);
		} else if (exceptObj instanceof RuntimeException) {
			log.error("[SpringSecurityAdvice - 수행중예외]  >> RuntimeException " + "문제가 발생했습니다. exceptObj.toString() : "
					+ exceptObj.toString() + " 예외발생 메소드명 : " + methodName);
		} else if (exceptObj instanceof Exception) {
			log.error("[SpringSecurityAdvice - 수행중예외]  >> Exception " + "문제가 발생했습니다. exceptObj.toString() : "
					+ exceptObj.toString() + " 예외발생 메소드명 : " + methodName);
		}
	}

	/**
	 * [어드바이스 - AfterReturning] 포인트컷 메소드 정상 리턴된 후에 실행될 어드바이스
	 * @param jp
	 * @param returnObj
	 */
	@AfterReturning(pointcut = "CommonPointcut.allPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		
		log.info("[모든 메소드 무조건사후처리 @@AfterReturning 어드바이스] 비즈니스 로직 수행 후 동작");
		
		String method = jp.getSignature().getName();

		if (returnObj instanceof User) {
			User user = (User) returnObj;
			if (user.getRole_id().equals("Admin")) {
				log.info(user.getRole_id() + "로그인(Admin)");
			}
		}
	}

	/**
	 * [어드바이스 - After] 포인트컷 메소드 수행 후 실행될 어드바이스
	 */
	@After("CommonPointcut.allPointcut()")
	public void finallyLog() {
		log.info("[모든 메소드 무조건사후처리 @After 어드바이스] 비즈니스 로직 수행 후 동작");
	}
	
	/**
	 * [Around 어드바이스] 포인트컷 메소드 수행 전후에 메소드 실행 여부와 관계 없이 무조건 실행될 어드바이스
	 * @param pjp
	 * @throws Throwable
	 */
	@Around("CommonPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object obj = pjp.proceed();

		stopWatch.stop();
		System.out.println("[전후처리 어드바이스]" + method + "() 메소드 수행 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");

		return obj;
	}
}
