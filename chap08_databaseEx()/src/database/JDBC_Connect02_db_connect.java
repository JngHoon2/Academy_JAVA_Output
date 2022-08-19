package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connect02_db_connect {
	public static void main(String[] args) {
		//1. 드라이버 연결 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String dbID = "ky";
		String dbPwd = "1234";
		Connection con = null;
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			con = DriverManager.getConnection(url, dbID, dbPwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패 : " + e.getMessage());
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("SQL 자원해제 오류 : " + e.getMessage());
			}
		}
	}
}
