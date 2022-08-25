package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

/**
 * 게시판 목록 페이지 서블릿 클래스
 * @since 2020.02.05
 * @author javalab
 */
@WebServlet("/board/boardList")
public class BoardListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	//private BoardDao boardDao = BoardDao.getInstance();
	
    
    public BoardListServlet() {
        super();
    }

	/**
	 * GET 접근 시 (목록 조회 접근 시)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		System.out.println("BoardListServlet - doGet()");
		
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html; charset:utf-8");
		
		String url = "/boardList.jsp";
		
		try {
			ServletContext sc = this.getServletContext();
			BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
			
			// 게시물 목록을 조회
			ArrayList<BoardVo> boardList = boardDao.selectBoardList();
			
			// 디버깅 코드
			//System.out.println("게시물 건수 : " + boardList.size());
			
			// request에 목록 객체 저장
			request.setAttribute("boardList", boardList);
			
			// Jsp화면으로 보내기
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}

}