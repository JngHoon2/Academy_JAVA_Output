<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
	<form name="frmLogin" method="get" action = "/chap11_jsp_web01/jsp08_login.jsp">
		아이디 : <input type = "text" name = "user_id"><br>
		비밀번호:<input type = "password" name = "user_pw"><br>
		<input type = "submit" value = "로그인">
		<input type = "reset" value = "다시 입력">
	</form>
</body>
</html>