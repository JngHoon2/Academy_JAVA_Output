package com.javalab.rest.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalab.rest.domain.Ticket;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleRestController {
	
	@GetMapping(value="/getText/{id}", produces = "text/plain; charset=UTF-8")
	public String getText(@PathVariable("id") long id) {
		log.info("MiME Type : " + MediaType.TEXT_PLAIN_VALUE);
		log.info("id : " + id);
		return "안녕하세요";
	}
	
	@PostMapping(value="/ticket", consumes = "application/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("사용자로부터 전달된 JSON 문자열을 자바의 Ticket 객체로 변환 : " + ticket);
		return ticket;
	}
}
