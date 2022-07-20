package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jxl.Cell;

public class DatabaseClass {

	// 드라이버 로딩 문자열 상수
	public final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver"; // 접속할 데이터베이스 드라이버
	// 데이터베이스 접속 문자열 상수
	public final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 접속할 데이터베이스 서버 주소
	// 일반 멤버 변수
	public String db_name = "gas"; // 사용할 데이터베이스명
	public String db_admin_pw = "1234"; // 접속할 데이터베이스 관리자 비밀번호
	// 데이터베이스 핸들링 객체 4개 선언
	public static Connection con = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;

	public DatabaseClass() {
	}

	// 오라클 드라이버 로드, 데이터베이스 연결(커넥션) 생성
	public void connectDB() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("드라이버 로드 성공");

			con = DriverManager.getConnection(DB_URL, db_name, db_admin_pw);
			System.out.println("커넥션 객체 생성 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패, " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
		}
	}

	private String[] getFieldNames(ResultSet rs) { 
		try {
			// ResultSet에서 메타데이터(레코드, 컬럼정보) 추출 객체 얻음
			ResultSetMetaData rsmd = rs.getMetaData();
			int column_count = rsmd.getColumnCount();	// 컬럼 갯수
			
			String[] columns = new String[column_count];//컬럼 갯수만큼 배열 선언
			// 컬럼 갯수 만큼 반복하면서 배열에 컬럼명 저장
			
			for(int idx = 0; idx < columns.length; idx++) {
				columns[idx] = rsmd.getColumnName(idx + 1); // 제목의 첫 요소가 1부터
				System.out.println(columns[idx]);
			}
			return columns; //컬럼명 배열 반환
		} catch (SQLException e) {
			System.out.println("getColumnNames() ERR : "+e.getMessage());
			return null;
		}
	}
	
	// 읽은 엑셀 데이터의 셀을 인자로 받아서 데이터베이스 gas_station 테이블에 저장
	public void insertData(Cell[] cells) {
		
		// 1. 삽입 SQL 구문
		String Query = "insert into gas_station values(?,?,?,?,?,?,?)";

		// 2. PreparedStatement 객체 얻고, 인자 세팅 작업
		try {
			// 2.1 PreparedStatement 객체 얻기
			pstmt = con.prepareStatement(Query);

			// 2.2 PreparedStatement 인자 세팅(7개) - 자료 타입에 맞춰서
			pstmt.setString(1, cells[0].getContents());
			pstmt.setString(2, cells[1].getContents());
			pstmt.setString(3, cells[2].getContents());
			pstmt.setString(4, cells[3].getContents());
			pstmt.setString(5, cells[4].getContents());
			pstmt.setInt(6, Integer.parseInt(cells[5].getContents()));
			pstmt.setInt(7, Integer.parseInt(cells[6].getContents()));

			// 2.3 데이터베이스 쿼리(삽입)
			pstmt.executeUpdate();

			// 2.4 저장된 갯수 확인[디버깅]

		} catch (SQLException e) {
			System.out.println("INSERT ERR : " + e.getMessage());
		}
	}
	
	public String readData() {

		// 1. 삽입 SQL 구문
		String Query = "select * from gas_station";

		// 2. PreparedStatement 객체 얻고, 인자 세팅 작업
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(Query);
			
			String[] fieldNames = this.getFieldNames(rs);			
			// 태그 생성 메소드 호출
			String resultTags = PrintClass.makeTags(rs, fieldNames);
			System.out.println();
			
			return resultTags;
		} catch (Exception e) {
			System.out.println("SELECT ERR : " + e.getMessage());
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}
}