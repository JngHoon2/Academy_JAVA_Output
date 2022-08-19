package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginCheck() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userID");
		String userPwd = request.getParameter("userPWD");
		String contextPath = request.getContextPath();
		String url = "/cookie/loginOk.jsp";
		
		out.println(userId);
		out.println(userPwd);
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		
		for(Cookie c : cookies) {
			System.out.println("cookie name : " + c.getName());
			System.out.println("cookie value : " + c.getValue());
			
			if(c.getName().equals("memberId")) {
				cookie = c;
			}
		}
		
		if(cookie == null){
			System.out.println("쿠키가 존재하지 않아 쿠키를 생성합니다.");
			cookie = new Cookie("memberId", userId);
		}
		
		response.addCookie(cookie);
		
		cookie.setMaxAge(60*60);
		
		url = contextPath + url;
		response.sendRedirect(url);
	}

}
