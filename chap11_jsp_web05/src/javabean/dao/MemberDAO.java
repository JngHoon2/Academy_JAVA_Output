package javabean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javabean.MemberBean;

public class MemberDAO 
{
	private static MemberDAO instance;
	private MemberDAO(){}
	
	public static MemberDAO getInstance(){
		if(instance == null ) instance = new MemberDAO();
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
			//conn.commit(); 

		}catch(Exception e) {
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
}