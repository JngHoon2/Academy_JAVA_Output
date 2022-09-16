package com.javalab.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalab.vo.MemberVo;

/**
 * [컨트롤러에서 다양한 방법으로 인자를 전달받고 이동해갈 페이지에 값을 보내는 방법]
 * [컨트롤러]
 *  - @Controller 어노테이션을 붙여서 자신이 빈으로 만들어진 컴포넌트임을 알린다.
 *   (servlet-context.xml conponent-scan에서
 */
@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String home() {
		log.info("HomeController home() 메소드!");
		return "home";
	}
	
	// 로그인 폼 메소드(핸들러)
	@GetMapping("/login.do")
	public String loginForm(Model model) {
		log.info("loginForm 메소드");
		return "/loginForm";	// WEB-INF/views/loginForm.jsp
	}
	
	@PostMapping("/login.do")
	public String action(Model model,
			HttpServletRequest request,
			@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			MemberVo member3,
			@ModelAttribute("mem") MemberVo memver,
			@RequestParam Map<String, String> map,
			@RequestBody String requestBodyStr) throws UnsupportedEncodingException {
		log.info("전달받은 값 출력");
		
		// 1. @RequestParam("id") String id
		// 하나씩 전달받은 파라미터로 MeberVo 객체 생성
		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		memberVo.setPwd(pwd);
		memberVo.setName(name);
		memberVo.setAge(age);
		
		log.info("1. RequestParam으로 전달 받은 문자열 : " + memberVo.toString());
		
		
		// 2. MemberVo 커멘드 객체로 전달 받은 값
		log.info("2. MemberVo 커멘드 객체(자바빈 처럼)로 전달 받은 값 :" + memberVo.toString());
		
		// 3. @RequestParam Map<String, String> map 
		// 선언해 놓으면 name = "값" 형태로 map으로 넣어줌
		for(String key : map.keySet()) {
			log.info("3. Map  형태로 전달받은 파라미터 :" + key + map.get(key) + memberVo.toString());
		}
		
		// 4. @RequestBody
		log.info("4. @RequsetBody requestBodyStr : " + requestBodyStr);
		
		// 5. 다음 jsp페이지에서 사용할 값 저장(ArrayList 형태로 저장)
		ArrayList<MemberVo> memberList = new ArrayList<>();
		memberList.add(memberVo);
		MemberVo memberVo2 = new MemberVo();
		memberVo2.setId("java");
		memberVo2.setPwd("1234");
		memberVo2.setName("박자바");
		memberVo2.setAge(20);
		memberList.add(memberVo2);
		
		// 6. ArrayList를 Map에 저장
		Map<String, ArrayList<MemberVo>> memberMap = new HashMap<>();
		memberMap.put("memberList" ,memberList);
		
		// 7. 전달박은 값을 Model 타입 객체 model에 저장해서 이동해갈 화면에서 꺼내씀
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		// 커멘드 객체이므로 안담아도 jsp 페이지로 자동 전달
		model.addAttribute("map", map);
		model.addAttribute("memberList", memberList);
		model.addAttribute("requestBodyStr", requestBodyStr);
		model.addAttribute("memberMap", memberMap);
		
		// 처리 결과를 보여줄 jsp 체이지 이름을 String 형태로 변환
		// 문자열(value)과 같은 jsp 페이지에게 화면을 요청한다.
		return "action";	// 처리결과를 보여줄 action.jsp 페이지
	}
	
	@PostMapping("/action2.do")
	public void action2(@ModelAttribute("mem") MemberVo member, Model model) {
		log.info(member.toString());
		model.addAttribute("member", member);
	}
	
}
