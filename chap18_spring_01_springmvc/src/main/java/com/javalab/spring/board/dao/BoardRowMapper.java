package com.javalab.spring.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javalab.spring.board.vo.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO>{

	public BoardRowMapper() {}
	
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		
		board.setNo(rs.getInt("no"));
		board.setTitle(rs.getString("Title"));
		board.setWriter(rs.getString("Writer"));
		board.setContent(rs.getString("Content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setHit(rs.getInt("hit"));
		
		return board;
	}
	
}
