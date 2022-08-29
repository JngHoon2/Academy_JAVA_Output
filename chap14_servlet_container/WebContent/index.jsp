<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="cpntext-Type" content = "text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${contextPath}/helloServlet.do">HelloServlet 호출</a>
</body>
</html>