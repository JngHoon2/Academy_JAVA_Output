package database.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import database.util.MethodClass;

public class DatabaseClass {
	public final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";		// 접속할 데이터베이스 드라이버
	public final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";		// 접속할 데이터베이스 서버 주소
	
	public String db_name = null;  				// 사용할 데이터베이스명
	public String db_admin_pw = null; 			// 접속할 데이터베이스 관리자 비밀번호
	public Connection conn = null;				// 최종 접속 객체
	public Statement stmt = null;					// 전체 조회 select * from ~
	public PreparedStatement pstmt = null;	// 테이블에 변수로 데이터 전달
	public ResultSet rs = null;						// select의 결과 객체 저장
	public int result_update = 0;					// insert/update/delete  결과 저장
	
	public DatabaseClass() {
	}

	//드라이버 로드 및 데이터베이스 접속 메서드, DB 연결 문자열을 파라미터로 받고 있음 
	public void connectDB(String db_name, String db_pwd) {
		this.db_name = db_name;
		try {
			Class.forName(this.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공!");
			
			String url = this.DB_URL;
			conn = DriverManager.getConnection(url, db_name, db_pwd);
			System.out.println("2. DB접속성공!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD ERR : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("CONNECTION ERR : "+e.getMessage());
		}
	} // connectMySQL() END
	
	
	/** 조회 결과 반환된 ResultSet 에서 레코드에 대한 메타 데이터 정보(필드명) 추출 **/
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
	
	/** 1. 사원의 이름과 급여와 입사일자만을 출력하기 **/
	public String quiz1() {
		String query = "select eName, sal, to_char(hiredate,'yyyy-mm-dd') as hiredate "
						+ " from emp ";
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			
			// Resultset을 보내서 타이틀만 받아옴
			String[] fieldNames = this.getFieldNames(this.rs);			
			// 태그 생성 메소드 호출
			String resultTags = MethodClass.makeTagsQ1(rs, fieldNames);	
			return resultTags;
		} catch (SQLException e) {
			System.out.println("quiz1() ERR : "+e.getMessage());
		} finally {
			this.userClose(this.rs, this.stmt);
		}
		return null;		
	} // quiz1() END

	private void userClose(ResultSet rs, Statement stmt) {
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
