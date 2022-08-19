package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DBConnection;
import dto.BoardModel;

public class BoardDAO {

	public BoardDAO() {
		super();
	}
	
	/*
	 * 하나의 게시물을 가져오는 메소드
	 */
	public BoardModel getBoard(String no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("select no, subject, writer, contents from board_tbl where no=?");
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(query.toString());
			
			pstmt.setString(1, no);

			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				int _no = rs.getInt(1);
				String subject = rs.getString(2);
				String writer = rs.getString(3);
				String contents = rs.getString(4);
				
				BoardModel vo = new BoardModel(_no, subject, writer, contents);
				
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
	public void addBoard(String subject, String writer, String contents) {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("insert into board_tbl(no, subject, writer, contents) values(seq_simple_board.nextval, ?, ?, ?)");
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query.toString());
			
			subject = subject.replace("<p>", "");
			subject = subject.replace("</p>", "");
			subject = subject.replace("</br>", "");
			
			writer = writer.replace("<p>", "");
			writer = writer.replace("</p>", "");
			writer = writer.replace("</br>", "");
			
			contents = contents.replace("<p>", "");
			contents = contents.replace("</p>", "");
			contents = contents.replace("</br>", "");
			
			pstm.setString(1, subject);
			pstm.setString(2, writer);
			pstm.setString(3, contents);

			pstm.executeUpdate();
			
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
	
	public List<BoardModel> selectAll(BoardModel board){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardModel> boardList = new ArrayList<BoardModel>();
		
		StringBuffer query = new StringBuffer();
		
		int start = 0;
		int end = 0;
		
		start = (Integer.parseInt(board.getPageNum()) - 1) * board.getListCount() + 1;
		end = start + board.getListCount() - 1;
		
		System.out.println("시작게시물번호 : " + start + " / 끝 게시물번호 : " + end);
		
		query.append("select c.seq, c.no, c.subject, c.writer, c.hit");
		query.append(" from( ");
		query.append("	select rownum as seq, b.no, b.subject, b.writer, b.hit");
		query.append("    from ( ");
		query.append("		select no, subject, writer, hit");
		query.append("    	from board_tbl a ");
		query.append("		order By a.no desc ");
		query.append("    )b");   
		query.append(" )c");
		query.append(" where c.seq between ? And ?");
		
		System.out.println("query : " + query.toString() );

		try {
			con = DBConnection.getConnection();	//커넥션 객체 얻기
			pstmt = con.prepareStatement(query.toString());

			pstmt.setInt(1, start);							//start num
			pstmt.setInt(2, end);							//end num
			
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				BoardModel model = new BoardModel();				
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("subject"));
				model.setWriter(rs.getString("writer"));
				model.setHit(rs.getInt("hit"));
				boardList.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return boardList;
	}	
	
	public ArrayList<BoardModel> listBoard() {		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("select * from board_tbl");
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query.toString());
		
			ArrayList<BoardModel> boardList = new ArrayList<BoardModel>();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String subject = rs.getString(2);
				String writer = rs.getString(3);
				String contents = rs.getString(4);
				int hit = rs.getInt(5);
				
				boardList.add(new BoardModel(no, subject, writer, contents, hit));
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
	
	
	//테이블의 전체 레코드 수 조회
	public int selectCount() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalCount = 0;
		StringBuffer query = new StringBuffer();

		query.append("Select Count(*) as totalCount");
		query.append(" From board_tbl");

		try {
			con = DBConnection.getConnection();	//커넥션 객체 얻기
			pstmt = con.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt("totalCount");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return totalCount;
	}
	
	/*
	 * 게시물 수정 메소드
	 */
	public void updateBoard(int no, String title, String writer, String contents) {
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// 1. StringBuffer() 클래스를 통해서 쿼리 문자열을 작성함
			StringBuffer query = new StringBuffer();
			query.append("update board_tbl set subject=?, writer=?, contents=? where no=?");
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query.toString());
			
			title = title.replace("<p>", "");
			title = title.replace("</p>", "");
			title = title.replace("</br>", "");
			
			writer = writer.replace("<p>", "");
			writer = writer.replace("</p>", "");
			writer = writer.replace("</br>", "");
			
			contents = contents.replace("<p>", "");
			contents = contents.replace("</p>", "");
			contents = contents.replace("</br>", "");
			
			pstm.setString(1, title);
			pstm.setString(2, writer);
			pstm.setString(3, contents);
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
			query.append("delete from board_tbl where no=?");
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query.toString());
			
			pstm.setInt(1, no);

			pstm.executeUpdate();
			
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
