package com.javalab.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javalab.service.LoginService;
import com.javalab.service.UserService;
import com.javalab.vo.UserVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
@AllArgsConstructor
public class UserController {

	@Resource(name = "userService")
	private UserService service;
	
	// 기본 생성자
	public UserController() {
		super();
	}
	
	@ResponseBody
	@GetMapping("idCheck.do")
	public int idCheck(UserVO vo, Model model) {
		log.info("idCheck 메소드 실행");
		int isIdExist = 0;
		isIdExist = service.idCheck(vo.getId());
		return isIdExist;
	}
	
	
	@GetMapping("/userInsert.do")
	public String insertForm(Model model) {
		log.info("insertForm 메소드 실행");
		return "/user/joinForm";
	}

	@PostMapping("/userInsert.do")
	public String insertUser(UserVO vo, Model model) {
		log.info("insertUser 메소드 실행");
		service.insertUser(vo);
		
		// 회원가입 후 바로 로그인하여 리스트로 가는 경우(수정 필요)
		//model.addAttribute("user", vo);
		//return "/login/login.do";
		
		// 회원가입 후 로그인 창으로 가는 경우
		return "redirect:/login/login.do"; 
	}
	
	
}