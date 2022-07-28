<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
	<h2> 포워딩되는 페이지 : forwardTo1.jsp</h2>
	<%	request.setCharacterEncoding("utf-8"); %>
	<%
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_pw");
	%> <b>
	
	<%= id %></b>님의 <p> 패스워드는 <b><%= password %></b>입니다.
</body>
</html>