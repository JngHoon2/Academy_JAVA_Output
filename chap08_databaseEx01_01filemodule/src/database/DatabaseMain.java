package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		//insertProduct();
		
		//updateProduct();
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
		try {
			String sql = "";
			
			int p_id = 22;
			String name = "양상";
			int price = 2000;
			int c_id = 5;
			String date = "2022/07/18";

			sql = "insert into product values(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setString(4, name);
			pstmt.setString(5, date);
			
			int result = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
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
			} catch (SQLException e) {
				System.out.println("SQL 자원해제 오류 : " + e.getMessage());
			}
		}
	}
	
	private static void updateProduct() {
		try {
			String sql = "";
			
			int price = 505000;
			String name = "탱크로리";

			sql = "update product set price = ? where product_name = '?'";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, name);
			
			pstmt.executeUpdate();
			

		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
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
			} catch (SQLException e) {
				System.out.println("SQL 자원해제 오류 : " + e.getMessage());
			}
		}
	}
}
