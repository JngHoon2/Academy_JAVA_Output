/**
 * 
 */
package com.javalab.invoice.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.invoice.dao.IUserMapperDao;
import com.javalab.invoice.dto.AddressVo;
import com.javalab.invoice.dto.CustomUser;
import com.javalab.invoice.dto.UserRole;

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

	/**
	 * getUserByUsername
	 */
	public CustomUser getUserByUsername(String userName) {
		log.info("AuthServiceImpl getUserByUsername " + userName);
		CustomUser customUser = userMapperDao.getUserByUsername(userName);		
		return customUser;
	}

	/**
	 * getUserRole
	 */
	@Override
	public UserRole getUserRolesByUsername(String user_id) {
		UserRole userRole = userMapperDao.getUserRolesByUsername(user_id);
		//System.out.println("AuthServiceImpl getUserRolesByUsername() : " + role.toString());
		return userRole;
	}
	
	// 트랜잭션
	@Override
	public void insertUserAndRole(CustomUser user, UserRole userRole) {

		log.info("AuthServiceImpl before insertUser() username is : " + user.getUser_id());
		
		// 사용자 등록
		userMapperDao.insertUser(user);
		
		log.info("AuthServiceImpl userRole.getUser_id() : " + userRole.getUser_id());
		
		// 사용자 등록이 완료되면 사용자 권한 등록
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

	@Override
	public void updateUser(CustomUser customUser) {
		userMapperDao.updateUser(customUser);		
	}

	


} 