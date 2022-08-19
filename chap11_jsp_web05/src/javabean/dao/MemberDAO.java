package javabean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javabean.Dept;
import javabean.EmpClass;
import javabean.MemberBean;

public class MemberDAO {
	private static MemberDAO instance;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public void joinMember(MemberBean bean) {

		String id = bean.getId();
		String pwd = bean.getPwd();
		String name = bean.getName();
		String email = bean.getEmail();

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			StringBuffer query = new StringBuffer();
			query.append("insert into members values(?,?,?,?, sysdate)");
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query.toString());

			// pstm에 인자 전달 MemberBean 게터 메소드 사용
			pstm.setString(1, id);
			pstm.setString(2, pwd);
			pstm.setString(3, name);
			pstm.setString(4, email);

			pstm.executeUpdate();
			// conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
					pstm = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end joinMember()

	public ArrayList<Dept> deptList() {

		ArrayList<Dept> deptList = new ArrayList<Dept>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String query = "select * from dept";
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				deptList.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

			return deptList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public ArrayList<EmpClass> empList() {

		ArrayList<EmpClass> empList = new ArrayList<EmpClass>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String query = "select * from emp";
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				empList.add(new EmpClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}

			return empList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public ArrayList<MemberBean> memberList() {

		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String query = "select * from members";
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				memberList.add(new MemberBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}

			return memberList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}