package com.javalab.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javalab.dao.BoardDAO;
import com.javalab.service.BoardService;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;
import com.javalab.vo.PageDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class getListPaging {

	public BoardService boardservice;
	
	// 페이징 기능 있는 게시물 리스트 조회 핸들러
	@GetMapping("/boardList.do")
	public String getListPagingAndSearching(Criteria cri, Model model) {
		log.info("selectBoardList 메소드 Criteria : " + cri);

		List<BoardVo> boardList = boardservice.getListPagingAndSearch(cri);
		model.addAttribute("boardList", boardList);

		int total = boardservice.getTotalBoardCount(cri);
		model.addAttribute("pageMaker", new PageDto(cri, total));

		return "/board/boardList";
	}
}
