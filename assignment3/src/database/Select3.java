package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		//								아이피 번호 : 포트 번호 : SID
		String dbID = "category";
		String dbPwd = "1234";
		
		// 아래 세줄 java.sql 패키지의 클래스를 import 해야함.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			con = DriverManager.getConnection(url, dbID, dbPwd);
			System.out.println("데이터베이스 연결 성공");
			
			stmt = con.createStatement();
			
			String sql = "select product_name, price "
					+ "from product "
					+ "where price >= 25000 "
					+ "order by price asc";
			
			rs = stmt.executeQuery(sql); 
			
			while (rs.next()) { 
				System.out.println(rs.getString("product_name") + "\t" 
						+ rs.getString("price"));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 오류 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
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
