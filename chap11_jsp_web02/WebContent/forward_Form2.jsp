<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가나다</title>
</head>
<body>
	<h1>포워딩될 페이지에 파라미터 값 전달하기 예제</h1>
	
	<form method = "post" action="/chap11_jsp_web02/forwardForm2.jsp">
	이름 : <input type = "text" id = "name" name = "name"> <br /> <br />
	당신의 혈액형은? <p>
	
	<input type = "radio" id = "a" name = "bloodType" value = "a" />
	<label for = "a">A</label> <br />
	
	<input type = "radio" id = "b" name = "bloodType" value = "b" />
	<label for = "a">B</label> <br />
	
	<input type = "radio" id = "o" name = "bloodType" value = "o" />
	<label for = "a">O</label> <br />
	
	<input type = "radio" id = "ab" name = "bloodType" value = "ab" />
	<label for = "a">AB</label> <br />
	
	<p>
	
	<input type = "submit" value = "보내기">
	</form>
</body>
</html>