package javabean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	private static MemberDAO instance;
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public ArrayList<MemberBean> listMembers() {
		ArrayList<MemberBean> list = new ArrayList<>();
		try {
			// connectDB();
			con = DBConnection.getConnection();
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

				MemberBean vo = new MemberBean();
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

	public void insertMember(MemberBean vo) {
		String id = vo.getId();
		String pwd = vo.getPwd();
		String name = vo.getName();
		String email = vo.getEmail();
		
		long miliseconds = System.currentTimeMillis();
		Date joinDate = new Date(miliseconds);
		
		try {
			con = DBConnection.getConnection();
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

	public void updateMember(MemberBean vo) {
		String id = vo.getId();
		String pwd = vo.getPwd();
		String name = vo.getName();
		String email = vo.getEmail();
		
		try {
			con = DBConnection.getConnection();
			String query = "update members set pwd=?, name=?, email=? where id=?";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("데이터 수정!");
			
			
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("데이터 수정 오류!" + e.getMessage());
		} catch (Exception e) {
			System.out.println("dpdu");
		}
		
	}
	
	public void delMember(String id) {
		try {
			con = DBConnection.getConnection();
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
	
	public MemberBean getMember(String id, String pwd) {
		try {
			con = DBConnection.getConnection();
			String query = "select * from members where id=? and pwd=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
			MemberBean member = new MemberBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			
			rs.close();
			pstmt.close();
			con.close();

			return member;
		} catch (Exception e) {
			System.out.println("데이터 조회 오류 !");
			System.out.println(e.getMessage());
			return null;
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