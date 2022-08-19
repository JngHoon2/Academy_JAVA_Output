package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select_PreparedStatement {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		// 데이터베이스 아이피, 포트 번호, 이름에 유의하여 url 정의 
		//								아이피 번호 : 포트 번호 : SID
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String dbID = "ky";
		String dbPwd = "1234";
		String sql;
		
		Connection con = null;
		PreparedStatement pstmt = null; // sql문의 ?를 변수로 치환할 수 있는 클래스 
		ResultSet rs = null;
		
		try {
			//1. 드라이버 연결 
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			//2. 데이터베이스 연결 
			con = DriverManager.getConnection(url, dbID, dbPwd);
			System.out.println("데이터베이스 연결 성공");
			
			
			// 쿼리문에 인자 전달 
			int id = 1021;
			sql = "select * from client where id = ?";
			
			// 쿼리문에 인자를 전달해서 실행해주는 객
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id); 			// 예는 0이 아닌 1부터 시작, 첫번째 ?를 id로 치환하는 역할 
			
			//prepareStatement 사용시 excuteQuery 메소드에 파라미터가 들어가면 안됨. ex) rs = pstmt.executeQuery(sql);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				System.out.println(rs.getString("id") + "\t" 
						+ rs.getString("password") + "\t" + rs.getString("name"));
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
