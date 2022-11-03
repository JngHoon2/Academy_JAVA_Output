package com.javalab.exception;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice

/**
 * [@ControllerAdvice - 예외 처리 전용 컨트롤러]
 * @ControllerAdvice : 모든 @Controller에서 발생한 예외를 공통으로 처리하는 클래스
 * @ControllerAdvice : @Controller와 마찬가지로 component-scan 되면서 자동으로 Bean으로 생성된다.
 * @ControllerAdvice 를 통해서 예외를 처리하는 방법과 스프링 AOP를 통해서 처리하는 방법 두가지 혼용되어 있음.
 * @Controller, @RestController와 @ExceptionHandler 이 공동으로 예외처리함
 */
public class CommonExceptionHandlerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandlerAdvice.class);
	
	@ExceptionHandler({NoHandlerFoundException.class}) 
	@ResponseStatus(code = HttpStatus.NOT_FOUND) 
	public String handleNoHandlerFoundException404(NoHandlerFoundException ex, Model model) {
		logger.error("NoHandlerFoundException 익셉션 : " + ex.getMessage());
		model.addAttribute("exception", ex);
		return "/error/custom404";
	}
	
	/**
	 * SQLException 예외처리 메서드
	 */
	@ExceptionHandler(SQLException.class)
	public String sqlException(Exception ex, Model model, HttpServletRequest req) {
		logger.error("CommonExceptionAdvice SQLException()에서 예외 Catch Exception........" + ex.getMessage());
		model.addAttribute("exception", ex);
		logger.error(model + "");
		return "/error/exception";
	}
	
	/**
	 * RuntimeException 예외 처리 메서드
	 */
	@ExceptionHandler(RuntimeException.class)
	public String errorException(Exception ex, Model model) {
		logger.error("CommonExceptionAdvice >>>>>>>>> RuntimeException........" + ex.getMessage());
		model.addAttribute("exception", ex);
		logger.error(model + "");
		return "/error/exception";
	}
	
	/**
	 * NullPointerException 예외 처리 메서드
	 */
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerException(NullPointerException ex, Model model) {
		logger.error("CommonExceptionAdvice >>>>>>>>> nullPointerException........" + ex.getMessage());
		model.addAttribute("exception", ex);
		logger.error(model + "");
		return "/error/exception";
	}
	
	/**
	 * @ExceptionHandler 
	 * Exception 예외 처리 메서드
	 */
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex, Model model, HttpServletRequest req) {
		logger.error("CommonExceptionAdvice Exception()에서 예외 Catch Exception........" + ex.getMessage());
		model.addAttribute("exception", ex);
		logger.error(model + "");
		return "/error/exception";
	}
	
	 //일반적인 응답이 아닌 Rest와 같은 Ajax call에 대한 예외처리 핸들링 메소드인가???
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<Object> BadRequestException(final RuntimeException ex) {
//        logger.warn("error", ex);
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }

    // 401
//    @ExceptionHandler({ AccessDeniedException.class })
//    public ResponseEntity handleAccessDeniedException(final AccessDeniedException ex) {
//        logger.warn("error", ex);
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
//    }

    // 500
//    @ExceptionHandler({ Exception.class })
//    public ResponseEntity<Object> handleAll(final Exception ex) {
//        logger.info(ex.getClass().getName());
//        logger.error("error", ex);
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    /**
     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
     */
//    @ExceptionHandler(BindException.class)
//    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
//        logger.error("handleBindException", e);
//        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

}
