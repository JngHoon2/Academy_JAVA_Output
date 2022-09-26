package com.javalab.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javalab.service.BoardService;
import com.javalab.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/board")
@Slf4j
//@Log
public class BoardController {
	
	@Autowired	// 타입으로 찾아서 자동 주입
	private BoardService boardService;

	
	// 기본 생성자
	public BoardController() {
		super();
	}

	@GetMapping("/boardList.do")
	public String getBoardList(BoardVo vo, Model model) {
		log.info("getBoardList 메소드 호출 ");
		List<BoardVo> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "/board/boardList";
	}
	
	@GetMapping("/boardView.do")
	public String getBoardById(@ModelAttribute("no") int no, Model model) {
		log.info("getBoardById 메소드 호출 ");
		BoardVo vo = new BoardVo();
		vo.setNo(no);
		BoardVo boardVo = boardService.getBoardById(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardView";
	}
	
	@GetMapping("/boardWrite.do")
	public String boardWriteForm(Model model) {
		log.info("boardWriteForm 메소드 호출 ");
		return "/board/boardWriteForm";
	}
	
	@PostMapping("/boardWrite.do")
	public String insertBoard(BoardVo vo, Model model) {
		log.info("insertBoard 메소드 호출 ");
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			try {
				uploadFile.transferTo(new File("/Users/tuan/Documents/works/chap20_mybatis01_hikaripool/src/main/resources/" + fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boardService.insertBoard(vo);
		return "redirect:/board/boardList.do";
	}
	
	@GetMapping("/boardModify.do")
	public String updateBoardForm(BoardVo vo, Model model) {
		log.info("updateBoardForm 메소드 호출 ");
		
		BoardVo boardVo = boardService.getBoardById(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardModifyForm";
	}
	
	@PostMapping("/boardModify.do")
	public String boardModify(BoardVo vo, Model model) {
		log.info("boardModify 메소드 호출 ");
		boardService.updateBoard(vo);
		return "redirect:/board/boardList.do";
	}
	
	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete(BoardVo vo) {
		log.info("boardDelete 메소드 호출 ");
		boardService.deleteBoard(vo);
		return "redirect:/board/boardList.do";
	}
	
	@GetMapping("/boardCount.do")
	public int getTotalBoardCount(Model model) {
		log.info("getTotalBoardCount 메소드 호출 ");
		int count = boardService.getTotalBoardCount();
		return count;
	}
	
	
}
