package com.javalab.controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.BoardDao;
import com.javalab.dao.LoginDao;
import com.javalab.service.LoginService;
import com.javalab.vo.BoardVo;
import com.javalab.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class HikariCPTest2 {
	@Inject
	private BoardDao dao;
	
	@Test 
	public void testBoard() {
		assertNotNull(dao);
		log.info(dao + " ");
	}
	
	@Test 
	public void testGetBoard() {
		BoardVo vo = new BoardVo();
		vo.setNo(1);
		
		BoardVo board = dao.getBoardById(vo);
		assertEquals(1, board.getNo());
		log.info(board.toString());
	}
	
	@Test 
	public void testGetBoardList() {
		BoardVo vo = new BoardVo();
		
		List<BoardVo> boardList = dao.getBoardList(vo);
		assertNotNull(boardList);
		log.info(boardList.get(0).toString());
	}
	

}
