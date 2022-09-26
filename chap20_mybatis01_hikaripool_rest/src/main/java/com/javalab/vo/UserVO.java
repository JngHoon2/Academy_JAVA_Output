package com.javalab.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String roleId;	
	private Date joinDate; 	

}
