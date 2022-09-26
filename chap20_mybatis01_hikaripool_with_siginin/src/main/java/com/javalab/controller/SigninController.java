package com.javalab.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalab.service.SigninService;
import com.javalab.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/signin")
@Slf4j
public class SigninController {

   @Autowired //만 해도 됨.
   private SigninService service;   // loginService라는 이름의 빈을 찾아서 주입해줌
   
   // 기본 생성자
   public SigninController() {
      super();
   }
   
   @GetMapping("/signin.do")
   public String SigninForm(Model model) {
	   log.info("SigninForm 메소드 ");
	   return "/signin/signinForm";
   }
   
   @PostMapping("/signin.do")
   public String addUser(UserVo vo, Model model) {
	   log.info("addUser 메소드 실행");
	   service.addUser(vo);
	   return "redirect:/login/login.do";
   }

}