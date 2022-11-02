package com.javalab.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.EmployeesDao;
import com.javalab.vo.Employees;

import lombok.extern.slf4j.Slf4j;


@Service("employeeService")
@Slf4j
public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	private EmployeesDao dao;
	
	public EmployeesServiceImpl() {}
	
	@Override
	public List<Employees> getEmployeesList() {
		log.info("EmployeesServiceImpl/getEmployeeList() execute!");
		
		return dao.getEmployeesList();
	}

	@Override
	public Employees getMember(int employeesId) {
		
		return dao.getMember(employeesId);
	}
	
}