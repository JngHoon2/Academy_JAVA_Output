package com.javalab.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalab.service.BoardService;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;
import com.javalab.vo.PageDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board") // 컨트롤러 차원의 RequestMapping
@Slf4j
@AllArgsConstructor // 안보이는 생성자가 자동으로 만들어짐
public class BoardController {
	// 생성자를 통한 주입을 할 경우 기본 생성자가 있으면 안 된다.

	// boardService 의존성 주입
	// @Resource(name = "boardService")
	private BoardService boardService;

	/*
	 * [생성자를 통한 의존성 주입 - 어노테이션 없이도 의존성 주입해줌] public BoardController(BoardService
	 * boardService){ super(); this.boardService = boardService;
	 */

	// 페이징 기능이 있는 게시물 리스트 조회 핸들러
	@GetMapping("/boardList.do")
	public String getListPagingAndSearching(Criteria cri, Model model) {
		log.info("getListPagingAndSearching(from BoardController) 메소드 실행!");

		List<BoardVo> boardList = boardService.getListPagingAndSearch(cri);
		model.addAttribute("boardList", boardList);
		
		int total = boardService.getTotalBoardCount(cri);
		model.addAttribute("pageMaker", new PageDto(cri, total));
		
		return "/board/boardList";
	}

//	@GetMapping("/boardList.do")
//	public String getBoardList(BoardVo vo, Model model){
//		log.info("selectBoardList 메소드");
//		//BoardVO vo = new BoardVO();
//		List<BoardVo> boardList = boardService.getBoardList(vo);
//		model.addAttribute("boardList", boardList);
//		return "/board/boardList";	// Jsp 페이지명 반환, boardList.jsp
//	}

	// 게시물 한개의 내용을 보여주는 메소드(핸들러)
	@GetMapping("/boardView.do")
	public String getBoardById(@RequestParam("no") int no, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("getBoardById 메소드 cri : " + cri.toString());
		BoardVo vo = new BoardVo();
		vo.setNo(no);
		BoardVo boardVo = boardService.getBoardById(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardView"; // boardView.jsp
	}

	// 게시물 작성 폼을 띄워주는 메소드(핸들러)
	@GetMapping("/boardWrite.do")
	public String boardWriteForm(Model model) {
		log.info("boardWriteForm get 메소드");
		return "/board/boardWriteForm"; // boardWriteForm.jsp
	}

	// 작성된 게시물을 데이터베이스에 저장하는 메소드(핸들러)
	@PostMapping("/boardWrite.do")
	public String insertBoard(BoardVo vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) throws IOException { // 수정
		log.info("boardWriteForm post 메소드");

		// 파일 업데이트
//		MultipartFile uploadFile = vo.getUploadFile();
//		if (!uploadFile.isEmpty()) {
//			String fileName = uploadFile.getOriginalFilename();
//			uploadFile.transferTo(new File("C:/filetest/upload/" + fileName));
//		}
		// 게시물 등록(저장)
		boardService.insertBoard(vo);
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("searchText", cri.getSearchText());
		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출	
	}
	
//	@RequestMapping(value = "/boardWrite.do", method = RequestMethod.GET)
//	public String insertboard(BoardVo vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
//		boardService.deleteBoard(vo);
//	
//		log.info("boardModifyForm post 메소드 vo : " + vo.toString());
//
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("searchText", cri.getSearchText());
//		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출	
//	}

	// 수정폼을 보여주는 메소드(핸들러)
	@GetMapping("/boardModify.do")
	public String updateBoardForm(BoardVo vo, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("updateBoardForm get 메소드 cri : " + cri.toString());

		BoardVo boardVo = boardService.getBoardById(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardModifyForm"; // boardModify.jsp
	}

	// 수정한 내용을 데이터베이스에 반영하는 메소드(핸들러)
	@PostMapping("/boardModify.do")
	public String boardModify(BoardVo vo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("boardModifyForm post 메소드 vo : " + vo.toString());

		boardService.updateBoard(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("searchText", cri.getSearchText());

		// redirect를 사용하면 사용자 브라우저로 이동
		// 단, request에 값을 담아 보내려 할때 redirect를 하면
		// 서버에 재요청하기 때문에 값이 증발 
		return "redirect:/board/boardList.do";
	}

//	// 게시물을 삭제해주는 메소드(핸들러)
//	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
//	public String boardDelete(BoardVo vo) {
//		boardService.deleteBoard(vo);
//		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출
//	}
	
	@RequestMapping(value = "/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete(BoardVo vo,  @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		boardService.deleteBoard(vo);
	
		log.info("boardDelete 메소드 : " + cri.toString());

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("searchText", cri.getSearchText());
		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출	
	}

	// 게시물 한개의 내용을 보여주는 메소드(핸들러)
	@GetMapping("/boardCount.do")
	public int getTotalBoardCount(Criteria cri, Model model) {
		log.info("getTotalBoardCount 메소드");
		int count = boardService.getTotalBoardCount(cri);
		return count;
	}
}