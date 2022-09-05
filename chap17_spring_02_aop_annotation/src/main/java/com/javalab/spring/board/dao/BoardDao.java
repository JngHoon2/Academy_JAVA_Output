package com.javalab.spring.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javalab.spring.board.vo.BoardVo;

/**
 * [Data Access Object Layer, Dao단]
 * - Service Layer의 요청을 받고 데이터베이스 관련 작업을 처리하는 layer
 * - 빈으로 생성되어 BoardServiceImple 객체에 의존성 주입된다.
 */
@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어 상수 선언
	private final String BOARD_INSERT = "insert into simple_board (no, title, writer, content) values ((select nvl(max(no), 0)+1 from simple_board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update simple_board set title=?, content=? where no=?";
	private final String BOARD_DELETE = "delete from simple_board where no=?";
	private final String BOARD_GET = "select * from simple_board where no=?";
	private final String BOARD_LIST = "select * from simple_board order by no desc";

	private final String BOARD_INSERT_TRANSACTION = "insert into simple_board (no, title, writer, content) values (?, ?, ?, ?)";
	
	public BoardDao() {
	}

	/** CRUD 기능 메서드 구현 **/
	// 글 등록
	public void insertBoard(BoardVo vo) {
		System.out.println("====>> Spring JDBC로 insertBoard() 기능 처리");
		int result;
		result = jdbcTemplate.update(BOARD_INSERT_TRANSACTION, vo.getNo(), vo.getTitle(), 
										vo.getWriter(), vo.getContent());
	} 
	
	// 글 수정
	public void updateBoard(BoardVo vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVo vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getNo());
	}
	
	// 글 상세 조회
	public BoardVo getBoard(BoardVo vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args= {vo.getNo()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	// 글 목록 조회
	public List<BoardVo> getBoardList(BoardVo vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	} 	
	



}