package com.magicoh.springmvc.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.magicoh.springmvc.dto.AddressVo;
import com.magicoh.springmvc.dto.CustomUser;
import com.magicoh.springmvc.dto.UserRole;
import com.magicoh.springmvc.service.user.IAuthService;

import lombok.extern.slf4j.Slf4j;
 
@Controller
//@RequestMapping("/user")
@Slf4j
public class AuthController {
	
	@Autowired
	private IAuthService authService;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome() {
		
		return "/user/welcome";
	}
	
	/**
     * login form
     */
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
    	log.info("#### AuthController >>>>> /login");
    	return "/user/login";
    }

    @RequestMapping(value="/access_denied")
    public String accessDeniedPage() throws Exception {
        return "user/access_denied";
    }

    
    //modal for zip number
    @RequestMapping(value="/zipNum", method = RequestMethod.GET)
    public String zipNum(@RequestParam(value="dong", required=false) String dong, ModelMap model) {
		List<AddressVo> addressList = authService.getAddressByDong(dong);
		model.addAttribute("addressList", addressList);
		return "/user/zipNumModal";
    }
    
    /**
     * 아이디 중복 체크 check id duplication
     * POST 방식으로 받으면 받는쪽) MemberVO vo 보내는쪽) data : {"userId" : $("#userId").val()} 으로 가능함.
     * return type을 String이 아닌 int형으로 보내는 것도 가능하다.
     */
    @ResponseBody 
    @RequestMapping(value = "/checkId", method = RequestMethod.GET) 
    public String checkId(ModelMap model, @RequestParam("id") String id) throws Exception {
    	
    	log.info("#### checkId : " + id);
    	int rowcount = authService.hasUsername(id); 
    	return String.valueOf(rowcount);
     }
    
 	//login error called from spring security
    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model, HttpSession session) {
    	
		Object secuSess = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		log.info("#### loginError : " + secuSess.toString());
		model.addAttribute("error", "true");
		model.addAttribute("msg", secuSess);
	
		return "/user/login";
    } 

    //logout called from spring security
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model,
    					 HttpServletRequest request,
    					 HttpServletResponse response) {
    	
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    log.info("auth : " + auth);

	    // logout !
	    if (auth != null) {    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "/auth/logout";
    } 
	
    /**
     * 회원가입 폼
     * @return
     */
    @RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
    	log.info("#### AuthController >>>>> /join");
		return "/user/join";
	}
	
	//join Action
	@RequestMapping(value="/joinAction", method = RequestMethod.POST)
	public String join(@ModelAttribute CustomUser user, Model model) {
		
		log.info("join Action");
		
		String user_id = user.getUser_id();
		String user_pwd = user.getUser_pwd();
		
		String path = "/user/login";

		int rowcount = authService.hasUsername(user_id); 
		if(rowcount >= 1) {
			model.addAttribute("error", "이미 존재하는 ID입니다.");
			path = "/user/join";
		} else {
			//Password encryption
			String hashedPassword = ""; 
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPassword = passwordEncoder.encode(user_pwd);

			log.info("hashedPassword : "+ hashedPassword);

			user.setUser_pwd(hashedPassword);
			
			UserRole userRole = new UserRole();
			userRole.setUser_id(user_id);
			userRole.setRole_id("ROLE_USER");	// 일반 사용자로 하드 코딩
			
			//insert 사용자, 사용자 권한(userRole)
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
	} //
    
    @RequestMapping(value="/helloworld", method = RequestMethod.GET)
    public String helloWorld(ModelMap model) {
    	
    	log.info("hellowWolrd");
    	
	    model.addAttribute("message", "Welcome to the Hello World page");
	    return "/user/helloworld";
    }
    
    /**
     * admin page
     */
    @RequestMapping(value= {"/admin/home", "/admin"}, method = RequestMethod.GET)
	public String securedAdminHome(ModelMap model) {
	
    	log.info("/admin/home");
    	
		Object principal = SecurityContextHolder.getContext()
												.getAuthentication()
												.getPrincipal();
		
		CustomUser user = null;
		
		if (principal instanceof CustomUser) {
			user = ((CustomUser)principal);
		}
		
		log.info("user : " + user);
		
		String name = user.getUsername();
		model.addAttribute("username", name);
		model.addAttribute("message", "admin/home");
		
		return "/admin/home";
    }
    
    //screen after general user authentication
    @RequestMapping(value= {"/secured/home", "/secured"}, method = RequestMethod.GET)
    public String securedHome(ModelMap model) {
    	
    	log.info("/secured/home");
    	
        Object principal = SecurityContextHolder.getContext()
        										.getAuthentication()
        										.getPrincipal();
        
        CustomUser user = null;
        
        if (principal instanceof CustomUser) {
        	user = ((CustomUser)principal);
        }
        
        log.info("user : " + user);
     
	    String name = user.getUsername();
	    model.addAttribute("username", name);
	    model.addAttribute("message", "일반 사용자 페이지에 들어오셨습니다.");
	    
	    return "/secured/home";
    }
    
    // 사용자 정보 업데이트폼
	@RequestMapping(value = "/user/member_update", method = RequestMethod.GET)
	public ModelAndView updateMemberForm(@RequestParam String user_id)
	{
		//get member info
		CustomUser customUser = authService.getMemberInfo(user_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("customUser", customUser);
		
		return new ModelAndView("/member/member_update", "map", map);
	}

	// 사용자 정보 수정 처리
	@RequestMapping(value = "/user/member_update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute CustomUser customUser, RedirectAttributes rttr) {
		
		// 비밀번호 암호화
		String hashedPassword = ""; 
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		hashedPassword = passwordEncoder.encode(customUser.getPassword());

		log.info("hashedPassword : "+ hashedPassword);

		customUser.setUser_pwd(hashedPassword);
		authService.updateUser(customUser);
		
		// 업데이트후 다시 업데이트 화면을 띄워주기 위해서 user_id를 세팅해줌
		// user_id가 있어야 수정화면을 띄워줄 수 있기 때문
		rttr.addAttribute("user_id", customUser.getUser_id());
		
		return "redirect:/user/member_update";
	}
 
    
    @RequestMapping("/access-denied")
    public String accessDenied() {
    	log.info("접근권한 오류 403");
    	return "redirect:/login";
    }
    

 
} 