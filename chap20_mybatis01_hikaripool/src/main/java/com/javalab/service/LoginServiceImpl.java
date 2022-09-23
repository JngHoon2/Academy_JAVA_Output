package com.javalab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.LoginDao;
import com.javalab.vo.UserVo;

import lombok.extern.slf4j.Slf4j;


@Service("LoginService")
@Slf4j
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	private LoginDao loginDao;

	public LoginServiceImpl() {}
	
	@Override
	public UserVo getUserById(UserVo vo) {
		log.info("(Method) getUserById(from LoginServiceImpl) is execute!");
		return this.loginDao.getUserById(vo);
	}
}
