<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%
	String[] stringArray = {"aa", "bb", "cc", "dd"};
	request.setAttribute("strArr", stringArray);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="str" items= "${strArr}">
		<tr>
			<td>${str}</td>
		</tr>
	</c:forEach>
</body>
</html>