package com.javalab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.javalab.vo.Employees;

@Mapper
public interface EmployeesDao {
	
	List<Employees> getEmployeesList();
	
	Employees getMember(int employeesId);
}