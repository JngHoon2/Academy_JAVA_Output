<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:set var = "gender" value = "2"></c:set>
	<c:choose>
		<c:when test="${gender == 1}">
			남성입니다.
		</c:when>
		<c:when test="${gender == 2}">
			여성입니다.
		</c:when>
		<c:otherwise>
			트랜스젠더입니다.
		</c:otherwise>
	</c:choose>
</body>
</html>