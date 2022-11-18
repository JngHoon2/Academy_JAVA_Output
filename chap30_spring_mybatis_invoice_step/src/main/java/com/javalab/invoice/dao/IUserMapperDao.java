package com.javalab.invoice.dao;

import java.util.List;

import com.javalab.invoice.dto.AddressVo;
import com.javalab.invoice.dto.CustomUser;
import com.javalab.invoice.dto.UserRole;

/**
 * UserMapper 인터페이스 매퍼
 *  - 서비스 Layer와 매퍼XML을 연결시켜주는 역할
 */

//@Mapper 
public interface IUserMapperDao {
	
	public CustomUser getUserByUsername(String userName);
	public int hasUsername(String username);
	public UserRole getUserRolesByUsername(String user_id);
	public int getCountIdById(String userName);
	public void insertUser(CustomUser user);
	public void insertUserRole(UserRole userRole);
	public List<AddressVo> getAddressByDong(String dong);
	public void updateUser(CustomUser customUser);

}