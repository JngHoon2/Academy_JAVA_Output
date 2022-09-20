package com.javalab.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.javalab.vo.DemoVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("demoVO")
@Slf4j
public class SessionStatusController {
	@GetMapping("/")
	public String home() {
		log.info("home 진입");
		return "redirect:form";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		log.info("form 진입");
		
		DemoVO dv = new DemoVO();
		dv.setId("h");
		dv.setName("hong");
		dv.setGender("male");
		dv.setBloodType("O");
		dv.setAge(18);
		model.addAttribute("demoVO", dv); // @SessionAttributes("~~~")가 설정되어 있으면 model에 저장하고 세션에도 저장합니다.
		
		log.info("demoVO 라는 이름으로 model 및 세션에 저장");
		
		List<String> bloodType = new ArrayList<String>();
		bloodType.add("A");
		bloodType.add("B");
		bloodType.add("O");
		bloodType.add("AB");
		model.addAttribute("bloodType", bloodType);
		
		List<String> gender = new ArrayList<String>();
		gender.add("male");
		gender.add("female");		
		model.addAttribute("gender", gender);
		
		return "form";
	}
	
	@RequestMapping(value = "/action.do", method = RequestMethod.POST)
	public String action(@ModelAttribute("demoVO") DemoVO demoVO,
						 HttpSession session,
						 Model model) {
		log.info("action.do 진입");
		log.info(demoVO.toString());
		
		// 커멘드 객체는 model에 저장하지 않아도 자동으로 다음 화면으로 전송됨.
		//model.addAttribute("demoVO", demoVO);
		
		return "sessionStatus";
	}
	
	@RequestMapping("/sessionStatus")
	@ResponseBody
	public String sessionStatus(HttpSession session, SessionStatus sessionStatus) {
		log.info("sessionStatus 진입");
		log.info("sessionAttributes Session : {}", session.getAttribute("demoVO"));
		
		return "sessionAttribute Session : " + session.getAttribute("demoVO");
	}
	
	@RequestMapping(value = "/sessionDelete.do", method = RequestMethod.GET)
	public String sessionDelete(SessionStatus sessionStatus, HttpSession session) {
		log.info("sessionDelete.do 진입");
		log.info("session DemoVO : {}", session.getAttribute("demoVO"));
		
		if(sessionStatus.isComplete() == false) {
			sessionStatus.setComplete();
		}
		
		return "sessionStatus";
	}
	
	
}
