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

@WebServlet("/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 화면에 입력한 한글 값을 읽어오기 위한 인코딩 설정
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");	
		
		int no = Integer.parseInt(request.getParameter("no"));
		
        BoardDAO dao = new BoardDAO();
		
		dao.deleteBoard(no);
				
		ArrayList<BoardVO> boardList = dao.listBoard();
				
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("boardList.jsp");
		dispatch.forward(request, response);
	}

}
