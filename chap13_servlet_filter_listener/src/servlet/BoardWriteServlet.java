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
 * 게시판 등록폼, 등록처리 서블릿 클래스
 * @since 2020.02.05
 * @author javalab
 */
@WebServlet("/board/boardWrite")
public class BoardWriteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/** BOARD DAO */
	private BoardDao boardDao = BoardDao.getInstance();
    
    public BoardWriteServlet() {
        super();
    }

	/**
	 * GET 접근 시 (게시물 입력 폼 요청시 응답 메소드)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

		// 게시물 입력폼으로 이동		
		String url = "/boardWrite.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	/**
	 * POST 접근시 (게시물을 작성하고 등록처리 메소드)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		
		
		// POST 한글 파라미터 깨짐 처리(이 역할을 필터에서 처리)
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html; charset:utf-8");
		
		// 파라미터 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		System.out.println(title + "  " + content + " " + writer);
		
		// 전달받은 파라미터로 BoardVo 객체 생성
		BoardVo vo = new BoardVo(title, content, writer);
		BoardDao dao = BoardDao.getInstance();
		dao.insertBoard(vo);
		
		// 저장후 작업
		response.sendRedirect(contextPath + "/board/boardList");
	}

}
