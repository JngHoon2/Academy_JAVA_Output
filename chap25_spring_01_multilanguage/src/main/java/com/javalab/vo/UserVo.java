package com.javalab.vo;

import java.sql.Date;

public class UserVo {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String role_id;	
	private Date joinDate;
	
	public UserVo() {
	}

	public UserVo(String id, String name, String email, String role_id, Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role_id = role_id;
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}



	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", role_id=" + role_id
				+ ", joinDate=" + joinDate + "]";
	}

}
