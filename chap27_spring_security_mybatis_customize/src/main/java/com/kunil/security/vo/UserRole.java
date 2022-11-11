package com.kunil.security.vo;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRole implements GrantedAuthority {

	private static final long serialVersionUID = 7464267597005842862L;
	
	private Integer userRoleId;
	private String userId;
	private String roleId;
	private String roleName;
	
	@Override
	public String getAuthority() {
		return this.roleId;
	}
	
}