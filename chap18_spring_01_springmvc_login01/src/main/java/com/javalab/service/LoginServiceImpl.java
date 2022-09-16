package com.javalab.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.BoardDAO;
import com.javalab.dao.LoginDao;
import com.javalab.vo.BoardVO;
import com.javalab.vo.UserVo;


@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginDao loginDao;

	public LoginServiceImpl() {}
	
	@Override
	public UserVo getUser(UserVo vo) {
		return this.loginDao.getUser(vo);
	}
}
