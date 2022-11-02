package com.javalab.service;

import java.util.List;

import com.javalab.vo.Employees;

public interface EmployeesService {

	public List<Employees> getEmployeesList();
	public Employees getMember(int employeesId);
}
