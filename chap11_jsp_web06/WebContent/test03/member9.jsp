<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
		</tr>
		<c:choose>
			<c:when test="${empty param.id}">
				<tr align="center">
					<td colspan=5>아이디를 입력하세요. <a
						href="${contextPath}/test03/memberForm.jsp">회원가입 입력폼</a>
				</tr>
			</c:when>
			<c:when test="${empty param.pwd}">
				<tr align="center">
					<td colspan=5>비밀번호를 입력하세요. <a
						href="${contextPath}/test03/memberForm.jsp">회원가입 입력폼</a>
				</tr>
			</c:when>
			<c:when test="${empty param.name}">
				<tr align="center">
					<td colspan=5>이름을 입력하세요. <a
						href="${contextPath}/test03/memberForm.jsp">회원가입 입력폼</a>
				</tr>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td><c:out value="${param.id}"/></td>
					<td><c:out value="${param.pwd}"/></td>
					<td><c:out value="${param.name}"/></td>
					<td><c:out value="${param.email}"/></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>