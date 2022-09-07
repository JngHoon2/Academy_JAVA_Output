package com.javalab.spring.board.controller.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
// @Order(Ordered.LOWEST_PRECEDENCE) // 두개 중에 우선 순서 정하기 

/*
 * [예외 처리 전용 컨트롤러]
 * @ControllerAdvice : @Controller를 포함한 전역에서 발생한 예외를 공통으로 처리하는 클래스
 * @Controller 와 마찬가지로 component-scan 되면서 자동으로 Bean 생성된다.
 * 이를 통해서 예외를 처리하는 방법과 스프링 AOP를 통해서 처리하는 방법 두가지 혼용되어 있음.
 * component-scan 해서 Bean으로 생성되어야 함.
 * @ExceptionHandler 는 @Controller, @RestController가 적용된 Bean 내에서 발생하는 예외를 잡아서 하나의 메서드에서 처
 */

public class CommonExceptionHandlerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandlerAdvice.class);
	
	@ExceptionHandler({NoHandlerFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String handleNoHandlerFoundException404(NoHandlerFoundException ex, Model model) {
		logger.error("NoHandlerFoundException : " + ex.getMessage());
		model.addAttribute("exception", ex);
		return "/error/custom404";
	}
	
	/*
	 * @ExceptionHandler
	 * Exception 예외 처리 메서드
	 * @param ex
	 * @param model
	 * @return /error/exception 
	 */
	
	@ExceptionHandler(Exception.class)
	public String execption(Exception ex, Model model, HttpServletRequest req) {
		logger.error("CommonExceptionAdvice Exception()에서 예외 Catch Exception........" + ex.getMessage());
		model.addAttribute("exception", ex);
		return "/error/exception";
	}
	
	/*
	 * SQLException 예외 처리 메서드
	 * @param ex
	 * @param model
	 * @param req
	 * @return
	 */
	
	@ExceptionHandler(SQLException.class)
	public String sqlException(Exception ex, Model model, HttpServletRequest req) {
		logger.error("CommonExceptionAdvice SQLException()에서 예외 Catch Exception........." + ex.getMessage());
		model.addAttribute("exception", ex);
		return "/error/excption";
	}
	
	// RuntimeException 예외 처리 메소드
	@ExceptionHandler(RuntimeException.class)
	public String errorException(Exception ex, Model model) {
		logger.error("CommonExceptionAdvice RuntimeException()에서 예외 Catch Exception........." + ex.getMessage());
		model.addAttribute("excption", ex);
		logger.error(model + "");
		return "/error/excption";
	}
	
	// NullPointerException 예외 처리 메소드 
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerException(NullPointerException ex, Model model) {
		logger.error("CommonExceptionAdvice NullPointerException()에서 예외 Catch Exception........." + ex.getMessage());
		model.addAttribute("excption", ex);
		logger.error(model + "");
		return "/error/excption";
	}
}
