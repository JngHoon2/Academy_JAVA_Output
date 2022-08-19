<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<thead>
			<tr align="center" bgcolor="99ccff">
				<td width="20%"><b>순번</b></td>
				<td width="20%"><b>아이디</b></td>
				<td width="20%"><b>비밀번호</b></td>
				<td width="20%"><b>이름</b></td>
				<td width="20%"><b>이메일</b></td>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${memberList.size() > 0}">
					<c:forEach var="member" items="${memberList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${member.id}</td>
							<td>${member.pwd}</td>
							<td>${member.name}</td>
							<td>${member.email}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="center" height="23">전체회원수 : ${memberList.size()}</td>
					</tr>
				</c:when>
			</c:choose>
		</tbody>
	</table>
</body>
</html>