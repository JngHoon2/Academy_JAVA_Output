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
	<h3>나는 서브페이지의 주요화면입니다.</h3>
	<br>
	<a href="03_main.jsp">메인 페이지로 되돌아가</a>
	<jsp:include page = "03_footer.jsp"/>
</body>
</html>