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
import com.javalab.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class HikariCPTest {
	@Inject
	private DataSource dataSource;
	
	@Inject
	private SqlSessionFactory sf;
	
	@Inject
	private LoginDao dao;
	
	@Inject
	private LoginService service;
	
	@Test 
	public void testDataSource() {
		assertNotNull(dataSource);
		try(Connection conn = dataSource.getConnection()) {
			log.info(conn + "");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test 
	public void testGetUser() {
		UserVo vo = new UserVo();
		vo.setId("1");
		vo.setPwd("2");
		
		UserVo user = dao.getUserById(vo);
		assertEquals("1", user.getId());
		System.out.println(user.toString());
	}
	
	@Test 
	public void testGetUserService() {
		UserVo vo = new UserVo();
		vo.setId("1");
		vo.setPwd("2");
		
		UserVo user = service.getUserById(vo);
		assertEquals("1", user.getId());
		System.out.println(user.toString());
	}
	
}
