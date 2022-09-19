package com.javalab.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javalab.vo.UserVo;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	private static final Logger log = LoggerFactory.getLogger(LoginDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String USER_GET = "select * from user_tbl where id=? and pwd=?";
	
	public LoginDaoImpl() {}
	
	public UserVo getUser(UserVo vo) {
		log.info(vo.toString());
		Object[] args = new Object[]{vo.getId(), vo.getPwd()};
		try {
			return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
}
