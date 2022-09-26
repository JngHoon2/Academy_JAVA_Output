package com.javalab.dao;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.vo.UserVo;

@Mapper
public interface SigninDao {
	
	UserVo addUser(UserVo vo);
}
