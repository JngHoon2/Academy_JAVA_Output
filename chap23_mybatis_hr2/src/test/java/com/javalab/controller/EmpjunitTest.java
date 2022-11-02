package com.javalab.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.dao.EmployeesDao;
import com.javalab.vo.Employees;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class EmpjunitTest {
	
	@Inject
	private EmployeesDao dao;
	
	@Test
	public void testemp() {
		assertNotNull(dao);
		log.info(dao + " ");
	}
	
	@Test @Ignore
	public void testEmpList() {
		List<Employees> list = dao.getEmployeesList();
		log.info("전체 사원수 list.size() : " + list.size()); 
	}
	
	@Test
	public void testGetEmp() {
		Employees emp = dao.getMember(100);
		assertEquals("스티븐", emp.getFirstName());
		log.info(emp.toString());
	}
	
	
}
