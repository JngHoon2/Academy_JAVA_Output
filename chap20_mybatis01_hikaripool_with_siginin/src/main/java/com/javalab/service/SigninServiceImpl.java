package com.javalab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.SigninDao;
import com.javalab.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Service("SigninService")
@Slf4j
public class SigninServiceImpl implements SigninService{
	
	@Autowired
	private SigninDao signinDao;

	@Override
	public UserVo addUser(UserVo vo) {
		log.info("(Method) addUser(from SignServiceImpl) is execute!");
		return this.signinDao.addUser(vo);
	}
}
