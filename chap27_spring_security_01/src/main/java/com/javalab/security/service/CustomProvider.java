package com.javalab.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javalab.security.vo.CustomUser;
import com.javalab.security.vo.Role;

import lombok.extern.java.Log;

@Service
@Log
public class CustomProvider implements AuthenticationProvider, UserDetailsService{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 사용자 조회
	// UserDetailService 인터페이스에 있는 유일한 메소드로 조회한 사용자가 있는지 확인함.
	@Override
	public CustomUser loadUserByUsername(String userName) {
		log.info("loadUserByUsername");
		
		try {
			return (CustomUser)jdbcTemplate.queryForObject(
					"SELECT * FROM users where username=?",
					new Object[] {userName},
					new BeanPropertyRowMapper<CustomUser>(CustomUser.class));
					
		} catch (EmptyResultDataAccessException e) {
			log.info("error1");
			return null;
		}
	}
	
	// 권한 조회
	// 사용자 ID로 권한 테이블에서 권한 조회
	private Role loadUserRole(String userName) {
		log.info("loadUserRole");
		
		try {
			return (Role)jdbcTemplate.queryForObject(
						"SELECT username, role FROM user_roles WHERE username=?",
						new Object[] {userName},
						new BeanPropertyRowMapper<Role>(Role.class));
		} catch (EmptyResultDataAccessException e) {
			log.info("error2");
			return null;
		}
	}
	
	// 실제로 인증을 진행하는 메소드
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.info("authenticate");
		
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		CustomUser user = null;
		
		// 인중된 사용자의 권한을 담을 저장소
		Collection<? extends GrantedAuthority> authorities = null;
		
		try {
			// 조회한 사용자의 모든 정보가 담겨있음.
			user = this.loadUserByUsername(username);
			Role role = this.loadUserRole(username);
			
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			user.setAuthorities(roles);
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			if (passwordEncoder.matches(password, user.getPassword()))
				log.info("비밀번호 일치!");
			else
				throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
			
			authorities = user.getAuthorities();
		} catch (UsernameNotFoundException e) {
			log.info(e.toString());
			throw new UsernameNotFoundException(e.getMessage());
		} catch (BadCredentialsException e) {
			log.info(e.toString());
			throw new BadCredentialsException(e.getMessage());
		} catch (Exception e) {
			log.info(e.toString());
			e.printStackTrace();
		}
		
		log.info("시큐리티 토큰 생성 완료!");
		
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
}
