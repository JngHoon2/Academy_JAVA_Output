package com.javalab.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.BoardDAO;
import com.javalab.dao.EmployeeDao;
import com.javalab.dto.EmployeeCommonDto;
import com.javalab.vo.BoardVO;
import com.javalab.vo.Criteria;
import com.javalab.vo.Employee;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	public EmployeeServiceImpl() {
	}


	@Override
	public List<EmployeeCommonDto> getEmployeeList(Criteria cri) {
	//public List<EmployeeCommonDto> getEmployeeList(EmployeeCommonDto eDto) {
		//log.info(cri.toString());
		List<EmployeeCommonDto> employeeList = dao.getEmployeeList(cri);
		//List<EmployeeCommonDto> employeeList = dao.getEmployeeList(eDto);
		return employeeList;
	}	
	
	// 전체사원수
	@Override
	public int getTotalEmployees(Criteria cri) {
		return dao.getTotalEmployees(cri);
	}


	// 한사원 조회
	@Override
	public Employee getEmpById(int employeeId) {
		return dao.getEmpById(employeeId);
	}


	@Override
	public void updateEmp(Employee vo) {
		this.dao.updateEmp(vo);
	}


}
