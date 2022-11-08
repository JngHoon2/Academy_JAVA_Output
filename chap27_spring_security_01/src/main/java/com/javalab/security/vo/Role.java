package com.javalab.security.vo;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 7464267597005842862L;
	
	private String username;
	private String role;
	
	@Override
	public String getAuthority() {
		return this.role;
	}
}
