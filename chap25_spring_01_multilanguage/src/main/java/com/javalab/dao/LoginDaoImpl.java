package com.javalab.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javalab.vo.UserVo;

/**
 * [Data Access Object Layer(Dao단)]
 */
@Repository("loginDao") 
public class LoginDaoImpl implements LoginDao{
	
	private static final Logger log = LoggerFactory.getLogger(LoginDaoImpl.class);
	
	/*
	 * [JdbcTemplate]
	 *  데이터베이스 관련 작업을 자동화(캡슐화)해주는 객체
	 *  - Connection, PreparedStatement, resultSet관련 작업을
	 *    캡슐화해서 자동으로 처리해줌.
	 *  - root-context.xml에서 빈등록하도록 설정되어 있음
	 *  - 빈으로 생성될 때 DataSource를 의존성 주입 받음.
	 * [@Autowired]
	 *  - 빈으로 생성된 JdbcTemplate을 자동 주입 받고 있음.
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 명령어 상수 선언
	private final String USER_GET = "select * from user_tbl where id=? and pwd=?";

	public LoginDaoImpl() {
	}

	/*
	 * 로그인 유저 조회(queryForObject 메소드에서 사용)
	 * IncorrectResultSizeDataAccessException : 쿼리문에 해당하는 결과가 없거나 2개 이상일 때 오류 처리
	 * EmptyResultDataAccessException : 결과가 없을 경우 발생하는 익셉션
	 */
	public UserVo getUser(UserVo vo) {
		log.info(vo.toString());
		Object[] args = new Object[]{vo.getId(), vo.getPwd()};
		try {
			return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
		// 결과가 없을 경우 발생하는 익셉션
		} catch (EmptyResultDataAccessException error) { 
		    return null;
		// 쿼리문에 해당하는 결과가 없거나 2개 이상일 때 오류 처리
		} catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
}
