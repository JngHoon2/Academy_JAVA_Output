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
	<c:set var = "age" value="<%= 20 %>"></c:set>
	
	${age}는 20과
	<c:if test = "${age == 20}">
		같은 숫자입니다.
	</c:if>
	다른숫자입니다
	<%-- <c:if test= "${age != 20}">
		다른 숫자입니다.
	</c:if> --%>
		
</body>
</html>