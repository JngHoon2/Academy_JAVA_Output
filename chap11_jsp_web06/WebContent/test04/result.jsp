<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
	<c:if test="${empty param.id}">
		아이디를 입력해주세요.<br>
		<a href="${contextPath}/test03/login.jsp">로그인 창</a>
	</c:if>
	<c:if test="${not empty param.id}">
		<h1> 
			환영합니다. <c:out value="${param.id}" />님!!!
		</h1>
	</c:if>
</body>
</html>