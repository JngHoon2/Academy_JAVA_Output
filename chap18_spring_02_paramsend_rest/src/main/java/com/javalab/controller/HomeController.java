package com.javalab.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalab.vo.MemberVo;

/**
 * [컨트롤러에서 다양한 방법으로 인자를 전달받고 이동해갈 페이지에 값을 보내는 방법]
 * [컨트롤러]
 *  - @Controller 어노테이션을 붙여서 자신이 빈으로 만들어진 컴포넌트임을 알린다.
 *   (servlet-context.xml conponent-scan에서
 */
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		log.info("home !");
		return "home";
	}
	
	@RequestMapping(value = "/formRest", method = RequestMethod.POST)
	public String formRest(@ModelAttribute("name") String name) {
		log.info("formRest name : " + name);
		return "formRest";
	}

	@RequestMapping(value = "/formRest2", method = {RequestMethod.POST, RequestMethod.GET})
	public void formRest2(@ModelAttribute("name") String name) {
		log.info("formRest2");
		log.info("name : " + name);
	}
	
	// @ResponseBody : 리턴 결과로 자바 객체를 JSON타입의 데이터(문자열)로 만들어내는 용도로 사용함.
	@RequestMapping(value = "/action3.do/name/{name}/grade/{grade}", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody String action3(@PathVariable("name") String name,
									   @PathVariable("grade") int grade,
									   Model model) {
		log.info("PathVariable action");
		log.info("name : " + name);
		log.info("grade : " + grade);
		
		model.addAttribute("msg", "성공");
		String msg = "name" + name + ", " + "grade" + grade;
		
		return msg;
	}
	
	@RequestMapping(value = "/action4.do/name/{name}/grade/{grade}", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody MemberVo action4(@PathVariable("name") String name,
									   @PathVariable("grade") int grade,
									   Model model) {
		log.info("PathVariable action");
		log.info("name : " + name);
		log.info("grade : " + grade);
		
		model.addAttribute("msg", "성공");
		String msg = "name" + name + ", " + "grade" + grade;
		
		MemberVo member = new MemberVo();
		member.setName(name);
		member.setGrade(grade);
		
		return member;
	}
}
