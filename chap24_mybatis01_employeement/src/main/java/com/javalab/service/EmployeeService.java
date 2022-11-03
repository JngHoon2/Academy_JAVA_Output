package com.javalab.service;

import java.util.List;

import com.javalab.dto.EmployeeCommonDto;
import com.javalab.vo.Criteria;
import com.javalab.vo.Employee;


public interface EmployeeService {
	public List<EmployeeCommonDto> getEmployeeList(Criteria cri);	// 전사원조회	
	//public List<EmployeeCommonDto> getEmployeeList(EmployeeCommonDto eDto);	// 전사원조회
	public int getTotalEmployees(Criteria cri);			// 페이징을 위한 사원숫자 조회	
	public Employee getEmpById(int employeeId);
	public void updateEmp(Employee vo);
}

