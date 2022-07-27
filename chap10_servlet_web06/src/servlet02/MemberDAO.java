package servlet02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	/*
	 * Server의 context.xml에 설정 private static final String driver =
	 * "oracle.jdbc.driver.OracleDriver"; private static final String url =
	 * "jdbc:oracle:thin:@localhost:1521:XE"; private static final String user =
	 * "scott"; private static final String pwd = "tiger";
	 */

	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	// 데이터베이스에 대한 소스 정보 객체
	private DataSource dataSource;

	public MemberDAO() {
		try {
			System.out.println("MemberDAO 생성자 JNDI 작업");
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<MemberVO> listMembers() {
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			// connectDB();
			con = dataSource.getConnection();
			String query = "select * from members ";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertMember(MemberVO vo) {
		String id = vo.getId();
		String pwd = vo.getPwd();
		String name = vo.getName();
		String email = vo.getEmail();
		
		long miliseconds = System.currentTimeMillis();
		Date joinDate = new Date(miliseconds);
		
		try {
			con = dataSource.getConnection();
			String query = "insert into members values(?,?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setDate(5, joinDate);
			
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("데이터 삽입!");
			
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("데이터 삽입 오류!");
		}
		
	}

	public void delMember(String id) {
		try {
			con = dataSource.getConnection();
			String query = "delete from members where id = '" + id + "'";
			System.out.println("prepareStatememt: " + query);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println("데이터 삭제!");
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("데이터 삭제 오류 !");
		}
	}
	
	

	/*
	 * private void connectDB() { try { Class.forName(driver);
	 * System.out.println("Oracle 드라이버 로딩 성공"); con =
	 * DriverManager.getConnection(url, user, pwd);
	 * System.out.println("Connection 성공"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

}