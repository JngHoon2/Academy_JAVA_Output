package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Update_PreparedStatement2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		//								아이피 번호 : 포트 번호 : SID
		String dbID = "ky";
		String dbPwd = "1234";
		String sql;
		
		int resultNo = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null; // sql문의 ?를 변수로 치환할 수 있는 클래
		ResultSet rs = null;
		
		try {
			//1. 드라이버 연결 
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			//2. 데이터베이스 연결 
			con = DriverManager.getConnection(url, dbID, dbPwd);
			System.out.println("데이터베이스 연결 성공");
			
			int id = 1027;
			String name = "이미나";
			
			// 쿼리문 작성에 유의!
			sql = "update client set name = ? where id = ?";
		
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			
			
			resultNo = pstmt.executeUpdate();
			if(resultNo > 0) {
				System.out.println("수정 성공!");
			} else {
				System.out.println("수정 실패!");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패 : " + e.getMessage());
		} finally {
			try {
				// 작은 범위부터 차례로 닫아주는 것이 좋음. 변수들을 try 밖으로 빼두어 정의해둘것.
				// 닫지 않아도 무방하나, 메모리 누수 및 보안으로 인해 닫아주는 습관을 들이는 것이 좋음.(실무)
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("SQL 자원해제 오류 : " + e.getMessage());
			}
		}
	}
}
