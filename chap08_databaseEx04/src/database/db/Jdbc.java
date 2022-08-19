package database.db;

import java.sql.*;
import java.util.ArrayList;

import database.vo.CafeClass;

public class Jdbc {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 데이터베이스 연결 문자열을 상수로 선언 및 초기화
	private final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String USER = "sandwich";
	private final String PWD = "1234";

	public Jdbc() {
	}

	// 오라클 데이터베이스 연결 메소드
	public void connectDB() {
		try {
			Class.forName(this.DRIVER);
			System.out.println("1. DB 드라이버 로드 성공!");

			this.conn = DriverManager.getConnection(this.URL, this.USER, this.PWD);
			System.out.println("2. DB 접속 성공!");

		} catch (ClassNotFoundException e) {
			System.err.println("DRIVER FILE ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("DB CONNECTION ERR : " + e.getMessage());
		}
	}

	/**
	 * [데이터베이스 저장 작업]
	 * 데이터 전담 객체인 DataClass에 있는 cafes ArrayList를 데이터베이스에 저장
	 *  SQL 문장은 하나에 여러번의 인자 전달을 통해서 다중 저장 작업 진행
	 */
	public void insertDB(CafeClass c) {
		// 저장 작업
		String query = "insert into sandwich_cafe values(?,?,?,?,?,?,?)";
		
		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, c.getRank());
			this.pstmt.setString(2, c.getCafe());
			this.pstmt.setString(3, c.getMenu());
			this.pstmt.setDouble(4, c.getPrice());
			this.pstmt.setString(5, c.getAddress());
			this.pstmt.setString(6, c.getImg());
			this.pstmt.setString(7, c.getUrl());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insertDB ERROR : " + e.getMessage());
		}
		
	}

	// 테이블에 데이터가 한 건이라도 있는지 미리 확인
	public int countDB() {
		// 데이터 건수 조회
		
		try {
			String query = "select count(*) from sandwich_cafe ";
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			this.rs.next();
			
			return rs.getInt("count(*)");
		} catch (SQLException e) {
			System.out.println("countDB ERROR : " + e.getMessage());
			return 999;
		}
	}

	// 전체 데이터 조회해서 ResultSet으로 반환
	public ResultSet selectDB() {
		try {
			String query = "select * from sandwich_cafe ";
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			
			return rs;
		} catch (SQLException e) {
			System.out.println("countDB ERROR : " + e.getMessage());
			return null;
		}
	}

	/** ResultSet Statement Connection close **/
	public void closeDB(ResultSet rs, Statement stmt, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSE ERR : " + e.getMessage());
		}
	}

	/** ResultSet PreparedStatement Connection close **/
	public void closeDB(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSE ERR : " + e.getMessage());
		}
	}

	/** PreparedStatement Connection close **/
	public void closeDB(PreparedStatement pstmt, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSE ERR : " + e.getMessage());
		}
	}
	public void closeDB() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSE ERR : " + e.getMessage());
		}
	}
}
