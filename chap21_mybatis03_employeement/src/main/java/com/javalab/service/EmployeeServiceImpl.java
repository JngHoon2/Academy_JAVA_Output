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
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;

import lombok.extern.slf4j.Slf4j;


@Service("employeeService")
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
	
	public EmployeeServiceImpl() {}
	
	@Override
	public List<EmployeeCommonDto> getEmployeeList(Criteria cri) {
		log.info("getEmployeeList(from EmployeeServiceImpl) 메소드 실행!");
		
		return this.dao.getEmployeeList(cri);
	}

	@Override
	public int getTotalEmployees(Criteria cri) {
		log.info("getTotalEmployees(from EmployeeServiceImpl) 메소드 실행!");
		
		return this.dao.getTotalEmployees(cri);
	}
	
}