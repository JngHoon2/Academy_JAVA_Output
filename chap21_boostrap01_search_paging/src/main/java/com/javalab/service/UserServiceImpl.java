package com.javalab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.UserDao;
import com.javalab.vo.RoleVo;
import com.javalab.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	public UserServiceImpl() {
	}
	
	@Override
	public int idCheck(String id) {
		return dao.idCheck(id);
	}
	
	@Override
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	
	@Override
	public List<RoleVo> getRoles() {
		return dao.getRoles();
	}
}
