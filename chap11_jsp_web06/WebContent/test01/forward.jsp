<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="m1" class="bean01.MemberBean" scope = "page" />
<jsp:setProperty name="m1" property="id" value="general" />
<jsp:setProperty name="m1" property="pwd" value="1234" />
<jsp:setProperty name="m1" property="name" value="이순신" />
<jsp:setProperty name="m1" property="email" value="shlee@gmail.com" />

<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("m1", m1);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
	<h3>여기는 forward.jsp 페이지</h3>
	<jsp:forward page="member1.jsp"></jsp:forward>
</body>
</html>