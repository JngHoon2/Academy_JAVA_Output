package com.javaworks.shopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * [로그인 체크 필터]
 *  - 이전까지 사용자의 로그인 유무를 체크하는 로직을 필요한 서블릿에 모두 넣었다. 코드 중복!
 *  - 로그인이 필요한 특정 페이지에 대한 요청이 올 때만 로그인 체크 필터가 인터셉트 해서 대신 체크해준다.
 *    e.g url : ~/mypage/* 즉, mypage는 반드시 로그인이 필요한 페이지이므로 로그인 체크 필터를 태운다. 
 */
public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		boolean login = false;
		if(session != null) {
			if(session.getAttribute("user") != null) {
				login = true;
			}
		}
		
		if(login) {
			chain.doFilter(request, response);
		}else {
			System.out.println("여기는 로그인 체크 필터 - 로그인 되어 있지 않아서 로그인 페이지로 이동합니다.");
			RequestDispatcher rds = request.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
			rds.forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

}
