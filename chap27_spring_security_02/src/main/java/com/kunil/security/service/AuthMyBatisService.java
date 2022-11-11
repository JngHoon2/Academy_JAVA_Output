/**
 * 
 */
package com.kunil.security.service;

import com.kunil.security.vo.Users;

/**
 * @author javalab
 *
 */
public interface AuthMyBatisService {
	
	boolean hasUsername(String username);
	void insertUsers(Users users, String role);

} //