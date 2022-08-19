package database;

public class JDBC_Connect01_driver_load {
	public static void main(String[] args) {
		//1. 드라이버 연결 
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로드 실패 : " + e.getMessage());
		}
	}
}
