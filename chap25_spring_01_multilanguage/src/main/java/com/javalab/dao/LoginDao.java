package com.javalab.dao;

import com.javalab.vo.UserVo;

public interface LoginDao {

	// 로그인 유저 조회(queryForObject 메소드 사용)
	UserVo getUser(UserVo vo);

}