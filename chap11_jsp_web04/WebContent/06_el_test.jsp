<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_test.jsp</title>
</head>
<body>
당신의 이름은 ${param.name} 입니다.<br>
당신의 이름은 <%= name %> 입니다.
</body>
</html>