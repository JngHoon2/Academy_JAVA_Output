<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<form action="/chap11_jsp_web07/memberInsert" method="post">
		이름 <input type="text" name="name"><br>
		나이 <input type="text" name="age"><br>
		
		취미 <input type="checkbox" name="hobby" value="book">책읽기
			<input type="checkbox" name="hobby" value="cook">요리
			<input type="checkbox" name="hobby" value="run">달리기<br>
		
		전공 <input type="radio" name="major" value="kor">국어
			<input type="radio" name="major" value="eng">영어
			<input type="radio" name="major" value="design">디자인<br>
		
		이메일 <select name="all">
				<option value="naver">네이버
				<option value="gmail">지메일
				<option value="daum">한메일
				<option value="nate">네이트
			 </select> <br>
			<input type="submit" value="제출">
			<input type="reset" value="다시쓰기">
	</form>
</body>
</html>