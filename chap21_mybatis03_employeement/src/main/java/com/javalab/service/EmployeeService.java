package com.javalab.service;

import java.util.List;

import com.javalab.dto.EmployeeCommonDto;
import com.javalab.vo.Criteria;


public interface EmployeeService {

	List<EmployeeCommonDto> getEmployeeList(Criteria cri);
	
	int getTotalEmployees(Criteria cri);
}

