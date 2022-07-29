<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv= "Content-Type" content="text/html;" charset="UTF-8">
<title>fmt : setLocale</title>
</head>
<body>
	<c:set var="now" value="<%= new java.util.Date() %>"/>

	<h1>대한민국</h1>
	<fmt:setLocale value="ko_kr"/>
	금액 : <fmt:formatNumber value= "1000000" type="currency" /><br>
	일시 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
	<hr>
	
	<h1>미국</h1>
	<fmt:setLocale value="en_us"/>
	금액 : <fmt:formatNumber value= "1000000" type="currency" /><br>
	일시 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
	<hr>
	
	<h1>일본</h1>
	<fmt:setLocale value="ja_jp"/>
	금액 : <fmt:formatNumber value= "1000000" type="currency" /><br>
	일시 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
	<hr>
	
</body>
</html>