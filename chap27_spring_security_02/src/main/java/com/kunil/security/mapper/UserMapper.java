/**
 * 
 */
package com.kunil.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kunil.security.vo.Role;
import com.kunil.security.vo.Users;

/**
 * mapper
 * 
 * @author javalab
 *
 */
@Mapper
public interface UserMapper {

	Users getUserByUsername(String userName);

	Role getUserRolesByUsername(String userName);

	int hasUsername(String username);

	Users loadUserByUsername(String userName);

	void insertUser(@Param("users") Users users);

	void insertUserRoles(@Param("username") String username, @Param("role") String role);

}