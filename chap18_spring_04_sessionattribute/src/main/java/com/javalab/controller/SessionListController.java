package com.javalab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("list")
@Slf4j
public class SessionListController {
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list");
		
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("spring");
		list.add("javascript");
		
		model.addAttribute("list", list);
		
		return "sessionStatus2";
	}
}
