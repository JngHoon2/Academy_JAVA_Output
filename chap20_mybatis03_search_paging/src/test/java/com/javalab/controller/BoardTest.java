package com.javalab.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.BoardDao;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Slf4j
public class BoardTest {
	@Inject
	private BoardDao dao;

	@Test @Ignore
	public void testBoard() {
		assertNotNull(dao);
		log.info(dao + "");
	}

	@Test @Ignore
	public void testGetBoard() {
		// [1] 조회할 사용자 객체 생성
		BoardVo vo = new BoardVo();
		vo.setNo(1);	// 데이터베이스의 1번 게시물 조회

		// [2] 하나의 게시물 조회
		BoardVo board = dao.getBoardById(vo);
		assertEquals(1, board.getNo());	// 조회해온 1번 게시물의 no = 1 검사
		log.info(board.toString());
	}
	
	@Test @Ignore
	public void testGetBoardList() {
		// [1] 조회할 객체 생성
		BoardVo vo = new BoardVo();
		
		// [2] 게시물 목록 조회
		List<BoardVo> boardList = dao.getBoardList(vo);
		assertNotNull(boardList);
		log.info(boardList.get(0).toString());
	}
	
	@Test 
	public void testBoardPaging() {
		Criteria cri = new Criteria(2, 10);
		List<BoardVo> list = dao.getListPagingAndSearching(cri);
		list.forEach(board -> {log.info(board.toString());});
	}
}
