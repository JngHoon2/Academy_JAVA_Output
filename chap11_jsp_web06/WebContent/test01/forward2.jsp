<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean01.*" %>

<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	MemberBean member = new MemberBean(id, pwd, name, email);
	request.setAttribute("member", member);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward2</title>
</head>
<body>
	<h3>forward2.jsp</h3>
	<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>