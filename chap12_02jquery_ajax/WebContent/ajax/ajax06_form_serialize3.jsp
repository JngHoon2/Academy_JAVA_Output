<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%@ page import="com.javalab.dto.*" %>
<%
	// 응답 컨텐츠 타입 설정
	//이런 형태로 보내겠다고 선언
	response.setContentType("application/json");
	response.setHeader("Content-Disposiont", "inline");
	
	String name = "";
	String age = "";
	String address = "";
	
	if(request.getParameter("name") != null){
		name = request.getParameter("name");
	}
	
	if(request.getParameter("age") != null){
		age = request.getParameter("age");
	}
	
	if(request.getParameter("address") != null){
		address = request.getParameter("address");
	}
	
	System.out.println(name + " " + age + " " + address);
	
	Member mem = new Member();
	mem.setName(name);
	mem.setAge(age);
	mem.setAddress(address);
	
	System.out.println(mem.toString());
	
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("member", mem);
	
	Gson gson = new Gson();
	String Json = gson.toJson(map);
	
	System.out.println(Json);
	
	out.println(Json);
	
%>
