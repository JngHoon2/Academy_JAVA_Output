<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/test01/result.jsp">
		아이디 : <input type="text" name="id" size=20/><br>
		비밀번호: <input type="password" name="pwd" size=20/><br>
		<input type="submit" value="로그인"/>
		<input type="reset" value="다시입력"/>
	</form>
	<br>
	<br>
	<a href = "${pageContext.request.contextPath}/test01/memberForm.jsp">회원가입</a>
</body>
</html>