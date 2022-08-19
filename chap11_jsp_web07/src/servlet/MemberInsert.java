package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberInsert")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public MemberInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] hobby = request.getParameterValues("hobby");
		String major = request.getParameter("major");
		String email = request.getParameter("all");
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.print("취미 : ");
		for(String h:hobby) {
			System.out.print(h + " ");			
		}
		System.out.println();
		System.out.println("전공 : " + major);
		System.out.println("이메일 : " + email);
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("hobby", hobby);
		request.setAttribute("major", major);
		request.setAttribute("email", email);
		
		
		
	}

}
