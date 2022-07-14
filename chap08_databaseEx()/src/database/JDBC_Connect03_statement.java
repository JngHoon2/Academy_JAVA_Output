package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect03_statement {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		//								아이피 번호 : 포트 번호 : SID
		String dbID = "ky";
		String dbPwd = "1234";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. 드라이버 연결 
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			
			//2. 데이터베이스 연결 
			con = DriverManager.getConnection(url, dbID, dbPwd);
			System.out.println("데이터베이스 연결 성공");
			
			//3. 커넥션 객체를 통해서 데이터베이스에 쿼리를 날릴 수 있는 statement 객체 생성 
			stmt = con.createStatement();
			System.out.println("객체 생성 성공 : " + stmt);
			
			// 4. 생성한 statement 객체를 통해서 쿼리
			String sql = "select * from client";

			// 5. statement의 executeQuery() 메소드를 통해 쿼리 실행
			rs = stmt.executeQuery(sql); 
			
			// 하지만 아랫줄을 주석처리하면 모두 출력됨.
			System.out.println("쿼리가 정상적으로 실행됨 결과 존재? : " + rs.next());
			
			//6. rs.next 설명 
			while (rs.next()) { // 위에서 한번 rs.next를 사용했기 때문에 3건만 출력된다.
				System.out.println(rs.getString("id") + "\t" + rs.getShort("password") + "\t" + rs.getString("name"));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패 : " + e.getMessage());
		} finally {
			try {
				// 작은 범위부터 차례로 닫아주는 것이 좋음. 변수들을 try 밖으로 빼두어 정의해둘것.
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
