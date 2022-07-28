<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int multiply(int a, int b){
		int c = a  * b;
		return c;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>선언부 예제</h3>
	<%
		int result = multiply(10, 20);
	%>
	
	10 * 20 = <%= multiply(10, 20) %>
	<br>
	10 * 20 = <%= result %>
	
</body>
</html>