package filter;

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
 *  1. web.xml에서 /board로 시작하는 서블릿 url 요청이 있을 경우 인터셉트(가로챔)
 *  2. 세션에서 로그인 정보가 있으면 사용자가 요청한 서블릿으로 제어를 넘겨주고
 *  3. 세션에 정보가 없으면 로그인 안했기 때문에 로그인 페이지로 강제 이동시킴.
 */
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	
    	System.out.println("여기는 LoginCheckFilter 필터의 doFilter()메소드 ");
    	
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean login = false;
        if (session != null) {
            if (session.getAttribute("member") != null) {
                login = true;
            }
        }
        if (login) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/loginForm.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}