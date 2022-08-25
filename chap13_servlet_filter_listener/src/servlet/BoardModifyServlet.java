package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

/**
 * 게시판 수정폼, 수정처리 서블릿 클래스
 * @since 2020.02.05
 * @author javalab
 */
@WebServlet("/board/boardModify")
public class BoardModifyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/** BOARD DAO */
	private BoardDao boardDao = BoardDao.getInstance();
    
    public BoardModifyServlet() {
        super();
    }

	/**
	 * GET 접근 시 (수정폼 접근 시)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		String url = "boardModify.jsp";
		
		// 파라미터
		int no = 0;
		
		if(request.getParameter("no") != null) {
			no = Integer.parseInt(request.getParameter("no").toString());
		}

		// Dao 객체의 인스턴스 얻기
		//boardDao = new BoardDao();
		//boardDao = BoardDao.getInstance();
		//boardDao = BoardDao.getInstance();

		// 게시물 목록을 조회
		BoardVo board = boardDao.getBoardById(no);
		
		// request에 board 객체 저장
		request.setAttribute("board", board);
		
		RequestDispatcher rds = request.getRequestDispatcher(url);
		rds.forward(request, response);

		
	}

	/**
	 * POST 접근 시 (수정처리 접근 시)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		System.out.println("BoardModifyServlet - doPost()");
		
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html; charset:utf-8");
		
		//String url = "/boardList.jsp";
		
		// 파라미터
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
		
		// Dao 객체의 인스턴스 얻기
		//boardDao = new BoardDao(); //BoardDao.getInstance();
		boardDao = BoardDao.getInstance();
		
		// 게시물 목록을 조회
		int result = boardDao.modifyBoard(vo);
		if(result > 0) {
			System.out.println("게시물 수정 성공!");
		}else {
			System.out.println("게시물 수정 실패!");
		}
		
		// 페이지 이동
		response.sendRedirect("boardList");
	}
}
