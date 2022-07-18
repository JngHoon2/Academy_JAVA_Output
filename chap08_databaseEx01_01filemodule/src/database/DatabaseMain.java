package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMain {
	
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	public static Connection con = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static String ID = "category";
	public static String PWD = "1234";
	
	public static void main(String[] args) {
		connectDB();
		
		//selectAllProducts();
		
		//selectProductByCategoryName();
		
		//selectProductGatherThan();
		
		selectProductGroupByCategory();
		
		insertProduct();
		
		updateProduct();
	}

	private static void connectDB() {
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

	private static void selectAllProducts() {
		
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "select c.category_id, c.category_name, p.product_id, p.product_name, p.price, p.receipt_date "
					+ "from category c inner join product p on c.category_id = p.category_id "
					+ "order by c.category_id asc";
			//5
			rs = stmt.executeQuery(sql); 
			
			//6
			System.out.println("c_id" + "\t"
					+ "c_name" + "\t" 
					+ "p_id" + "\t"
					+ "p_name" + "\t" 
					+ "price" + "\t"
					+ "receipt_date");
			while (rs.next()) { 
				System.out.println(rs.getString("category_id") + "\t"
						+ rs.getString("category_name") + "\t" 
						+ rs.getString("product_id") + "\t"
						+ rs.getString("product_name") + "\t" 
						+ rs.getString("price") + "\t"
						+ rs.getString("receipt_date"));
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
	
	private static void selectProductByCategoryName() {
		try {
			//3
			stmt = con.createStatement();
			//4
			String sql = "select c.category_id, c.category_name, p.product_id, p.product_name, p.price, p.receipt_date "
					+ "from category c inner join product p on c.category_id = p.category_id "
					+ "where c.category_name = '전자제품' "
					+ "order by p.product_name asc";
			//5
			rs = stmt.executeQuery(sql); 
			
			//6
			System.out.println("c_id" + "\t"
					+ "c_name" + "\t" 
					+ "p_id" + "\t"
					+ "p_name" + "\t" 
					+ "price" + "\t"
					+ "receipt_date");
			while (rs.next()) { 
				System.out.println(rs.getString("category_id") + "\t"
						+ rs.getString("category_name") + "\t" 
						+ rs.getString("product_id") + "\t"
						+ rs.getString("product_name") + "\t" 
						+ rs.getString("price") + "\t"
						+ rs.getString("receipt_date"));
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

	private static void selectProductGatherThan() {
		try {
			// 3
			stmt = con.createStatement();
			// 4
			String sql = "select c.category_id, c.category_name, p.product_id, p.product_name, p.price, p.receipt_date "
					+ "from category c inner join product p on c.category_id = p.category_id "
					+ "where p.price >= 25000 " + "order by p.price desc";
			// 5
			rs = stmt.executeQuery(sql);

			// 6
			System.out.println("c_id" + "\t" + "c_name" + "\t" + "p_id" + "\t" + "p_name" + "\t" + "price" + "\t"
					+ "receipt_date");
			while (rs.next()) {
				System.out.println(rs.getString("category_id") + "\t" + rs.getString("category_name") + "\t"
						+ rs.getString("product_id") + "\t" + rs.getString("product_name") + "\t"
						+ rs.getString("price") + "\t" + rs.getString("receipt_date"));
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
	
	private static void selectProductGroupByCategory() {
		try {
			// 3
			stmt = con.createStatement();
			// 4
			String sql = "select c.category_name, sum(p.price) "
					+ "from category c inner join product p on c.category_id = p.category_id "
					+ "group by c.category_name "
					+ "order by sum(p.price) desc";
			
			rs = stmt.executeQuery(sql); 
			
			System.out.println("p_name" + "\t" + "Sum(price)");
			
			while (rs.next()) { 
				System.out.println(rs.getString("category_name") + "\t" 
						+ rs.getString("sum(p.price)"));
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
	
	private static void insertProduct() {
		
	}
	
	private static void updateProduct() {
		
	}
}
