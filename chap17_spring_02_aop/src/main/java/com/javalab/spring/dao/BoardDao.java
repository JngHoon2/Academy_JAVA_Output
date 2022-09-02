package com.javalab.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalab.spring.vo.BoardVo;

/**
 * [Data Access Object Layer, Dao단]
 * - Service Layer의 요청을 받고 데이터베이스 관련 작업을 처리하는 layer
 * - 빈으로 생성되어 BoardServiceImple 객체에 의존성 주입된다.
 */
@Repository("boardDao")
public class BoardDao {

	// JDBC 관련 멤버 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	@Autowired
	private DataSource dataSource;	
	
	// SQL 명령어 상수 선언
	private final String BOARD_INSERT = "insert into simple_board (no, title, writer, content) values ((select nvl(max(no), 0)+1 from simple_board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update simple_board set title=?, content=? where no=?";
	private final String BOARD_DELETE = "delete from simple_board where no=?";
	private final String BOARD_GET = "select * from simple_board where no=?";
	private final String BOARD_LIST = "select * from simple_board order by no desc";

	public BoardDao() {
	}

	/** CRUD 기능 메서드 구현 **/
	// 글 등록
	public void insertBoard(BoardVo vo) {
		System.out.println("====>> 여기는 BoardDAO의 insertBoard() 메소드");		

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	} 
	
	// 글 목록 조회
	public List<BoardVo> getBoardList(BoardVo vo) {
		System.out.println("====>> 여기는 BoardDAO의 getBoardList() 메소드");		
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();

			while (rs.next()) {
				BoardVo board = new BoardVo();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setHit(rs.getInt("hit"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return boardList;
	} 	
	

	// 글 수정
	public void modifyBoard(BoardVo vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setInt(3, vo.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	// 글 삭제
	public void deleteBoard(BoardVo vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 

	// 글 상세 조회
	public BoardVo getBoard(BoardVo vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVo board = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getNo());
			rs = stmt.executeQuery();

			if (rs.next()) {
				board = new BoardVo();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setHit(rs.getInt("hit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return board;
	} 
}