<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv= "Content-Type" content="text/html;" charset="UTF-8">
<title>default</title>
</head>
<body>
	<%
		String appPath = application.getContextPath();
		String filePath = application.getRealPath("01_application.jsp");
		String serverInfo = application.getServerInfo();
	%>
	
	1. 웹 어플리케이션의 컨텍스트 패스명
	<br>
	<b><%=appPath %></b>
	<hr>
	2. 웹 어플리케이션의 파일경로명
	<br>
	<b><%=filePath %></b>
	<hr>
	3. 서블릿 컨텍스트의 이름과 버전 반환
	<br>
	<b><%=serverInfo %></b>
	<hr>
	
</body>
</html>