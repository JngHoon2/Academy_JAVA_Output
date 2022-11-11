/**
 * 
 */
package com.kunil.security.service;

import java.util.List;

import com.kunil.security.vo.AddressVo;
import com.kunil.security.vo.CustomUser;
import com.kunil.security.vo.Role;
import com.kunil.security.vo.UserRole;

public interface IAuthService {
	
	int hasUsername(String username);
	void insertUserAndRole(CustomUser user, UserRole userRole);
	CustomUser getUserByUsername(String userName);
	Role getUserRolesByUsername(String user_id);
	int getCountId(String id);
	List<AddressVo> getAddressByDong(String dong);
	CustomUser getMemberInfo(String user_id);

} 