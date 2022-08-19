<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>스크립트 예제</h3>
	<%
		int sum = 0;
		for(int i = 0; i <= 100; i++){
			sum += i;
		}
	%>
	<h3>1부터 100까지의 합 : <%= sum %></h3>
</body>
</html>