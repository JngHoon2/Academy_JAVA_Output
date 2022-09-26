package com.javalab.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.LoginDao;
import com.javalab.dao.UserDao;
import com.javalab.vo.BoardVo;
import com.javalab.vo.RoleVo;
import com.javalab.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Slf4j
public class RoleTest {

	@Inject
	private UserDao dao;
	
	@Test @Ignore
	public void testUser() {
		assertNotNull(dao);
		log.info(dao + "");
	}
	
	@Test
	public void testGetRole() {
		// [1] 조회할 객체 생성
		UserVO vo = new UserVO();
		
		// [2] 게시물 목록 조회
		List<RoleVo> RoleVo = dao.getRoles();
		assertNotNull(RoleVo);
		log.info(RoleVo.get(0).toString());
	}
}
