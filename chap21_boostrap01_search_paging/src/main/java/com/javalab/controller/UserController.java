package com.javalab.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalab.service.BoardService;
import com.javalab.service.LoginService;
import com.javalab.service.UserService;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;
import com.javalab.vo.RoleVo;
import com.javalab.vo.UserVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
@AllArgsConstructor	// [롬복]전체 멤버 변수가 들어가는 생성자를 만들어줌 
public class UserController {
	
	private UserService userService;
	private BoardService boardService;

	
	// 회원가입 폼을 띄워주는 메소드(핸들러)
	@GetMapping("/join.do")
	public String joinForm(Criteria cri, Model model) {
		log.info("joinForm GET() 메소드");
		List<RoleVo> roleList = userService.getRoles();
		model.addAttribute("roleList", roleList);
		
		int boardCount = boardService.getTotalBoardCount(cri);
		log.info("총 게시물 건수 : " + boardCount);
		
		return "/user/joinForm";
	}
	
	// 회원 아이디 존재 여부 체크
	@ResponseBody	// jsp body에 띄운기 위해 필요
	@GetMapping("/idCheck.do")
	public int idCheck(UserVO vo, Model model) {
		log.info("idCheck 메소드");
		int isIdExist = 0;	// 기본은 중복
		isIdExist = userService.idCheck(vo.getId());
		return isIdExist; 
	}
	
	// 회원 등록 메소드(핸들러)
	@PostMapping("/join.do")
	public String insertUser(UserVO vo, Model model) throws IOException {
		log.info("insertUser post 메소드 vo.toString() : " + vo.toString());
		userService.insertUser(vo);
		return "redirect:/board/boardList.do";
	}
}
