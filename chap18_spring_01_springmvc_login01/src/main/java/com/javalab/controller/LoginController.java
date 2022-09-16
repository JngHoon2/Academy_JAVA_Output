package com.javalab.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalab.service.LoginService;
import com.javalab.vo.UserVo;

@Controller
public class LoginController {
	// org.slf4j.Logger 자바에서 기본으로 제공해주는 로그 클래스
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private LoginService loginService;
	
	public LoginController() { super(); }
	
	@RequestMapping(value="/login/login.do", method= RequestMethod.GET)
	public String loginForm(Model model) {
		log.info("getUser GET() 메소드");
		return "/login/loginForm";
	}
	
	@RequestMapping(value="/login/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pwd") String pwd,
						HttpSession session,
						HttpServletResponse response,
						Model model) {
		String returnUrl = ""; // 로그인 성공 유무에 따라서 다양한 리턴 타입 용도
	      
	      // 화면에서 전달받은 아이디/비밀번호로 객체 생성
	      UserVo vo = new UserVo();
	      vo.setId(id);
	      vo.setPwd(pwd);
	      
	      // 서비스단에 아이디/비밀번호 전달해서 조회함.
	      UserVo userVo = loginService.getUser(vo);
	      
	      // 로그인 정보가 맞음
	      if(userVo != null) {
	         log.info("로그인 성공! userVo : " + userVo.toString());
	         
	         // 기존 세션이 존재하면 제거하고 아래서 다시 새롭게 저장한다
	         if (session.getAttribute("user") != null ){
	            session.removeAttribute("user"); 
	         }

	         // 세션에 사용자 로그인 정보 기록
	         session.setAttribute("user", userVo);
	         session.setMaxInactiveInterval(3600);   // 세션 유지 시간 지정(1시간, 초단위)
	         log.info("세션에 기록 성공");
	         
	         // 쿠키에도 기록(사용자 아이디로 쿠키 저장)
	         Cookie cookie = new Cookie("id", userVo.getId());
	         cookie.setMaxAge(10*60);   // 600초 : 10분
	         // setPath : 모든 페이지에 쿠키를 전송하겠다는 의미, 패스 없으면 쿠키를 설정한 화면에만 쿠키 전송
	         cookie.setPath("/");  
	         response.addCookie(cookie);         
	         log.info("사용자 웹브라우저에 쿠키 저장 성공 cookie값 : " + cookie.getValue());
	         
	         returnUrl = "redirect:/board/boardList.do";
		     
	      } else {
	    	  log.info("로그인 실패");
	    	  model.addAttribute("loginErrMsg", Boolean.TRUE);
	    	  model.addAttribute("user", vo);
	    	  returnUrl = "login/loginForm";
	      }
	      log.info("리턴 Url : " + returnUrl);
	      
	      return returnUrl;
	}
	
	@RequestMapping(value="/login/logout.do", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		log.info("logout 메소드");
		
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			System.out.println("세션 무효화 완료.");
		}
		
		Cookie cookie = new Cookie("id", "");
		if(cookie != null) {
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			System.out.println("쿠키 삭제 완료");
		}
		return "/login/loginForm";
	}
	
	
}
