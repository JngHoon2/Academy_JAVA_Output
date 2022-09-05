package com.javalab.spring.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javalab.spring.board.vo.BoardVo;

public class BoardRowMapper implements RowMapper<BoardVo>{

	public BoardRowMapper() {}
	
	@Override
	public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVo board = new BoardVo();
		
		board.setNo(rs.getInt("no"));
		board.setTitle(rs.getString("Title"));
		board.setWriter(rs.getString("Writer"));
		board.setContent(rs.getString("Content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setHit(rs.getInt("hit"));
		
		return board;
	}
	
}
