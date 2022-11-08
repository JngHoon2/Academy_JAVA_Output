package com.javalab.security.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javalab.security.vo.Users;

import lombok.extern.slf4j.Slf4j;
/*
 * Spring JDBC를 사용 : javalab
 */
@Repository("authJdbcService")
@Slf4j
public class AuthJdbcService {
	
	private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    // 사용자가 있는지 확인
    public boolean hasUsername(String username) {    	
    	log.info("여기는 AuthJdbcService > hasUsername");    	
    	boolean flag = false;
    	String sql = "SELECT * FROM users WHERE username=?";    	
    	log.info("hasUsername : " + username);    	
    	try {    		
    		 Users user = (Users)this.jdbcTemplate
    				 				 .queryForObject(sql, 
								   		     new Object[]{ username },
								   		     new BeanPropertyRowMapper<Users>(Users.class));
    		 flag = user != null ? true : false;    		 
		} catch (Exception e) {
			flag=false;
		}    	
    	return flag;
    }
    
    // 사용자/권한 저장
    public void insertUsers(Users users, String role) {
    	
    	log.info("insertUsers");
    	
    	String sql  = "INSERT INTO users VALUES (?, ?, 1)";
    	String sql2 = "INSERT INTO user_roles VALUES "
    				+ "(user_roles_seq.nextval, ?, ?)";
    	
    	this.jdbcTemplate.update(sql, 
    							 new Object[] { users.getUsername(), 
											    users.getPassword() });    	
    	this.jdbcTemplate.update(sql2, 
    							 new Object[] { users.getUsername(),
											    role });    	
    } 
} 