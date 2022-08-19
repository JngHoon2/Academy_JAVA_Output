package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardModel;

@WebServlet("/modify.do")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		BoardDAO dao = new BoardDAO();
		BoardModel bm = dao.getBoard(no);
		
		request.setAttribute("board", bm);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/boardModify.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(no, subject, writer, contents);
		
		response.sendRedirect(request.getContextPath() + "/view.do?no=" + no);
	}

}
