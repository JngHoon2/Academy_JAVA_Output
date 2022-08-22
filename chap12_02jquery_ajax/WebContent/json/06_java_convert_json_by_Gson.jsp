<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.*" %>
<%@ page import="com.javalab.dto.*" %>

<%
	Gson gson = new Gson();

	Member member = new Member();
	member.setAddress("전주");
	member.setAge("21");
	member.setName("홍길동");
	
	//인스턴스화(객체:member)를 Gson이용하여 json 포맷방식 String 
	String getJson = gson.toJson(member);
	out.println(getJson);	//첫번째 member객체를 내보냄

	List<Member> list = new ArrayList<Member>();
	
	member = new Member();
	member.setAddress("전주");
	member.setAge("21");
	member.setName("홍길동");
	list.add(member);

	member = new Member();
	member.setAddress("천안");
	member.setAge("25");
	member.setName("김미영");
	list.add(member);
	
	String getJson2 = gson.toJson(list);
	out.println(getJson2);	//두번째 List를 json객체로 변환
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>