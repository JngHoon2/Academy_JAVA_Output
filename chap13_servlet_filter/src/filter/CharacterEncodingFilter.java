package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns="/*",
		initParams={
				@WebInitParam(name="encoding", value="UTF-8")
		})
public class CharacterEncodingFilter implements Filter {

	FilterConfig config;

	/*
	 * 필터 init 메소드
	 *  - 필터를 초기화할 때 호출됨.
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	/*
	 * 필터기능 수행
	 *  - 필터의 구체적인 기능을 수행하는 메소드
	 *  - doFilter()메소드를 통해서 필터 체인의 다음 필터 진행함.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain nextFilter) throws IOException, ServletException {

		/*
		 * 1. 서블릿이 실행되기 전에 해야할 작업()
		 *  - config.getInitParameter("encoding") 값은
		 *  - web.xml에서 <param-name>으로 설정한 값 즉, utf-8 
		 */
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		
		// 2. 서블릿을 실행한 후, 클라이언트에게 응답하기 전에 해야할 작업
		response.setCharacterEncoding(config.getInitParameter("encoding"));
		
		// 3. 다음 필터를 호출. 더이상 필터가 없다면 서블릿의 service()가 호출됨.
		nextFilter.doFilter(request, response);
		
		
	}

	// 필터가 웹컨테이너(톰캣, WAS)에서 삭제될 때 호출됨.
	public void destroy() {
	}
}