package com.javalab.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.spring.board.dao.BoardDao;
import com.javalab.spring.board.service.BoardService;
import com.javalab.spring.board.vo.BoardVo;

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
public class BoardJunitTest {

	// 빈으로 등록되어 있는 BoardService 구현체 주입 받음
	@Autowired
	private BoardService service;

	@Autowired
	private BoardDao dao;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	@Ignore
	public void testDao() {
		assertNotNull(dataSource);
		System.out.println(dao);
	}
	
	@Test
	public void testGetBoard() {
		BoardVo vo = new BoardVo();
		vo.setNo(66);
		
		BoardVo board = service.getBoard(vo);
		assertEquals(66, board.getNo());
	}
	
	@Test
	@Ignore
	public void testGetBoardList() {
		BoardVo vo = new BoardVo();
		
		System.out.println(vo.toString());
		
		List<BoardVo> boardList = service.getBoardList(vo);
		assertNotNull(boardList);
		System.out.println(boardList.get(0).toString());
	}
	
	@Test
	@Ignore
	public void testInsertBoard() {
		BoardVo vo = new BoardVo();
		vo.setNo(66);
		vo.setTitle("66번 게시물");
		vo.setWriter("66번 작성자");
		vo.setContent("66번 내용");
		
		int result = 0;
		
		result = service.insertBoard(vo);
		assertEquals(result, 1);
	}
}