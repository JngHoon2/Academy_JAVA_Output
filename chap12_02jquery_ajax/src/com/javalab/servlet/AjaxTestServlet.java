package com.javalab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxTestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/x-json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		System.out.println("doget :" + name);
		System.out.println("deget :" + age);

		out.print("Get 통신 : 안녕 내 이름은 " + name + "이고 나이는 " + age + "란다"); // response
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/x-json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String age = request.getParameter("age");    
		
		System.out.println("doget :"+name);
		System.out.println("deget :"+age);
		    
		out.println("Post통신 : 안녕 내 이름은 "+name+"이고 나이는 "+age+"란다"); //response	
	}
}
