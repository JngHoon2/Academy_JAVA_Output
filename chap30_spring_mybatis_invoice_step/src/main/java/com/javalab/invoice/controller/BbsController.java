package com.javalab.invoice.controller;

import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalab.invoice.dto.QnaBbs;
import com.javalab.invoice.service.product.IQnaBbsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BbsController
{
	//@Autowired
	// [생성자주입] @RequiredArgsConstructor + final
	private final IQnaBbsService qnaBbsService;
	
	// 처음 화면이 뜰때 게시물 목록 조회
	@RequestMapping(value = "/qna_list", method = RequestMethod.GET)
	public String getQnaList(@ModelAttribute QnaBbs qnaBbs, Model model) throws Exception
	{
		List<QnaBbs> qnaBbsList = qnaBbsService.getQnaBbsList(qnaBbs);
		
		model.addAttribute("qnaBbsList", qnaBbsList);
		
		return "/bbs/board_list";
	}
	
	// 게시물 작성 폼을 띄워주는 메소드(Get방식)
	@GetMapping("/insertBoard")
	public String boardInsertForm(Model model){
		log.info("boardInsertForm 메소드");
		return "/bbs/board_insertform";	// board_insertform.jsp
	}

	// 작성된 게시물을 저장하는 메소드(Post방식)
	@PostMapping("/insertBoard")
	public String insertBoard(QnaBbs vo, Model model) throws IOException{
		log.info("insertBoard post 메소드");

		// 게시물 등록(저장)
		qnaBbsService.insertBoard(vo);
		
		// 저장후 목록 출력 컨트롤러 호출
		return "redirect:/board/qna_list"; 
	}
	
	// 게시물 한개의 내용을 보여주는 메소드(핸들러)
	@GetMapping("/viewBoard")
	public String getBoardById(@RequestParam("no") int no, Model model){
		log.info("getBoardById 메소드 no : " + no);
		QnaBbs board = qnaBbsService.getBoardById(no);
		model.addAttribute("board", board);
		return "/bbs/board_view";	// board_view.jsp
	}	
	
	/*
	 * [Ajax 요청 처리]
	 *  - @RequestBody QnaBbs : 화면의 조회 조건을 QnaBbs 객체로 받음
	 *  - @ResponseBody : 처리 결과를 화면의 바디에 바로 출력
	 */
	@ResponseBody
	@RequestMapping(value = "/qna_list_search", method = RequestMethod.POST)
	public List<QnaBbs> getQnaSearch(@RequestBody QnaBbs qnaBbs, Model model) throws Exception
	{
		log.info("title : " + qnaBbs.getTitle());
		List<QnaBbs> qnaBbsList = qnaBbsService.getQnaBbsList(qnaBbs);
		return qnaBbsList;
	}
}
