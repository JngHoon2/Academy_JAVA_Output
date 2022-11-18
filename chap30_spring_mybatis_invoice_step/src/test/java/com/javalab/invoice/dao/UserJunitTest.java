package com.javalab.invoice.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.invoice.dto.CustomUser;
import com.javalab.invoice.dto.UserRole;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/application-context.xml"
      })
@Slf4j
@RequiredArgsConstructor
public class UserJunitTest {

	private IUserMapperDao dao;
	
	// Setter 주입	
	@Autowired
	public void setIuserMapperDao(IUserMapperDao dao) {
		this.dao = dao;
	}
	
//	@Inject
//	private IUserMapperDao dao;
	
	// dao 인터페이스 빈 생성 유무 확인
	@Test
	public void testDao() {
		assertNotNull(this.dao);
	}

	// 사용자 조회 테스트
	@Test  @Ignore
	public void testGetUser() {
		CustomUser cu = new CustomUser();
		cu = dao.getUserByUsername("java11");
		log.info("cu : " + cu.toString());
		assertEquals("java11", cu.getUser_id());
	}

	// 사용자 등록 테스트
	@Test @Ignore
	public void testInsertUser() {
		CustomUser cu = new CustomUser();
		cu.setUser_id("java10");
		cu.setUser_pwd("$2a$10$lO4UdSncTsjzXKpBhiQ6j.fOJnoLNDOUxFXB0VI8R2LEo.2f66ura");
		cu.setUser_name("홍길수");
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
