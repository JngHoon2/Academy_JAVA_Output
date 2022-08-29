package com.javaworks.shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				//MariaDB
//				String dbUrl = "jdbc:mariadb://localhost:3306/";
//				String dbName = "shoppingcart";
//				String dbId = "root";
//				String dbPwd = "1234";
//				String driverUrl = "org.mariadb.jdbc.Driver"; 
				
				//oracle				
				String driver = "oracle.jdbc.driver.OracleDriver";
				//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	// 집
				String url = "jdbc:oracle:thin:@58.148.65.116:1521:orcl";	// 회사
				String uid = "shoppingcart";
				String pwd = "1234";
				
				Class.forName(driver);
				conn = DriverManager.getConnection(url, uid, pwd);

			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 로드 실패");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB접속 실패");
				e.printStackTrace();
			}
			
			System.out.println("connected : " + conn);
		}
		return conn;
	}
}
