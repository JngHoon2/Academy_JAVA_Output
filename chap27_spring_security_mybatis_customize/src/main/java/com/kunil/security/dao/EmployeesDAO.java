package com.kunil.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kunil.security.dto.EmployeeCommonDto;
import com.kunil.security.vo.Criteria;
import com.kunil.security.vo.Employee;

/*
 * 매퍼 인터페이스 : Service Layer와 매퍼xml(sql쿼리문)을 연결해주는 역할(bridge)
 */
@Mapper
public interface EmployeesDAO {
	
	List<EmployeeCommonDto> getEmployeeList(Criteria cri);
	Employee getMember(int employeeId);
	int getTotalEmployees(Criteria cri);


}