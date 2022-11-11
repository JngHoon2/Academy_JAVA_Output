package com.kunil.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kunil.security.dto.EmployeeCommonDto;
import com.kunil.security.vo.Criteria;
import com.kunil.security.vo.Employee;

@Service
public interface EmployeeService {

	List<EmployeeCommonDto> getEmployeesList(Criteria cri);
	public int getTotalEmployees(Criteria cri);			// 페이징을 위한 사원숫자 조회	
	Employee getMember(int employeeId);

}