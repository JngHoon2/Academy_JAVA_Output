<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
	<h2>포워딩하는 페이지 : forwardFrom1.jsp</h2>
	<%	//request.setCharacterEncoding("utf-8"); %>
	<%
		int a = 0;
	%>
	
	forwardForm1.jsp의 내용입니다. <br>
	화면에 절대 표시 안됩니다.
	<%-- 아래 forward 태그 때문에 --%>
	
	<jsp:forward page = "forwardTo1.jsp" />
	<%-- 독립된 객체이기 때문에 스크립트 안에 안쓴다. --%>
</body>
</html>