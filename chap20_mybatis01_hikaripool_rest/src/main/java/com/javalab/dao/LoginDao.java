package com.javalab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.vo.RoleVo;
import com.javalab.vo.UserVO;

// 메퍼 인터페이스
@Mapper
public interface LoginDao {
	// 로그인 유저 조회
	UserVO getUserById(UserVO vo);

}
