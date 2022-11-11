/**
 * 
 */
package com.kunil.security.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kunil.security.mapper.UserMapper;
import com.kunil.security.vo.Users;

import lombok.extern.slf4j.Slf4j;

/**
 * @author javalab
 */
@Repository
@Slf4j
public class AuthMyBatisServiceImpl implements AuthMyBatisService {
	
	@Autowired
	private SqlSession sqlSession;


	@Override
	public boolean hasUsername(String username) {
		log.info("AuthMyBatisServiceImpl > hasUsername");
		return sqlSession.getMapper(UserMapper.class)
						 .hasUsername(username) == 1 ? true : false;
	} 

	@Override
	public void insertUsers(Users users, String role) {
		log.info("AuthMyBatisServiceImpl > insertUsers");
		sqlSession.getMapper(UserMapper.class).insertUser(users);
		sqlSession.getMapper(UserMapper.class)
		  		  .insertUserRoles(users.getUsername(), role);
	}

} 