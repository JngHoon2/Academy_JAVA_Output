package com.javalab.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalab.service.EmployeesService;
import com.javalab.vo.Employees;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class EmployeesController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@RequestMapping("/")
	public String home() {
		log.info("employeesController/home() execute!");
		return "redirect:/employeesList";
	}
	
	@RequestMapping("/employeesList")
	public ModelAndView getEmployeesList() {
		log.info("employeesController/getEmployeesList() execute!");
		ModelAndView result = new ModelAndView();
		List<Employees> employeesList = employeesService.getEmployeesList();
		
		result.addObject("employeesList", employeesList);
		result.setViewName("/employeesList");
	
		return result;
	}
	
	@RequestMapping("/member")
	public String getMember(@RequestParam("id") int id, Model model) {
		model.addAttribute("member", employeesService.getMember(id));
		
		return "/member";
	}
}
