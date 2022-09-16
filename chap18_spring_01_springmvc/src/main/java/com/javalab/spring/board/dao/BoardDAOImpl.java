package com.javalab.spring.board.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javalab.spring.board.controller.BoardController;
import com.javalab.spring.board.vo.BoardVO;

/**
 * [Data Access Object Layer(단)]
 */
@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL 명령어 상수 선언
	private final String BOARD_INSERT = "insert into simple_board (no, title, writer, content) values (seq_simple_board.nextval, ?, ?, ?)";
	private final String BOARD_UPDATE = "update simple_board set title=?, content=? where no=?";
	private final String BOARD_DELETE = "delete from simple_board where no=?";
	private final String BOARD_GET = "select * from simple_board where no=?";
	private final String BOARD_LIST = "select * from simple_board order by no desc";

	// Transaction 전용 SQL
	//private final String BOARD_INSERT_TRANSACTION = "insert into simple_board (no, title, writer, content) values (?, ?, ?, ?)";
	
	public BoardDAOImpl() {
	}
	
	// 글 등록
	public int insertBoard(BoardVO vo) {
		log.info(vo.toString());
		int result = 0;
		result = jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		return result;
	} 
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		log.info(vo.toString());

		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getNo());
	} 
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		log.info(vo.toString());

		jdbcTemplate.update(BOARD_DELETE, vo.getNo());
	} 

	// 글 상세 조회(queryForObject 메소드 사용)
	public BoardVO getBoard(BoardVO vo) {
		log.info(vo.toString());
		
		Object[] args = {vo.getNo()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	} 
	
	// 글 목록 조회(query 메소드 사용)
	public List<BoardVO> getBoardList(BoardVO vo) {
		log.info(vo.toString());
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	} 
}
