<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv= "Content-Type" content="text/html;" charset="UTF-8">
<title>secondPage</title>
</head>
<body>
	<jsp:include page = "03_header.jsp"/>
	<h3>메인화면입니다.</h3>
	<br>
	<a href="03_sub.jsp">서브 페이지로 이동</a>
	<jsp:include page = "03_footer.jsp"/>
</body>
</html>