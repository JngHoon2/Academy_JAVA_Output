<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%@ page import="com.javalab.dto.*" %>
<%
	/*
	   응답 컨텐츠 타입 설정
	   이런 형태로 보내겠다고 선언
	*/
	response.setContentType("application/json");

	/*
	  ajax01_01.html에 의해서 호출되었을 때 해야 할 일...
 	    해당 헤더로 브라우저에서 바로 응답

		Content-Disposiont : inline //브라우저에서 응답하기
		Content-Disposiont : attachment //팝업 형태(alert)로 응답하기
	*/
	response.setHeader("Content-Disposiont", "inline");
	
	String paramNum = request.getParameter("paramNum");
	System.out.println("==>" + paramNum + ": 파라미터 확인");
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	ArrayList<Member> memberList = new ArrayList<Member>();
	
	Member member = new Member();
	member.setName("이정보");
	member.setAge("20");
	member.setAddress("충남 천안");
	memberList.add(member);

	Member member2 = new Member();
	member2.setName("도라에몽");
	member2.setAge("18");
	member2.setAddress("일본 신쥬쿠");
	memberList.add(member2);
	
	// paramNum = 1 이면 그냥 1만 실어 보냄
	if("1".equals(paramNum)){
		map.put("param1", "1");
	}// paramNum = 2 이면 member 객체 1개를 실어 보냄
	else if("2".equals(paramNum)){
		map.put("param2", member);
	}else{	// 3이면 ArrayList를 실어보냄
		map.put("param3", memberList);
	}
	
	// Gson은 자바 객체를 json 형태로 바꿔준다.
	Gson gson = new Gson();
	String Json = gson.toJson(map);
	System.out.println("Json : " + Json);
	
	// 사용자 웹브라우저에 전송(클라이언트의 자바스크립트에서 사용가능해짐)
	out.println(Json);
	
%>
