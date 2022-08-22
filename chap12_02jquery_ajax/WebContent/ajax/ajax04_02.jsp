<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%
	// 응답 컨텐츠 타입 설정
	//이런 형태로 보내겠다고 선언
	response.setContentType("application/json");

	/*
		Content-Disposiont : inline //브라우저에서 응답하기
		Content-Disposiont : attachment //팝업 형태(alert)로 응답하기
	*/
	response.setHeader("Content-Disposiont", "inline");
	
	int selectedValue = 0;
	
	if(request.getParameter("selectedValue") != null){
		selectedValue = Integer.parseInt(request.getParameter("selectedValue"));
	}
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("selectedValue", selectedValue);
	
	Gson gson = new Gson();
	String Json = gson.toJson(map);
	out.println(Json);
	
%>
