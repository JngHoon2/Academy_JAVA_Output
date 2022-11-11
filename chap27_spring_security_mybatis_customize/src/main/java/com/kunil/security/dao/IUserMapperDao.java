package com.kunil.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kunil.security.vo.AddressVo;
import com.kunil.security.vo.CustomUser;
import com.kunil.security.vo.Role;
import com.kunil.security.vo.UserRole;


/**
 * 매퍼 인터페이스
 */
@Mapper 
public interface IUserMapperDao {
	
	public CustomUser getUserByUsername(String userName);
	//public UserRole getUserRolesByUsername(String userName);
	public int hasUsername(String username);
	//public CustomUser loadUserByUsername(String userName);
	public Role getUserRolesByUsername(String user_id);
	public int getCountIdById(String userName);
	public void insertUser(CustomUser user);
	public void insertUserRole(UserRole userRole);
	public List<AddressVo> getAddressByDong(String dong);

}