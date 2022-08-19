<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 </title>
</head>
<body>
	<form method="post" action = "/chap11_jsp_web02/forward_Form1.jsp">
		아이디 : <input type = "text" name = "user_id"><p>
		비밀번호:<input type = "password" name = "user_pw"><p>
		<input type = "submit" value = "보내기">
	</form>
</body>
</html>