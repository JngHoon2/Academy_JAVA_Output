<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류(Exception) 화면입니다.</title>
</head>

<body bgcolor="#ffffff" text="#000000">

	<!-- Title -->
	<table width="100%" border="1" cellpadding="0"  cellspacing="0" >
		<tr>
			<td align="center" bgcolor="#05bcac;">
				<b>기본 에러 화면입니다.</b>
			</td>
		</tr>
	</table>

	<!-- Error Message -->
	<table width="100%" border="1" cellpadding="0"  cellspacing="0" >
		<tr>
			<td align="center">
				<br /><br /><br />
				<b>Message : ${exception.message}</b>
				<ul>
					<c:forEach items="${exception.getStackTrace()}" var="stack">
						<li>${stack.toString()}</li>
					</c:forEach>
				</ul>
				<br /><br /><br /><br /><br /><br />
			</td>
		</tr>
	</table>	
</body>
</html>
