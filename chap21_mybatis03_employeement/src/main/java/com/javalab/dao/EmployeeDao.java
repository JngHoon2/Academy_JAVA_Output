package com.javalab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.javalab.dto.EmployeeCommonDto;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;

@Mapper
public interface EmployeeDao {
	
	List<EmployeeCommonDto> getEmployeeList(Criteria cri);
	
	int getTotalEmployees(Criteria cri);
}