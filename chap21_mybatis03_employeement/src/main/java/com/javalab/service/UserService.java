package com.javalab.service;

import java.util.List;

import com.javalab.vo.RoleVo;
import com.javalab.vo.UserVO;

public interface UserService {

	public int idCheck(String id);
	public void insertUser(UserVO vo);
	// 권한 코드 조회
	public List<RoleVo> getRoles();

}
