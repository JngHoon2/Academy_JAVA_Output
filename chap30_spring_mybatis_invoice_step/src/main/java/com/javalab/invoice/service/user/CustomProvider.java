package com.javalab.invoice.service.user;

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

import com.javalab.invoice.dto.CustomUser;
import com.javalab.invoice.dto.UserRole;

import lombok.extern.java.Log;

/**
 * 동시에 AuthenticationProvider UserDetailsService Interface implements
 * @author Administrator
 */
@Service
@Log
public class CustomProvider implements AuthenticationProvider, UserDetailsService 
{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IAuthService authService;
	
    @Autowired
	public void setDataSource(DataSource dataSource) {
    	log.info("CustomProvider setDataSource(DataSource dataSource) datasource : " + dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
    /**
     * Interface AuthenticationProvider Method Override - Actually Authenticate 
     * @param Authentication authentication - 화면에서 입력한 정보 제공     * 
     */
	@Override
	public Authentication authenticate(Authentication authentication) 
				throws AuthenticationException {
		
		log.info("CustomProvider authenticate() - 1");
		
		//authentication.화면에서 입력한 id/pw 를 갖고온다.
		String user_id = (String) authentication.getPrincipal();	//화면에서 입력한 아이디
        String user_pwd = (String) authentication.getCredentials();	//화면에서 입력한 비밀번호

        //get user info
        CustomUser user = (CustomUser)this.loadUserByUsername(user_id);
    	if (user == null){
    		throw new UsernameNotFoundException("존재하지 않는 ID입니다.");
    	}	

    	//compare with input password and database password 
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	if (!passwordEncoder.matches(user_pwd, user.getPassword())) {
    		throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
    	}	

    	//get Role 
        UserRole role = (UserRole)this.loadUserRole(user_id);
        List<UserRole> userRoles = new ArrayList<UserRole>();
        userRoles.add(role);		
        user.setAuthorities(userRoles);
        
        log.info("role.toString() : " + role.toString());

        //get Authorities
        Collection<? extends GrantedAuthority> authorities = null;
        authorities = user.getAuthorities();
        
        return new UsernamePasswordAuthenticationToken(user, user_pwd, authorities);
	}
    
	/**
	 * dataloadUserByUsername Method
	 * Interface UserDetailsService which loads user-specific 
	 * @param String userName
	 */
    @Override
	public CustomUser loadUserByUsername(String userName) {
    	
    	//쿼리
    	log.info("CustomProvider loadUserByUsername() - 1 userName " + userName);
    	
    	CustomUser customUser = new CustomUser();
    	customUser = (CustomUser)authService.getUserByUsername(userName);
    	
    	return customUser;    	
    }
	
    /*
     * get user roles
     * @param userName(user_id)
     */
	private UserRole loadUserRole(String user_id) {
    	log.info("CustomProvider loadUserRole() - 1");

    	UserRole userRole = new UserRole();
    	userRole = (UserRole)authService.getUserRolesByUsername(user_id);
    	return userRole;    	
	}
	

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

} //