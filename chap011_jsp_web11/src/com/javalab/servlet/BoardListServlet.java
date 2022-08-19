package com.javalab.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalab.dao.BoardDAO;
import com.javalab.vo.BoardVO;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardVO> boardList = dao.listBoard();
				
		// request에 address라는 이름으로 "서울시 구로구"라는 스트링 값을 저장
		// 저장된 값은 이동한 페이지에서 사용가능
		request.setAttribute("boardList", boardList);
		
		// 프로그램의 흐름을 다른 서블릿/화면으로 이동
		RequestDispatcher dispatch = request.getRequestDispatcher("/boardList.jsp");
		dispatch.forward(request, response);
		
	}

}
