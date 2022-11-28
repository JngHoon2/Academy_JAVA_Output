package com.javalab.springjpa.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.javalab.springjpa.service.GuestbookService;
import com.javalab.springjpa.vo.Guestbook;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	@GetMapping("/")
	public String index(Locale locale, Model model) {
		List<Guestbook> guestbookList = guestbookService.getMessageList();
		model.addAttribute("guestbookList", guestbookList);
		return "index";
	}
	
	@PostMapping("/insert")
	public String save(Guestbook guestbook) {
		guestbook.setRegDate(new Date());
		guestbookService.save(guestbook);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deletefrom() {
		return "deleteForm";
	}
	
	@PostMapping("/delete")
	public String delete(Guestbook guestbook) {
		guestbookService.deleteMessage(guestbook);
		return "redirect:/";
	}
}
