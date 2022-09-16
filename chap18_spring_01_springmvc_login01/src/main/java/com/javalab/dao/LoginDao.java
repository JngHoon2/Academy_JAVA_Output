package com.javalab.dao;

import java.util.List;

import com.javalab.vo.BoardVO;
import com.javalab.vo.UserVo;


public interface LoginDao {

	public UserVo getUser(UserVo vo);
	
}