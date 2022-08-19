package method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MethodServlet")
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MethodServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>get 방식으로 처리됨</h1><br>");
		out.println("<h3>전송받은 id : " + id + "</h3>");
		out.println("<h3>웹 브라우저의 주소창에 달려서 전송됨.</h3>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String user_id = request.getParameter("user_id");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>post 방식으로 처리됨</h1><br>");
		out.println("<h3>전송받은 id : " + user_id + "</h3>");
		out.println("<h3>웹 브라우저의 메시지 바디에 담겨서 전송되어 보이지 않음.</h3>");
		out.close();
	}

}
