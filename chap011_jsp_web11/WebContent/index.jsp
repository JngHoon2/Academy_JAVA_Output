<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*, com.javalab.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 메인 페이지</title>
</head>
<body>
	<h1 align="center">Simple Board Index Page</h1>
	<p align="center">
		<a href="${contextPath}/list">게시물 목록 보기</a>
	</p>
</body>
</html>