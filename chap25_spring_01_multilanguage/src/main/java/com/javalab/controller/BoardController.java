package com.javalab.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javalab.service.BoardService;
import com.javalab.vo.BoardVO;

@Controller
@RequestMapping("/board")	// 컨트롤러 차원의 RequestMapping
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// Service 인터페이스 의존성 주입 
	@Autowired
	private BoardService boardService;

	public BoardController() {
		super();
	}
	
	// [게시물 목록 조회 메소드(핸들러)]   
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String selectBoardList(Model model){
		log.info("selectBoardList 메소드");
		BoardVO vo = new BoardVO();
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "/board/boardList";	// Jsp 페이지명 반환, boardList.jsp
	}

	// 게시물 한개의 내용을 보여주는 메소드(핸들러)
	@RequestMapping(value="/boardView.do", method = RequestMethod.GET)
	public String getBoardById(@RequestParam("no") int no, Model model){
		log.info("getBoardById 메소드");
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		BoardVO boardVo = boardService.getBoard(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardView";	// boardView.jsp
	}
	
	// 게시물 작성 폼을 띄워주는 메소드(핸들러)
	@RequestMapping(value="/boardWrite.do", method = RequestMethod.GET)
	public String boardWriteForm(Model model){
		log.info("boardWriteForm get 메소드");
		return "/board/boardWriteForm";	// boardWriteForm.jsp
	}

	// 작성된 게시물을 데이터베이스에 저장하는 메소드(핸들러)
	@RequestMapping(value="/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(BoardVO vo, Model model) throws IOException{  // 수정
		log.info("boardWriteForm post 메소드");
		
		boardService.insertBoard(vo);	// 저장
		
		// 저장후 목록 출력 컨트롤러 호출, redirect하면 사용자 화면의 주소창이 변경됨.
		return "redirect:/board/boardList.do"; 
	}

	// 수정폼을 보여주는 메소드(핸들러)
	@RequestMapping(value="/boardModify.do", method = RequestMethod.GET)
	public String boardModifyForm(BoardVO vo, Model model){
		log.info("boardModifyForm get 메소드");

		BoardVO boardVo = boardService.getBoard(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardModifyForm";	// boardModify.jsp
	}
	
	// 수정한 내용을 데이터베이스에 반영하는 메소드(핸들러)
	@RequestMapping(value="/boardModify.do", method = RequestMethod.POST)
	public String boardModify(BoardVO vo, Model model){
		log.info("boardModifyForm post 메소드");
		boardService.updateBoard(vo);
		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출
	}

	// 게시물을 삭제해주는 메소드(핸들러)
	@RequestMapping(value="/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete(BoardVO vo){
		boardService.deleteBoard(vo);
		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출
	}
}
