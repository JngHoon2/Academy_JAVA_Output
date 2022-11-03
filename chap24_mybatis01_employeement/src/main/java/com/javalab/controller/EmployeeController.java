package com.javalab.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.omg.CosNaming._BindingIteratorImplBase;
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
import com.javalab.vo.BoardVO;
import com.javalab.vo.Criteria;
import com.javalab.vo.Employee;
import com.javalab.vo.PageDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/emp")	// 컨트롤러 차원의 RequestMapping
@Slf4j
@AllArgsConstructor
public class EmployeeController {

	/*
	 * [생성자를 통한 의존성 주입 방법 #1]
	 * 1. @AllArgsConstructor + private BoardService boardService;
	 */
	private EmployeeService empService;

	// 사원 목록 조회
	@GetMapping("/list.do")
	public String getemployeeList(Criteria cri, Model model){
		log.info("getemployeeList 메소드 Employee : " + cri.toString());
		
		List<EmployeeCommonDto> empList = empService.getEmployeeList(cri);
		//List<EmployeeCommonDto> empList = empService.getEmployeeList(eDto);
		model.addAttribute("empList", empList);
		
		int total = empService.getTotalEmployees(cri);
		PageDto dto = new PageDto(cri, total);
		
		log.info("dto : " + dto.toString());
		model.addAttribute("pageMaker", dto); 	
		
		return "/emp/empList";	// 사원 목록 jsp 페이지
	}

	// 사원 정보를  보여주는 메소드(핸들러)
	@GetMapping("/empView.do")
	public String getEmpById(@RequestParam("employeeId") int employeeId, 
								@ModelAttribute("cri") Criteria cri, 
								Model model){
		log.info("getEmpById 메소드 cri : " + cri.toString());
		Employee emp = empService.getEmpById(employeeId);
		model.addAttribute("emp", emp);
		return "/emp/empView";	// empView.jsp
	}
	
	
	// 사원정보 수정폼을 보여주는 메소드(핸들러)
	@GetMapping("/empModify.do")
	public String updateBoardForm(@RequestParam("employeeId") int employeeId, 
									@ModelAttribute("cri") Criteria cri,
									Model model){
		
		log.info("updateEmployee 메소드 cri : " + cri.toString());

		Employee emp = empService.getEmpById(employeeId);
		model.addAttribute("emp", emp);
		return "/emp/empModifyForm";	// empModifyForm.jsp
	}
	
	// 수정한 내용을 데이터베이스에 반영하는 메소드(핸들러)
	@PostMapping("/empModify.do")
	public String boardModify(Employee vo, 
								@ModelAttribute("cri") Criteria cri,
								RedirectAttributes rttr){
		
		log.info("empModifyForm post 메소드 vo : " + vo.toString());
		empService.updateEmp(vo); // 수정
		
		// redirect 하기 때문에 다음과 같이 넣어줘야 함.
		// rttr.addAttribute는 GET 방식이며 페이지를 새로고침 한다 해도 값이 유지된다.
		// rttr.addFlashAttribute는 POST 방식이며 이름처럼 일회성 데이터라 새로고침 하면 값이 사라진다.
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("searchText", cri.getSearchText());
		
		return "redirect:/emp/list.do"; // 저장후 목록 출력 컨트롤러 호출
	}	
	
	
}
