package com.javalab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javalab.vo.BoardVO;
import com.javalab.vo.UserVo;

/**
 * BoardRowMapper : RowMapper<BoardVO> 함수형 인터페이스 구현 클래스
 *  - spring jdbcTemplate의 queryForObject메소드에 BoardRowMapper 클래스를
 *    인자로 전달하면 그 클래스가 오버라이드하고 있는 mapRow메소드를 실행시켜준다.
 *  - 그 실행 결과로 <BoardVO>객체가 생성되고 그 안에 쿼리 결과가 담긴다.
 * 
 */
public class UserRowMapper implements RowMapper<UserVo> {

	public UserRowMapper() {
	}

	@Override
	public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVo user = new UserVo();
		
		user.setId(rs.getString("id"));
		user.setName(rs.getString("Name"));
		user.setEmail(rs.getString("email"));
		user.setRole(rs.getString("role"));
		user.setJoinDate(rs.getDate("joindate"));
		
		return user;
	}

}
