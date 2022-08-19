<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean01.MemberBean" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberBean mb = (MemberBean)request.getAttribute("m1");
	
	request.setAttribute("member", mb);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<h3> 여기는 member1.jsp 회원정보 출력창 </h3>
	<br>
	<table border="1" align="center">
		<tr align="center" bgcolor="99ccff">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<tr align="center">
			<td>${member.id}</td>
			<td>${member.pwd}</td>
			<td>${member.name}</td>
			<td>${member.email}</td>
	</table>
</body>
</html>