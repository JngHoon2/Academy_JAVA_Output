<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩되는 페이지(ab.jsp)</h1>
	<%
		String name = request.getParameter("name");
		String bloodType = request.getParameter("bloodType");
	%>
	
	<b><%=name %></b>님의 혈액형은 
	<b><%=bloodType %></b>입니다.
	<p> 현재 페이지는 ab.jsp 
</body>
</html>