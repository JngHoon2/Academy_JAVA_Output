package com.kunil.security.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunil.security.dao.EmployeesDAO;
import com.kunil.security.dto.EmployeeCommonDto;
import com.kunil.security.vo.Criteria;
import com.kunil.security.vo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeesDAO dao;

	public List<EmployeeCommonDto> getEmployeesList(Criteria cri) {

		return dao.getEmployeeList(cri);
	}

	@Override
	public Employee getMember(int employeeId) {
		
		return dao.getMember(employeeId);
	}

	@Override
	public int getTotalEmployees(Criteria cri) {
		return dao.getTotalEmployees(cri);
	}

	
}