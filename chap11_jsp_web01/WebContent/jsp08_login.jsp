<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.net.URLEncoder" %>

<%
	String userId = "";
	String userPw = "";
	userId = request.getParameter("user_id");
	userPw = request.getParameter("user_pw");
	
	System.out.println(userId + " " + userPw);

	String name = "관리자";
	String encodedName = URLEncoder.encode(name);
	
	if(userId.equals("admin") && userPw.equals("1234")){
		System.out.println(userId);
		response.sendRedirect("/chap11_jsp_web01/jsp09_adminPage.jsp?name=" + encodedName);
	} else{
		System.out.println(userPw);
		response.sendRedirect("/chap11_jsp_web01/jsp10_memberPage.jsp");
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>respones.sendRedirect</title>
</head>
<body>
	<h3>respones.sendRedirect() 메소드</h3>
</body>
</html>