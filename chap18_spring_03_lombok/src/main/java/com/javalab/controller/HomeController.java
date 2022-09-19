package com.javalab.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;


/**
 * [웹 어플리케이션이 처음 시작할 때 띄워줄 화면 처리 컨트롤러]
 *  - 어플리케이션이 시작하면 "/" 기본 페이지를 요청하기 때문에 이에 대한 처리 역할
 *  - 다른 컨트롤러에서 처리해도 상관 없음.
 */
@Controller
@Slf4j
public class HomeController {
	// org.slf4j.Logger 스프링에서 기본으로 제공해주는 로그 클래스(디펜던시를 기본으로 넣어준다는 의미)
	//private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * 어플리케이션이 처음 시작하면서 기본적으로 "/" 요청이 온다.
	 * 그 때 이 메소드(핸들러)가 처리하게됨.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info(locale + "");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("time", formattedDate );		
		
		return "index";	// 띄워줄 jsp 페이지  이름 반환
	}
}
