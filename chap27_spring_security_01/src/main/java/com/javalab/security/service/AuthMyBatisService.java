/**
 * 
 */
package com.javalab.security.service;

import com.javalab.security.vo.Users;

/**
 * @author javalab
 *
 */
public interface AuthMyBatisService {
	
	boolean hasUsername(String username);
	void insertUsers(Users users, String role);

} //