package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginAdmin")
public class LoginTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginTest2() {
        super();
        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("user_id : " + user_id);
		System.out.println("user_pw : " + user_pw);
		
		if(user_id.equals("admin") && user_pw.equals("1234")) {
			out.print("<html>");
			out.print("<body>");
			out.print("관리자님 반갑습니다.");
			out.print("<br>");
			out.print("<a href = 'http://localhost:8080/chap10_servlet_web03/views/login2.html'> 로그인창으로 이동 </a>");
			out.print("</body>");
			out.print("</html>");
		} else {
			out.print("<html>");
			out.print("<body>");
			out.print(user_id + "님 반갑습니다.");
			out.print("<br>");
			out.print("<a href = 'http://localhost:8080/chap10_servlet_web03/views/login2.html'> 로그인창으로 이동 </a>");
			out.print("</body>");
			out.print("</html>");
		}
	}

}
