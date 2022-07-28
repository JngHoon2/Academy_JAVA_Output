<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv= "Content-Type" content="text/html;" charset="UTF-8">
<title>GetPost</title>
</head>
<body>
	<h3> get/post 방식에 따른 한글 인코딩 차이</h3><br>
	
	<form method="get" action="MethodServlet">
		<input type="text" name = "id">
		<input type="submit" value= "get 방식으로 호출하기">
	</form>
	<br>
	<br>
	<form method="post" action="MethodServlet">
		<input type="text" name = "user_id">
		<input type="submit" value= "post 방식으로 호출하기">
	</form>
</body>
</html>