<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String id = request.getParameter("id");
	request.setAttribute("id", id);
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정 창</title>
</head>
<body>
	<form method="post" action="${contextPath}/test06/member_update.jsp">
		<h1 style="text-align: center">정보수정 창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">비밀번호</td>
				<td width="400"><input type="text" name="id" value="${id}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</td>
				<td width="400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</td>
				<td width="400"><p><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</td>
				<td width="400"><p><input type="text" name="email"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;<p></td>
				<td width="400"><input type="submit" value="수정하기">
				<input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>