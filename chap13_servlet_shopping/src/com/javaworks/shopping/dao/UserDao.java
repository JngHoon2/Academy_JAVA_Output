package com.javaworks.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaworks.shopping.model.User;

public class UserDao {

	private Connection conn = null;
	private String sql = "";
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public UserDao(Connection conn) {
		this.conn = conn;
	}
	
	public User login(String userId, String userPwd) {
		User user = null;
		
		try {
			sql = "Select * From users Where user_id = ? and user_pwd = ?";
			//파라미터 세팅
			psmt = this.conn.prepareStatement(sql);
			psmt.setString(1, userId);			
			psmt.setString(2, userPwd);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserPwd(rs.getString("user_pwd"));	
				user.setUserName(rs.getString("user_name"));
				user.setUserEmail(rs.getString("user_email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}
}
