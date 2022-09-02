package com.javalab.spring;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.spring.service.BoardService;
import com.javalab.spring.vo.BoardVo;

/*
  [junit 단위테스트]
	@RunWith(SpringJUnit4ClassRunner.class) 
	 - 스프링 컨테이너 구동해서
	 - @Autowired 와 같은 어노테이션 사용할 수 있게 됨.
	 @ContextConfiguration("classpath:config/root-context.xml")
	 - 스프링 컨테이너에서 사용할 빈등록 설정파일 지정
	 @Autowired : 스프링 컨테이너에서 원하는 빈을 찾아서 주입해줌.
 [import 오류]
  - pom.xml에서 spring-test 체크
  - @ContextConfiguration 먼저 import
  - 후에 SpringJUnit4ClassRunner 지우고 다시 타이핑하면 import됨. 	 

*/
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/root-context.xml")
public class BoardAopTest {

	// 빈으로 등록되어 있는 BoardService 구현체 주입 받음
	@Autowired
	private BoardService service;
	
	/*
	 * @Test : 테스트 메소드라는 표시
	 * @Ignore : 이 메소드는 테스트에서 제외
	 * 두 개를 같이 쓰면 테스트에서 제외됨(ex. @Test @Ignore)
	 */
	@Test
	public void testInsertBoard() {
		// 글 객체 생성
		BoardVo vo = new BoardVo();
		//vo.setSeq(0);
		vo.setTitle("임시 제목2");
		vo.setWriter("임시 작성자2");
		vo.setContent("임시 내용..........2");

		// 저장
		service.insertBoard(vo); 
	}

	// 게시물 목록 조회
	@Test @Ignore
	public void testGetBoardList() {

		// 빈 객체 생성
		BoardVo vo = new BoardVo();
		
		// 글목록 검색
		List<BoardVo> boardList = service.getBoardList(vo);
		for (BoardVo board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}	
	
	// 게시물 한 개 조회 
	@Test 
	public void testGetBoard() {

		// 빈 객체 생성
		BoardVo vo = new BoardVo();
		
		// 글목록 검색
		List<BoardVo> boardList = service.getBoardList(vo);
		for (BoardVo board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}		
}