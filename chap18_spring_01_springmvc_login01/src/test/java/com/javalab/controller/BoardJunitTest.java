package com.javalab.controller;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.BoardDAO;
import com.javalab.dao.BoardDAOImpl;
import com.javalab.controller.BoardController;
import com.javalab.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@ContextConfiguration(locations = {
//        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
//        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
//      })
public class BoardJunitTest {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardDAO dao;
	
	@Test 
	public void testJdbcTemplate() {
		assertNotNull(jdbcTemplate);
		log.info(jdbcTemplate + "");
	}
	
	@Test @Ignore
	public void testDaoBean() {
		assertNotNull(dao);
		log.info(dao + "");
	}
	
//	// BoardService 빈 주입
//	@Autowired
//	private BoardService service;
//	
//	@Autowired
//	private BoardDAOImpl dao;
//	
//	
//	
//	/*
//	 * 게시물 등록 단위 테스트
//	 */
//	@Test @Ignore
//	public void testInsertBoard() {
//		// [1] 테스트로 저장할 객체 생성
//		BoardVO vo = new BoardVO();
//		vo.setNo(190);	// 시퀀스 번호 확인 : select seq_simple_board.nextval from dual;
//		vo.setTitle("새로운 게시물");
//		vo.setWriter("작성자");
//		vo.setContent("새로운 게시물 내용입니다.");
//		
//		int result = 0;
//		
//		// [2] Dao 단을 통해서 저장 작업[트랜잭션 적용 안됨]
//		result = dao.insertBoard(vo);
//		assertEquals(result, 1);
//
//		/*
//		 * [3] Service 단을 통해서 저장 작업[트랜잭션 적용]
//		 *  - 서비스 단을 테스트할 때만 Advice가 적용되는 것을 알 수 있음.
//		 *    Advice의 포인트컷(적용대상)을 Service 메소드에만 걸었기 때문임.
//		 *  - 위에서 생성한 게시물 객체 저장  
//		 */
//		//result = service.insertBoard(vo);
//		//assertEquals(result, 1);
//	}
//	
//	/*
//	 * 게시물 한개 조회 단위테스트
//	 */
//	@Test 
//	public void testGetBoard() {
//		// [1] 조회할 객체 생성
//		BoardVO vo = new BoardVO();
//		vo.setNo(1);	// 데이터베이스에 1번 게시물 조회
//		//vo.setTitle("새로운 게시물");
//		//vo.setWriter("작성자");
//		//vo.setContent("새로운 게시물 내용입니다.");
//		
//		// [2] 하나의 게시물 조회
//		BoardVO board = service.getBoard(vo);
//		assertEquals(1, board.getNo());
//		System.out.println(board.toString());
//	}
//	
//	/*
//	 * 게시물 목록 조회 단위테스트
//	 */
//	@Test @Ignore
//	public void testGetBoardList() {
//		// [1] 조회할 객체 생성
//		BoardVO vo = new BoardVO();
//		//vo.setNo(1);	// 데이터베이스에 1번 게시물 조회
//		//vo.setTitle("새로운 게시물");
//		//vo.setWriter("작성자");
//		//vo.setContent("새로운 게시물 내용입니다.");
//		
//		System.out.println(vo.toString());
//		
//		// [2] 게시물 목록 조회
//		List<BoardVO> boardList = service.getBoardList(vo);
//		assertNotNull(boardList);
//		System.out.println(boardList.get(0).toString());
//	}
}
