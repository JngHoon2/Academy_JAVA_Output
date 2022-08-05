<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("utf-8");	
%>
<html>
<head>
	<meta charset="UTF-8">
	<c:set var="file1" value="${param.param1}" />
	<c:set var="file2" value="${param.param2}" />
	<c:set var="file3" value="${param.param3}" />
	<title>이미지 파일 출력하기</title>
</head>
<body>
	
	파라미터 1 :
	<c:out value="${file1}"/><br>
	파라미터 2 :
	<c:out value="${file2}"/><br>
	파라미터 3 :
	<c:out value="${file3}"/><br>
	
	<c:if test="${not empty file1}">
		<img src="${contextPath}/download.do?fileName=${file1}" width=300 height=300 />
		<br>
	</c:if>
	<c:if test="${not empty file2}">
		<img src="${contextPath}/download.do?fileName=${file2}" width=300 height=300 />
		<br>
	</c:if>
	<c:if test="${not empty file3}">
		<img src="${contextPath}/download.do?fileName=${file3}" width=300 height=300 />
		<br>
	</c:if>
	
	<b>이미지 파일 내려받기</b>
	<br>
	<a href="${contextPath}/download.do?fileName=${file1}">파일1 내려받기</a>
	<a href="${contextPath}/download.do?fileName=${file2}">파일2 내려받기</a>
	<a href="${contextPath}/download.do?fileName=${file3}">파일3 내려받기</a>
	<br>
</body>
</html>