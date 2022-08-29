package com.javaworks.shopping.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "encodingFilter", urlPatterns = {"/*"},
			initParams = @WebInitParam(name = "encodingType", value = "UTF-8"))
public class EncodingFilter implements Filter {

	private String encodingType;
	
	/**
	 * web.xml 에서 설정한 encodingType을 인자로 받아서 encodingType 멤버 변수에 저장한다.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		encodingType = filterConfig.getInitParameter("encodingType");
		if(encodingType == null) {	// 만약 설정한 인코딩이 없으면 UTF-8로 설정
			encodingType = "UTF-8";
		}
	}	
	
	@Override
	public void destroy() {}

	/**
	 * web.xml 에서 설정한 encodingType을 인자로 받는다.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//요청과 응답 한글 Encoding 처리
		//request.setCharacterEncoding("UTF-8");	// 클라이언트로 부터 전달된 몸체의 데이터를 UTF-8 방식으로 인코딩 해준다.
		request.setCharacterEncoding(encodingType);
		
		//사전 작업(위에서 처리한 한글 처리 작업)의 내용이 
		//서버상의 다음 번 컴포넌트에게 계속 적용되기 위한 작업
		chain.doFilter(request, response);
		
		response.setContentType("text/html;charset=utf-8");	// 서버에서 처리한 데이터를 클라이언트에 전달할 때 이와 같은 방식으로 인코딩하여 전달하겠다.
	}


}
