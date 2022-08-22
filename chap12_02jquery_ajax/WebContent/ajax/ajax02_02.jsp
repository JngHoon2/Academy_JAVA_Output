<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%
	// [1] 응답 컨텐츠 타입 설정
	// 사용자에게 응답할 컨텐츠 타입 설정, 이런 형태로 보내겠다고 선언
	response.setContentType("application/json");

	// [2] 사용자에게 응답할 형태 설정
	// 1. 사용자 브라우저에 내용에 쓰기
	response.setHeader("Content-Disposiont", "inline");
	
	String id = request.getParameter("id");
	System.out.println("서버로 전송된 파라미터 id : " + id);

	boolean result = false;
	if(id != null && id.length() != 0){
		if(id.equals("dream")){
			result = true;
		}
	}
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("isDuplicate", result);
	
	Gson gson = new Gson();
	String Json = gson.toJson(map);
	out.println(Json); // 사용자 웹브라우저에 전송	
	
%>
