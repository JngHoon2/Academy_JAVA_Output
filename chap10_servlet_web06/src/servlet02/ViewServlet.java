package servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("viewServlet 실행됨, membetServlet에서 인자를 가지고옴.");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("memberList");
		
		out.println("<html><body>");
		out.print("<table  border  =  1>");
		out.print("<tr align = 'center' bgcolor = 'lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for(MemberVO vo : list) {
			out.println("<tr>");
			out.println("<td>" + vo.getId() + "</td>");
			out.println("<td>" + vo.getPwd() + "</td>");
			out.println("<td>" + vo.getName() + "</td>");
			out.println("<td>" + vo.getEmail() + "</td>");
			out.println("<td>" + vo.getJoinDate() + "</td>");
			out.println("<tr>");
		}
		out.println("<br>");
		out.println("</table></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
