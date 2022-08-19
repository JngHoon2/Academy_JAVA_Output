<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("utf-8");	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드 요청</title>
</head>
<body>
	<form action="result.jsp" method="post" >
		<input type=hidden name="param1" value="nature01.jpg" /><br>
		<input type=hidden name="param2" value="nature02.jpg" /><br>
		<input type=hidden name="param3" value="dog.jpg" /><br>
		<input type="submit" value="다운로드">
	</form>
</body>
</html>