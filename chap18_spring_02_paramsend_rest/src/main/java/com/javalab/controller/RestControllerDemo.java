package com.javalab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javalab.vo.MemberVo;

/**
 * [컨트롤러에서 다양한 방법으로 인자를 전달받고 이동해갈 페이지에 값을 보내는 방법] [컨트롤러] - @Controller 어노테이션을
 * 붙여서 자신이 빈으로 만들어진 컴포넌트임을 알린다. (servlet-context.xml conponent-scan에서
 */
//@Controller
@RestController
public class RestControllerDemo {

	private static final Logger log = LoggerFactory.getLogger(RestControllerDemo.class);

	/*
	 * @RestController의 모든 메소드는 @ResponseBody가 자동으로 붙음 - @ResponseBody : 요청한 페이지의
	 * 바디에 출력
	 */
	// @ResponseBody // 생략해도 자동으로 붙기 때문에 주석처리
	@RequestMapping(value = "/restAction1.do/name/{name}/grade/{grade}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public MemberVo action4(@PathVariable("name") String name, @PathVariable("grade") int grade, Model model) {

		log.info("@RestController PathVariable");
		log.info("name : " + name);
		log.info("grade : " + grade);

		// 화면에서 전달받은 값으로 새로운 객체를 생성해서 그대로 화면으로 다시 전송
		MemberVo member = new MemberVo();
		member.setName(name);
		member.setGrade(grade);

		return member;
	}

	/*
	 * @RestController의 모든 메소드는 @ResponseBody가 자동으로 붙음 - @ResponseBody : 요청한 페이지의
	 * 바디에 출력 - @RequestBody MemberVo : JSP에서 보낸 값들을 Vo에 자동 바인딩
	 */
	@RequestMapping(value = "/restAction2.do", method = { RequestMethod.GET, RequestMethod.POST })
	public MemberVo action5(@RequestBody MemberVo memberVo, Model model) {

		log.info("restAction2.do @RequestBody action");
		log.info("name : " + memberVo.getName());
		log.info("grade : " + memberVo.getGrade());

		MemberVo member = new MemberVo();
		member.setName(memberVo.getName());
		member.setGrade(memberVo.getGrade());

		return member;
	}
}