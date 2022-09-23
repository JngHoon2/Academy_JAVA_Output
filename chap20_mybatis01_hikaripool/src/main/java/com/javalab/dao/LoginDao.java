package com.javalab.dao;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.vo.UserVo;

@Mapper
public interface LoginDao {
	// 로그인 유저 조회
	UserVo getUserById(UserVo vo);
}
