/**
 * 
 */
package com.javalab.invoice.service.user;

import java.util.List;

import com.javalab.invoice.dto.AddressVo;
import com.javalab.invoice.dto.CustomUser;
import com.javalab.invoice.dto.UserRole;


/**
 * 
 * @author admin
 *
 */
public interface IAuthService {
	
	int hasUsername(String username);
	void insertUserAndRole(CustomUser user, UserRole userRole);
	CustomUser getUserByUsername(String userName);
	UserRole getUserRolesByUsername(String user_id);
	int getCountId(String id);
	List<AddressVo> getAddressByDong(String dong);
	CustomUser getMemberInfo(String user_id);
	void updateUser(CustomUser customUser);

} 