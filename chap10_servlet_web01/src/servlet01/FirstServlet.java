package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Override
	public void init() throws ServletException{
		System.out.println("init() 메소드 호출");
	}
    
    public FirstServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet() 메소드 호출");
		response.setContentType("text/html; charset=utf-8");
		
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>FirsrServlet 현재시간</title></head>");
		out.println("<body>");
		out.println("<1. 현재 서버의 컨텍스트 경로는 : " + contextPath + "<br><br>");
		out.println("<2. 현재 시간 : ");
		out.println(new Date());
		out.println("입니다.");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
