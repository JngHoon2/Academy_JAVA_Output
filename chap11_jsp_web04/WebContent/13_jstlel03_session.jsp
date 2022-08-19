<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test= "${!empty hit}">
		<c:set var="hit" value="${hit+1}" scope="session"/>
		<c:out value="${hit}" /> 번 리로드되었습니다.
	</c:if>
	
	<c:if test= "${empty hit}">
		<c:set var="hit" value="1" scope="session"/> 세션에 값을 저장했습니다.
	</c:if>
	<br>
	<a href="13_jstlel03_session.jsp">reload</a>
</body>
</html>