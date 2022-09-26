package com.javalab.service;

import java.util.List;

import com.javalab.vo.RoleVo;
import com.javalab.vo.UserVO;

public interface UserService {
	public List<RoleVo> getRoles();
	
	public void insertUser(UserVO vo);
	
	public int idCheck(String id);
}