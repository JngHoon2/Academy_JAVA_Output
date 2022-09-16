package com.javalab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javalab.vo.BoardVO;

/**
 * BoardRowMapper : RowMapper<BoardVO> 함수형 인터페이스 구현 클래스
 *  - spring jdbcTemplate의 queryForObject메소드에 BoardRowMapper 클래스를
 *    인자로 전달하면 그 클래스가 오버라이드하고 있는 mapRow메소드를 실행시켜준다.
 *  - 그 실행 결과로 <BoardVO>객체가 생성되고 그 안에 쿼리 결과가 담긴다.
 * 
 */
public class BoardRowMapper implements RowMapper<BoardVO> {

	public BoardRowMapper() {
	}

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		
		board.setNo(rs.getInt("no"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setHit(rs.getInt("hit"));
		
		return board;
	}

}
