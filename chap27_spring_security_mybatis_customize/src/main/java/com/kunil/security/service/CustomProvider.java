package com.kunil.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.kunil.security.vo.CustomUser;
import com.kunil.security.vo.Role;
import com.kunil.security.vo.UserRole;

import lombok.extern.java.Log;

/**
 * AuthenticationProvider + UserDetailsService 인터페이스 구현 클래스
 */
@Service
@Log
public class CustomProvider implements AuthenticationProvider, UserDetailsService 
{
	
	@Autowired
	private IAuthService authService;
	
    @Autowired
	public void setDataSource(DataSource dataSource) {
    	log.info("CustomProvider setDataSource(DataSource dataSource) datasource : " + dataSource);
	}
	
    /**
     * AuthenticationProvider - authenticate : 실제로 인증이 진행되는 메소드  
     * @param Authentication authentication - 화면에서 입력한 정보를 담고 있는 객체 
     */
	@Override
	public Authentication authenticate(Authentication authentication) 
				throws AuthenticationException {
		
		log.info("CustomProvider authenticate() - 1");
		
		//authentication.화면에서 입력한 id/pw 를 갖고온다.
		String user_id = (String) authentication.getPrincipal();	//화면에서 입력한 아이디
        String user_pwd = (String) authentication.getCredentials();	//화면에서 입력한 비밀번호

        log.info("CustomProvider > authenticate user_id : " + user_id + " user_pwd : " + user_pwd);
        
        //get user info
        CustomUser user = (CustomUser)this.loadUserByUsername(user_id);	// 사용자ID 존재유무 확인
    	if (user == null){
    		throw new UsernameNotFoundException("존재하지 않는 ID입니다.");
    	}	

    	log.info("CustomProvider > authenticate 데이터베이스에서 갖고온 비밀번호 : " + user.getPassword());
    	
    	// 데이터베이스에서 갖고온 비밀번호와 사용자가 입력한 비밀번호 비교 
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
 
    	if (!passwordEncoder.matches(user_pwd, user.getPassword())) {
    		throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
    	}	

    	// 권한을 갖고옴
        Role role = (Role)this.loadUserRole(user_id);
        List<Role> userRoles = new ArrayList<Role>();
        userRoles.add(role);		
        user.setAuthorities(userRoles);
        
        log.info("role.toString() : " + role.toString());

        //get Authorities
        Collection<? extends GrantedAuthority> authorities = null;
        authorities = user.getAuthorities();
        
        return new UsernamePasswordAuthenticationToken(user, user_pwd, authorities);
	}
    
	/**
	 * 유저의 아이디로 상세 정보를 갖고 오는 메소드
	 * UserDetailsService 인터페이스에 있는 메소드 오버라이딩 
	 */
    @Override
	public CustomUser loadUserByUsername(String userName) {    	
    	
    	CustomUser customUser = new CustomUser(); // 개발자가 만든 vo 클래스
    	customUser = (CustomUser)authService.getUserByUsername(userName);

    	return customUser;    	
    }
	
    // get user roles
	private Role loadUserRole(String user_id) {
    	log.info("CustomProvider loadUserRole() - 1");

    	Role userRole = new Role();
    	userRole = (Role)authService.getUserRolesByUsername(user_id);
    	return userRole;    	
	}
	
	// AuthenticationProvider의 메소드 오버라이딩
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}