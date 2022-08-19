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
	1. result 변수를 만들고 값으로 "장보고" 세팅 <br>
	<c:set var="result" value= "장보고"></c:set>
	
	2. result 변수의 값이 비어있지 않으면 출력<br>
	<c:if test="${!empty result}">
		result의 값은 ? ${result} 입니다.
	</c:if>
</body>
</html>