package com.magicoh.springmvc.dto;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements GrantedAuthority {

	private static final long serialVersionUID = 7464267597005842862L;
	
	private Integer user_role_id;
	private String user_id;
	private String role_id;
	
	@Override
	public String getAuthority() {
		return this.role_id;
	}
	
}