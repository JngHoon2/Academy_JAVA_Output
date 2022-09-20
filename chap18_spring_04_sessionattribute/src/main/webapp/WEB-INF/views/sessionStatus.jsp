<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionStatus</title>
</head>
<body>
	<h1>현재 세션에 저장된 정보와 model에 저장된 정보 비교</h1>
	1. 세션에 저장된 demoVO @SessionAttributes Session : ${sessionScope.demoVO}<br><br>
	2. model에 저장된 demoVO : ${demoVO}<br>
</body>
</html>