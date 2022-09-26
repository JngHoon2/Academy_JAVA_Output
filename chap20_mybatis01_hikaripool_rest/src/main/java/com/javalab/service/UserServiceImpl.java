package com.javalab.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.LoginDao;
import com.javalab.dao.UserDao;
import com.javalab.vo.RoleVo;
import com.javalab.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService  {
	
	private static final Logger log = 
					LoggerFactory.getLogger(UserServiceImpl.class);
	
	//@Resource(name = "loginDao")
	@Autowired
	private UserDao dao;

	public UserServiceImpl() {
	}

	@Override
	   public List<RoleVo> getRoles() {
	      return dao.getRoles();      
	   }
	
	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public int idCheck(String id) {
		return dao.idCheck(id);
	}
	
	

}