package com.javalab.security.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomUser implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	// spring security related fields
	private List<Role> authorities;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	
	public CustomUser(Users users) {
		this.username = users.getUsername();
		this.password = users.getPassword();
		this.enabled = users.getEnabled() == 1 ? true : false;
	}
}
