package com.javalab.spring.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.javalab.spring.board.service.BoardService;
import com.javalab.spring.board.vo.BoardVO;


@Controller
public class BoardController {

	@Autowired
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

	// 게시물 목록 조회 메소드(핸들러)
	@RequestMapping(value="/boardList.do", method = RequestMethod.GET)
	public String selectBoardList(Model model){
		System.out.println("selectBoardList.do");
		BoardVO vo = new BoardVO();
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList", boardList);
		return "/board/boardList";	// boardList.jsp
	}
	
	// 게시물 한개의 내용을 보여주는 메소드(핸들러)
	// @RequestParam : @RequestParam("받아올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]
	@RequestMapping(value="/boardView.do", method = RequestMethod.GET)
	public String getBoardById(@RequestParam("no") int no, Model model){
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		BoardVO boardVo = boardService.getBoard(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardView";	// boardView.jsp
	}
	
	// 게시물 작성 폼을 띄워주는 메소드(핸들러)
	@RequestMapping(value="/boardWrite.do", method = RequestMethod.GET)
	public String boardWriteForm(Model model){
		return "board/boardWriteForm";	// boardWrite.jsp
	}

	// 작성된 게시물을 데이터베이스에 저장하는 메소드(핸들러)
	@RequestMapping(value="/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(BoardVO vo, Model model){
		boardService.insertBoard(vo);
		return "redirect:boardList.do"; 
	}

	// 수정폼을 보여주는 메소드(핸들러)
	@RequestMapping(value="/boardModify.do", method = RequestMethod.GET)
	public String boardModifyForm(BoardVO vo, Model model){
		// 게시물 목록을 조회
		//BoardVO vo = new BoardVO();
		//vo.setNo(no);
		BoardVO boardVo = boardService.getBoard(vo);
		model.addAttribute("board", boardVo);
		return "/board/boardModifyForm.do";	// boardModify.jsp
	}
	
	// 수정한 내용을 데이터베이스에 반영하는 메소드(핸들러)
	@RequestMapping(value="/boardModify.do", method = RequestMethod.POST)
	public String boardModify(BoardVO vo, Model model){
		boardService.modifyBoard(vo);
		return "redirect:boardList.do"; 
	}

	// 게시물을 삭제해주는 메소드(핸들러)
	@RequestMapping(value="/boardDelete.do", method = RequestMethod.GET)
	public String boardModify(BoardVO vo){
		boardService.deleteBoard(vo);
		return "redirect:boardList.do"; 
	}
}