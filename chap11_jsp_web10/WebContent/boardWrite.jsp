<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "board.dao.*" %>
<%@ page import = "board.vo.*" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("utf-8");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Users/tuan/Documents/works/chap11_jsp_web10/WebContent/ckeditor/ckeditor.js"></script>

<style type="text/css">
	*{
		font-size: 12px;
	}
	
	p{
		width: 600px;
		text-align: right;
	}
	
	table{
		border-collapse: collapse;
	}
	
	table tbody tr th{
		background-color: #05bcac;
	}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th align="center">제목</th>
				<th><input type="text" name="title" size="80" maxlength="100" /></th>
			</tr>
			<tr>
				<th align="center">작성</th>
				<th><input type="text" name="writer" size="80" maxlength="20" /></th>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" cols="80" rows="10"></textarea>
					<script>CKEDITOR.replace('content');</script> 
				</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="목록" onclick="goUrl('<c:url value="/boardList" />')">
		<input type="submit" value="저장하기" />
	</p>
</body>
</html>