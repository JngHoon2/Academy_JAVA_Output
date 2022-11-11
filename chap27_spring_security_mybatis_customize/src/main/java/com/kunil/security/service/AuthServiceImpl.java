/**
 * 
 */
package com.kunil.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunil.security.dao.IUserMapperDao;
import com.kunil.security.vo.AddressVo;
import com.kunil.security.vo.CustomUser;
import com.kunil.security.vo.Role;
import com.kunil.security.vo.UserRole;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthServiceImpl implements IAuthService {
	
	@Autowired
	private IUserMapperDao userMapperDao;

	@Override
	public int hasUsername(String username) {
		log.info("AuthServiceImpl hasUsername() parmete : " + username);
		return userMapperDao.hasUsername(username);
	} 

	public CustomUser getUserByUsername(String userName) {
		log.info("AuthServiceImpl getUserByUsername " + userName);
		CustomUser customUser = userMapperDao.getUserByUsername(userName);		
		return customUser;
	}

	/**
	 * getUserRole
	 */
	@Override
	public Role getUserRolesByUsername(String user_id) {
		Role userRole = userMapperDao.getUserRolesByUsername(user_id);
		//System.out.println("AuthServiceImpl getUserRolesByUsername() : " + role.toString());
		return userRole;
	}
	
	@Override
	public void insertUserAndRole(CustomUser user, UserRole userRole) {
		log.info("AuthServiceImpl before insertUser() username is : " + user.getUsername());
		
		//insert user
		userMapperDao.insertUser(user);
		log.info("AuthServiceImpl userRole.getUser_id() : " + userRole.getUserId());
		
		//insert user role
		userMapperDao.insertUserRole(userRole);

		log.info("AuthServiceImpl after insertRole()");
		
	}

	@Override
	public int getCountId(String id) {
		return userMapperDao.getCountIdById(id);
	}

	@Override
	public List<AddressVo> getAddressByDong(String dong) {
		List<AddressVo> AddressList = userMapperDao.getAddressByDong(dong);
		return AddressList;
	}

	@Override
	public CustomUser getMemberInfo(String user_id) {
		log.info("AuthServiceImpl getMemberInfo " + user_id);
		CustomUser customUser = userMapperDao.getUserByUsername(user_id);		
		return customUser;
	}

} 