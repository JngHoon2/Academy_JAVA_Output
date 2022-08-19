<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	System.out.println(name);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 사용자 페이지</title>
</head>
<body>

	
	<h3> <%= name %>님 환영합니다.</h3>
		
</body>
</html>