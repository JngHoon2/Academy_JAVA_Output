<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.util.*"%>
<%
	// 응답 컨텐츠 타입 설정
	//이런 형태로 보내겠다고 선언
	response.setContentType("application/json");

	//해당 헤더로 브라우저에서 바로 응답 or 팝업으로 띄우겠다
	//	Content-Disposiont : inline //브라우저에서 응답하기
	//	Content-Disposiont : attachment //팝업 형태(alert)로 응답하기
	//response.setHeader("Content-Disposiont", "inline");
	response.setHeader("Content-Disposiont", "inline");
	
	int num1 = 0;
	int num2 = 0;
	
	if(request.getParameter("paramNum1") != null){
		num1 = Integer.parseInt(request.getParameter("paramNum1"));
	}

	if(request.getParameter("paramNum2") != null){
		num2 = Integer.parseInt(request.getParameter("paramNum2"));
	}
	
	int result = num1 * num2 ;
	//map에 int 타입의 값을 넣음
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("result", result);
	
	Gson gson = new Gson();
	String Json = gson.toJson(map);
	// 사용자 웹브라우저에 전송(클라이언트의 자바스크립트에서 사용가능해짐)
	out.println(Json);
	
%>
