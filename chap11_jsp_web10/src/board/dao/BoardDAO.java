package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board.vo.Board;

public class BoardDAO {
	private static BoardDAO instance;
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	public ArrayList<Board> listBoard() {
		ArrayList<Board> list = new ArrayList<>();
		try {
			// connectDB();
			con = DBConnection.getConnection();
			String query = "select * from members ";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regDate = rs.getDate("resDate");

				Board bo = new Board(no, title, content, writer, regDate);

				list.add(bo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertBoard(Board bo) {

		String title = bo.getTitle();
		String content = bo.getContent();
		String writer = bo.getWriter();

		try {
			// connectDB();
			con = DBConnection.getConnection();
			String query = "INSERT INTO SIMPLE_BOARD(NO, title, content, writer) values(seq_simple_board.NEXTVAL, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("삽입 완료!");

			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("삽입 오류");
			e.printStackTrace();
		}
	}

	public void ModifyBoard(Board bo) {
		
		int id = bo.getNo();
		String title = bo.getTitle();
		String content = bo.getContent();
		String writer = bo.getWriter();
		
		try {
			// connectDB();
			con = DBConnection.getConnection();
			String query = "update simple_board set title=?, content=?, writer=?, regdate=sysdate where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			pstmt.setInt(4, id);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("수정 완료!");
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("수정 오류");
			e.printStackTrace();
		}
	}
	
	public void DeleteBoard(String id) {
		
		try {
			// connectDB();
			con = DBConnection.getConnection();
			String query = "delete from simple_board where id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("삭제 완료!");
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("삭제 오류!");
			e.printStackTrace();
		}
	}
}
