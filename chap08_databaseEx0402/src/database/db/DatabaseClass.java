package database.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseClass {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 데이터베이스 연결 문자열을 상수로 선언 및 초기화
	private String URL = "jdbc:oracle:thin:@127.0.0.1:1521:";
	private String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private String USER = "company";
	private String PWD = "";
	
	public DatabaseClass() {
	}

	// 오라클 데이터베이스 연결 메소드
	public void connectDB(String dbName, String pwd) {
		try {
			Class.forName(this.DRIVER);
			System.out.println("1. DB 드라이버 로드 성공!");
			
			this.PWD = pwd;
			this.URL += dbName;

			this.conn = DriverManager.getConnection(this.URL, this.USER, this.PWD);
			System.out.println("2. DB 접속 성공!");

		} catch (ClassNotFoundException e) {
			System.err.println("DRIVER FILE ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("DB CONNECTION ERR : " + e.getMessage());
		}
	}
	
	public ResultSet selectAll() {
		try {
			String query = "select * from EMP ";
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			
			return rs;
		} catch (SQLException e) {
			System.out.println("countDB ERROR : " + e.getMessage());
			return null;
		}
	}
	
	public ResultSet selectAVG() {
		try {
			String query = "select e.job, count(*) as count, sum(nvl(e.sal,0)) as sum, round(avg(nvl(e.sal,0)), 2) ";
			query += "from emp e group by e.job having avg(nvl(e.sal,0)) <= (select avg(avg_job) ";
			query += "from(select avg(nvl(sal,0)) as avg_job from emp group by job)) ";
			query += "order by avg(nvl(e.sal,0)) desc";
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			
			return rs;
		} catch (SQLException e) {
			System.out.println("countDB ERROR : " + e.getMessage());
			return null;
		}
	}
}
