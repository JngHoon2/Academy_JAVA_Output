package com.javalab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalab.dao.DBConnection;
import com.javalab.vo.BoardVO;

public class BoardDAO {

	public BoardDAO() {
		super();
	}
	
	/*
	 * 하나의 게시물을 가져오는 메소드
	 */
	public BoardVO getBoard(String title) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("select no, title, content, writer from simple_board where title=?");
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query.toString());
			
			pstmt.setString(1, title);

			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				int _no = rs.getInt(1);
				String _title = rs.getString(2);
				String _content = rs.getString(3);
				String _writer = rs.getString(4);
				
				BoardVO vo = new BoardVO(_no, _title, _content, _writer);
				
				return vo;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return null;
	} // end getBoard()
	
	/*
	 * 게시물 추가 메소드
	 */
	public void addBoard(String title, String content, String writer) {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("insert into simple_board values(seq_simple_board.nextval, ?, ?, ?, sysdate)");
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query.toString());
			
			title = title.replace("<p>", "");
			title = title.replace("</p>", "");
			title = title.replace("</br>", "");
			
			content = content.replace("<p>", "");
			content = content.replace("</p>", "");
			content = content.replace("</br>", "");
			
			writer = writer.replace("<p>", "");
			writer = writer.replace("</p>", "");
			writer = writer.replace("</br>", "");
			
			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setString(3, writer);

			pstm.executeUpdate();
//				conn.commit(); 

			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
					pstm = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end addBoard()
	
	//	/*
	//	 * 게시물 조회 메서드
	//	 * */
	public ArrayList<BoardVO> listBoard() {		
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("select * from simple_board");
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query.toString());
		
			ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				String writer = rs.getString(4);
				Date regdate = rs.getDate(5);
				
				boardList.add(new BoardVO(no, title, contents, writer, regdate));
			}
			
			return boardList;
			
	//			conn.commit(); 
	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	
		return null;
	} // end listBoard()
	
	/*
	 * 게시물 수정 메소드
	 */
	public void updateBoard(int no, String title, String content, String writer) {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("update simple_board set title=?, content=?, writer=? where no=?");
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query.toString());
			
			title = title.replace("<p>", "");
			title = title.replace("</p>", "");
			title = title.replace("</br>", "");
			
			content = content.replace("<p>", "");
			content = content.replace("</p>", "");
			content = content.replace("</br>", "");
			
			writer = writer.replace("<p>", "");
			writer = writer.replace("</p>", "");
			writer = writer.replace("</br>", "");
			
			pstm.setString(1, title);
			pstm.setString(2, content);
			pstm.setString(3, writer);
			pstm.setInt(4, no);

			pstm.executeUpdate();
//				conn.commit(); 

			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
					pstm = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end updateBoard()

	public void deleteBoard(int no) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("delete from simple_board where no=?");
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query.toString());
			
			pstm.setInt(1, no);

			pstm.executeUpdate();
//				conn.commit(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
					pstm = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
	}
	
}
