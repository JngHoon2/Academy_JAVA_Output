package com.javalab.controller;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.LoginDao;
import com.javalab.service.LoginService;
import com.javalab.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Slf4j
public class HikariCPTest {
	@Inject
	private DataSource dataSource;
	
	@Inject
	private SqlSessionFactory st;
	
	@Inject
	private LoginDao dao;
	
	@Inject
	private LoginService service;
	
	// HikariCP 커넥션풀 생성 여부 확인 Test
	@Test
	public void testDataSource() {
		assertNotNull(dao);
		try(Connection  conn = dataSource.getConnection()){
			log.info(conn + "");	// 커넥션 객체 주소값 출력
		}catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test @Ignore
	public void testGetUser() {
		// [1]  조회할 사용자 갹체 생성
		UserVO vo = new UserVO();
		vo.setId("1");	
		vo.setPwd("2");
		
		// [2] 위에서 만든 사용자 객체를 Dao단에 전달해서 조회
		UserVO user = service.getUserById(vo);
		assertEquals("1", user.getId());
		System.out.println(user.toString());
	}
}
