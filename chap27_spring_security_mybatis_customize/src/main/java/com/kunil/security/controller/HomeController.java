package com.kunil.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		
		log.info("home");
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String index() {
		log.info("여기는 HomeController > index");
		
		return "index";
	}

}