package com.javalab.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalab.dto.EmployeeCommonDto;
import com.javalab.service.BoardService;
import com.javalab.service.EmployeeService;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;
import com.javalab.vo.PageDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/emp") // 컨트롤러 차원의 RequestMapping
@Slf4j
@AllArgsConstructor 
public class EmployeeController {
	
	private EmployeeService empService;
	
	@GetMapping("/list.do")
	public String getemployeeList(Criteria cri, Model model) {
		log.info("getemployeeList(from EmployeeController) 메소드 실행!");
		
		List<EmployeeCommonDto> empList = empService.getEmployeeList(cri);
		model.addAttribute("empList", empList);
		
		int total = empService.getTotalEmployees(cri);
		PageDto dto = new PageDto(cri, total);
		
		log.info("Pagedto : " + dto.toString());
		model.addAttribute("pageMaker", dto);
		
		return "emp/empList";
	}
	
}