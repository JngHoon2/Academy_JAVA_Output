<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name = "frmInput" method = "get" action = "/chap11_jsp_web01/jsp06_viewParam.jsp">
		아이디 : <input type = "text" name = "user_id"><br>
		비밀번호:<input type = "password" name = "user_pwd"><br>
		<input type = "checkbox" name = "subject" value = "java" checked > 자바
		<input type = "checkbox" name = "subject" value = "C" > C
		<input type = "checkbox" name = "subject" value = "JSP" > JSP
		<input type = "checkbox" name = "subject" value = "AOS" > AOS
		<br><br>
		<input type = "submit" value = "전송">
		<input type = "reset" value = "초기화">
	</form>	
	
</body>
</html>