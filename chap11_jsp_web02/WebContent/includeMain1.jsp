<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포함하는 페이지 includeMain.jsp 입니다.</h1>
	<% request.setCharacterEncoding("utf-8"); %>
	<hr>
	
	<jsp:include page="includeSub1.jsp" flush = "false" />
	
	includeMain1.jsp 나머지 내용입니다.
</body>
</html>