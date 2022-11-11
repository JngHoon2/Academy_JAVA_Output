package com.kunil.security.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kunil.security.service.IAuthService;
import com.kunil.security.vo.CustomUser;
import com.kunil.security.vo.UserRole;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {

	@Autowired
	private IAuthService authService;


	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "/user/welcome";
	}

	// login form을 띄우는 메소드
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		log.info("AuthController > login 메소드 ");
		return "/login";
	}

	// 접근 궈한 없을때 호출됨
	@RequestMapping("/access-denied")
	public String accessDenied() {
		log.info("accessDenied 메소드 : 권한이 없는 페이지에 접속 - 로그인 페이지로 호출");
		return "redirect:/login";
	}

	/**
	 * 아이디 중복 체크 check id duplication POST 방식으로 받으면 받는쪽) 
	 */
	@ResponseBody
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(ModelMap model, @RequestParam("id") String id) throws Exception {

		log.info("#### checkId : " + id);
		int rowcount = authService.hasUsername(id);
		return String.valueOf(rowcount);
	}

	// login error called from spring security
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model, HttpSession session) {

		log.info("로그인 오류입니다.(아이디/비번 틀림) ");

		Object secuSess = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		log.info("#### loginError : " + secuSess.toString());
		model.addAttribute("error", "true");
		model.addAttribute("msg", secuSess);

		return "/login";
	}

	// logout called from spring security
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("auth : " + auth);

		// logout !
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "/auth/logout";
	}

	// 회원가입 폼
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		log.info("#### AuthController >>>>> /join");
		return "/user/join";
	}

	// 회원가입처리
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String join(@ModelAttribute CustomUser user, Model model) {

		log.info("join Action");

		String user_id = user.getUsername();
		String user_pwd = user.getPassword();

		String path = "/user/login";

		int rowcount = authService.hasUsername(user_id);
		if (rowcount >= 1) {
			model.addAttribute("error", "이미 존재하는 ID입니다.");
			path = "/user/join";
		} else {
			// Password encryption
			String hashedPassword = "";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPassword = passwordEncoder.encode(user_pwd);

			log.info("hashedPassword : " + hashedPassword);

			user.setPassword(hashedPassword);

			UserRole userRole = new UserRole();
			userRole.setUserId(user_id);
			userRole.setRoleId("ROLE_USER");

			// insert user and userRole
			authService.insertUserAndRole(user, userRole);
		}
		return path;
	}

	@RequestMapping(value = "/welcome**", method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		log.info("welcome");

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Password Encoder");
		model.addObject("message", "This is default page!");
		model.setViewName("/user/hello");
		return model;
	} 

	@RequestMapping(value = "/user/member_update", method = RequestMethod.GET)
	public ModelAndView updateMemberForm(@RequestParam String user_id) {
		// get member info
		CustomUser customUser = authService.getMemberInfo(user_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customUser", customUser);

		return new ModelAndView("/member/member_update", "map", map);
	}

//	@RequestMapping("/access-denied")
//	public String accessDenied() {
//		log.info("accessDenied 메소드 : 권한이 없는 페이지에 접속 - 403");
//		return "/error/403";
//	}

//	@RequestMapping(value = "/member_update", method = RequestMethod.POST)
//	public String updateMember(@ModelAttribute CustomUser customUser)
//	{
//		authService.updateMember(customUser);
//		
//		return "redirect:product_list";
//	}

}