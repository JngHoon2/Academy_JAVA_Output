package com.javalab.controller;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.BoardDAO;
import com.javalab.dao.BoardDAOImpl;
import com.javalab.dao.LoginDao;
import com.javalab.dao.LoginDaoImpl;
import com.javalab.service.LoginService;
import com.javalab.controller.BoardController;
import com.javalab.vo.BoardVO;
import com.javalab.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@ContextConfiguration(locations = {
//        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
//        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
//      })
public class UserJunitTest {

	@Resource(name="loginDao")
	private LoginDao dao;
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@Test @Ignore
	public void testGetUser() {
		UserVo vo = new UserVo();
		vo.setId("1");
		vo.setPwd("2");
		
		UserVo user = dao.getUser(vo);
		assertEquals("1", user.getId());
		System.out.println(vo.toString());
	}
	
	@Test
	public void testService() {
		UserVo vo = new UserVo();
		vo.setId("1");
		vo.setPwd("2");
		
		UserVo user = loginService.getUser(vo);
		assertEquals("1", user.getId());
		System.out.println(vo.toString());
	}
}
