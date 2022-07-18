package jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MethodClass {
	
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	public static Connection con = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static String ID;
	public static String PWD;
	
	public MethodClass(String ID, String PWD) {
		this.ID = ID;
		this.PWD = PWD;
	}
	
	public static void connectDB() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("드라이버 로드 성공");
			
			con = DriverManager.getConnection(DB_URL, ID, PWD);
			System.out.println("커넥션 객체 생성 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패, " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
		}
	}

	public static void selectAll() {
		
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "select * from member";
			//5
			rs = stmt.executeQuery(sql); 
			
			//6
			System.out.println("name" + "\t"
					+ "userID" + "\t" 
					+ "pwd" + "\t"
					+ "email" + "\t\t" 
					+ "phone" + "\t"
					+ "admin");
			while (rs.next()) { 
				System.out.println(rs.getString("name") + "\t"
						+ rs.getString("userID") + "\t" 
						+ rs.getString("pwd") + "\t"
						+ rs.getString("email") + "\t" 
						+ rs.getString("phone") + "\t"
						+ rs.getString("admin"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
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

	public static void countRecord() {
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "select count(*) from member";
			//5
			rs = stmt.executeQuery(sql); 
			
			//6
			System.out.println("count(*)");
			while (rs.next()) { 
				System.out.println(rs.getString("count(*)"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
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

	public static void duplicateID(String id) {
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "select * from member "
					+ "where userID = '" + id + "'";
			//5
			rs = stmt.executeQuery(sql); 
			
			//6
			System.out.println("name" + "\t"
					+ "userID" + "\t" 
					+ "pwd" + "\t"
					+ "email" + "\t\t" 
					+ "phone" + "\t"
					+ "admin");
			while (rs.next()) { 
				System.out.println(rs.getString("name") + "\t"
						+ rs.getString("userID") + "\t" 
						+ rs.getString("pwd") + "\t"
						+ rs.getString("email") + "\t" 
						+ rs.getString("phone") + "\t"
						+ rs.getString("admin"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
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

	public static void insertTable(String name, String userID, String pwd, String email, String phone, int admin) {
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "insert into member values("+"'"+name+"', "+"'"+userID+"', "+"'"+pwd+"', "+"'"+email+"', "+"'"+phone+"', "+ admin+ ")";
			System.out.println(sql);
			//5
			rs = stmt.executeQuery(sql); 
			
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
		} 
	}

	public static void updateTable(String name, String userID, String pwd, String email, String phone, int admin) {
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "update member set "+"name = '"+name+"', "+"userID = '"+userID+"', "
			+"pwd = '"+pwd+"', "+"email = '"+email+"', "+"phone = '"+phone+"', admin = "+ admin
			+ " where userID = '" + userID + "'";
			System.out.println(sql);
			//5
			rs = stmt.executeQuery(sql); 
			
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
		} 
	}

	public static void deleteTable(String userID) {
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "delete from member where userID = '" + userID +"'";
			//5
			rs = stmt.executeQuery(sql); 
			
		} catch (SQLException e) {
			System.out.println("SQL 오류, " + e.getMessage());
		} 
	}
}
