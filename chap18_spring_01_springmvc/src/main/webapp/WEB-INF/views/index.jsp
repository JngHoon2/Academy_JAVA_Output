<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
   
   <p>서버에서 전달받은 현재 시간 : ${time} </p><br>
   
   <a href="${contextPath}/boardList.do">게시판으로 가기</a>
   
</body>
</html>