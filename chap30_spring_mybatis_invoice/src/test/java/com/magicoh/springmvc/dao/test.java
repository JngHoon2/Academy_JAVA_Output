package com.magicoh.springmvc.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.magicoh.springmvc.dto.CustomUser;
import com.magicoh.springmvc.dto.UserRole;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/applocation-context.xml"})
@Slf4j
@RequiredArgsConstructor
public class test {
	private IUserMapperDao dao;
	
	@Autowired
	public void setIuserMapperDao(IUserMapperDao dao) {
		this.dao = dao;
	}
	
	@Test @Ignore
	public void testDao() {
		assertNotNull(this.dao);
	}
	
	@Test
	public void testInsertUser() {
		CustomUser cu = new CustomUser();
		cu.setUser_id("java10");
		cu.setUser_name("홍길수");
		cu.setUser_pwd("");
		dao.insertUser(cu);
		
		log.info("사용자 등록 성공 - 1");
		
		UserRole role = new UserRole();
		role.setRole_id("ROLE_USER");
		role.setUser_id(cu.getUser_id());
		dao.insertUserRole(role);
		log.info("사용자 권한 등록 성공 - 2");
		
		log.info("dao.getLoadUserByUsername : " + dao.getUserByUsername("java10"));
		log.info("등록한 사용자 조회 성공 - 3");
	}
}
