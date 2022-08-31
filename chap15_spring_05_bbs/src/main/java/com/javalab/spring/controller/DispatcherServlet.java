package com.javalab.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalab.spring.dao.BoardDao;
import com.javalab.spring.vo.BoardVo;

/**
 * Servlet implementation class DispatcherServelt
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDao boardDao = BoardDao.getInstance();
	
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 DispatcherServlet doHandle() 메소드");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path : " + path);
		
		String requestMethod = request.getMethod().toLowerCase();
		System.out.println("요청 방식 : " + requestMethod);
		
		if(path.equals("/boardList.do")) {
			System.out.println("게시판리스트 호출");
			String url = "/WEB-INF/views/boardList.jsp";
			
			ArrayList<BoardVo> boardList = boardDao.selectBoardList();
			request.setAttribute("boardList", boardList);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
		} else if (path.equals("/boardView.do")) {
			String url = "/WEB-INF/views/boardView.jsp";
			
			int no = 0;
			if(request.getParameter("no") != null) {
				no = Integer.parseInt(request.getParameter("no").toString());
			}
			
			boardDao.updateHitCount(no);
			
			BoardVo board = boardDao.getBoardById(no);
			
			request.setAttribute("board", board);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			
		} else if (path.equals("/boardWrite.do")) {
			if(requestMethod.contains("get")) {
				String url = "/WEB-INF/views/boardWrite.jsp";
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
				requestDispatcher.forward(request, response);
			} else {
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String writer = request.getParameter("writer");
				
				System.out.println("title : " + title + ", content : " + content + ", writer : " + writer);
				
				BoardVo vo = new BoardVo(title, content, writer);
				BoardDao dao = BoardDao.getInstance();
				dao.insertBoard(vo);
				
				response.sendRedirect("boardList.do");
			}
		} else if (path.equals("/boardModify.do")) {
			if(requestMethod.contains("get")) {
				String url = "/WEB-INF/views/boardModify.jsp";
				
				int no = 0;
				
				if(request.getParameter("no") != null) {
					no = Integer.parseInt(request.getParameter("no").toString());
				}
				
				BoardVo board = boardDao.getBoardById(no);
				
				request.setAttribute("board", board);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
				requestDispatcher.forward(request, response);
			} else {
				
				int no = 0;
				String title = "";
				String content = "";
				String writer = "";
				
				if(request.getParameter("no") != null) {
					no = Integer.parseInt(request.getParameter("no").toString());
				}
				if(request.getParameter("title") != null) {
					title = request.getParameter("title").toString();
				}
				if(request.getParameter("content") != null) {
					content = request.getParameter("content").toString();
				}
				if(request.getParameter("writer") != null) {
					writer = request.getParameter("writer").toString();
				}
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				
				boardDao = BoardDao.getInstance();
				
				int result = boardDao.modifyBoard(vo);
				if(result > 0) {
					System.out.println("수정 성공!");
				} else {
					System.out.println("수정 실패!");
				}
				
				response.sendRedirect("boardList.do");
			}
		} else if(path.equals("/boardDelete.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			int result = boardDao.deleteBoard(no);
			if(result > 0) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("삭제 실패!");
			}
			
			response.sendRedirect("boardList.do");
		}
	}

}
