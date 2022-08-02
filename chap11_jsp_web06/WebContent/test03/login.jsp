<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<form action="result.jsp">
		아이디 : <input type="text" name="id" size=20/><br>
		비밀번호: <input type="password" name="pwd" size=20/><br>
		<input type="submit" value="로그인"/>
		<input type="reset" value="다시입력"/>
	</form>
	<br>
	<br>
	<a href = "${pageContext.request.contextPath}/test03/memberForm.jsp">회원등록하기</a>
</body>
</html>