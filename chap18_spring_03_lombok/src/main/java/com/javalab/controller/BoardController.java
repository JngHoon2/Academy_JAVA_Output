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
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.javalab.service.BoardService;
import com.javalab.vo.BoardVO;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
//@Log
public class BoardController {

	// org.slf4j.Logger 자바에서 기본으로 제공해주는 로그 클래스
	//private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired	// 타입으로 찾아서 자동 주입
	private BoardService boardService;

	
	// 기본 생성자
	public BoardController() {
		super();
	}
	
	/*
	 * [@RequestMapping] :
	 *  - 사용자 요청과 처리를 담당할 메소드(핸들러) 정보를 취합할 수 있도록 도와주는 표식(flag) 어노테이션 
	 *  - 어플리케이션이 구동되면서 RequestMappingHandlerMapping에게 어떤 메소드에 어떤
	 *    매핑정보(url)있는 지 찾아서 알려주는 역할. 
	 */

	/*
	 * [파라미터 (Model model)] :
	 *  - Model은 HashMap 형태를 갖고 있으며, key, value값을 가지고 있습니다.
	 *    (https://velog.io/@msriver/Spring-Model-%EA%B0%9D%EC%B2%B4)
	 *  - Model 객체는 JSP에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할
	 *  - 뷰(View)화면에 값을 전달하는 전달자 역할로서, 컨트롤러 메소드에 파라미터로 선언하고
	 *    model.setAttribute("화면에서 찾아쓸이름", userList)하면 화면으로 전달된다.
	 *  - request.setAttribute("",값)같은 기능을 한다.
	 */
	
	/*
	 *  [게시물 목록 조회 메소드(핸들러)]
	 *  컨트롤러의 메소드는 요청 처리후 처리 결과를 저장하고 문자열로 jsp 페이지명 또는 다른 서블릿 호출 문자열을 반환
	 *  스프링에서 기본으로 제공해주는 model에 값을 저장하여 JSP에 전달,
	 *  request 기본 객체를 사용할 수도 있지만 스프링에서는 model 사용
	 */
	// 게시물 목록 조회 메소드(핸들러)
	
	@RequestMapping(value="/board/boardList.do", method = RequestMethod.GET)
	public String selectBoardList(Model model){
		log.info("selectBoardList 메소드");
		BoardVO vo = new BoardVO();
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "/board/boardList";	// boardList.jsp
	}
	
	
	// 게시물 한개의 내용을 보여주는 메소드(핸들러)
	// @RequestParam : @RequestParam("받아올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]
	@RequestMapping(value="/board/boardView.do", method = RequestMethod.GET)
	public String getBoardById(@RequestParam("no") int no, Model model){
		log.info("getBoardById 메소드");
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		BoardVO boardVo = boardService.getBoard(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardView";	// boardView.jsp
	}
	
	// 게시물 작성 폼을 띄워주는 메소드(핸들러)
	@RequestMapping(value="/board/boardWrite.do", method = RequestMethod.GET)
	public String boardWriteForm(Model model){
		log.info("boardWriteForm get 메소드");

		return "/board/boardWriteForm";	// boardWrite.jsp
	}

	// 작성된 게시물을 데이터베이스에 저장하는 메소드(핸들러)
	@RequestMapping(value="/board/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(BoardVO vo, Model model) throws IOException{
		log.info("boardWriteForm post 메소드");
		
		/* 간단한 File Upload 추가 */
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/filetest/upload/" + fileName));
		}
		boardService.insertBoard(vo);
		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출
	}

	// 수정폼을 보여주는 메소드(핸들러)
	@RequestMapping(value="/board/boardModify.do", method = RequestMethod.GET)
	public String boardModifyForm(BoardVO vo, Model model){
		log.info("boardModifyForm get 메소드");

		BoardVO boardVo = boardService.getBoard(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardModifyForm";	// boardModify.jsp
	}
	
	// 수정한 내용을 데이터베이스에 반영하는 메소드(핸들러)
	@RequestMapping(value="/board/boardModify.do", method = RequestMethod.POST)
	public String boardModify(BoardVO vo, Model model){
		log.info("boardModifyForm post 메소드");
		boardService.updateBoard(vo);
		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출
	}

	// 게시물을 삭제해주는 메소드(핸들러)
	@RequestMapping(value="/board/boardDelete.do", method = RequestMethod.GET)
	public String boardDelete(BoardVO vo){
		boardService.deleteBoard(vo);
		return "redirect:/board/boardList.do"; // 저장후 목록 출력 컨트롤러 호출
	}
}
