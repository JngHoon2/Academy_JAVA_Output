package com.javalab.controller;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.LoginDao;
import com.javalab.service.LoginService;
import com.javalab.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:config/root-context.xml")
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
      })
public class LoginJunitTest {

	// LoginService 빈 주입
	@Resource(name = "loginService")
	private LoginService service;
	
	@Resource(name = "loginDao")
	private LoginDao dao;

	/*
	 * [Dao단]사용자 조회 단위테스트
	 */
	@Test @Ignore
	public void testGetUser() {
		// [1] 조회할 사용자 객체 생성
		UserVo vo = new UserVo();
		vo.setId("1");	// 데이터베이스에서 ID:1인 사용자 조회
		vo.setPwd("2");	// 데이터베이스의 비밀번호 확인후 코딩
		
		// [2] 위에서 만든 사용자 객체를 Dao 단에 전달해서 조회
		UserVo user = dao.getUser(vo);
		assertEquals("1", user.getId());
		System.out.println(user.toString());
	}
	
	/*
	 * [Service단]사용자 조회 단위테스트
	 */
	@Test @Ignore
	public void testGetUserService() {
		// [1] 조회할 사용자 객체 생성
		UserVo vo = new UserVo();
		vo.setId("1");	// 데이터베이스에서 ID:1인 사용자 조회
		vo.setPwd("2");	// 
		
		// [2] 위에서 만든 사용자 객체를 Dao 단에 전달해서 조회
		UserVo user = service.getUser(vo);
		assertEquals("1", user.getId());
		System.out.println(user.toString());
	}	
}

