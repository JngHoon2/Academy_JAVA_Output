<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetPost</title>
<script type = "text/javascript" src = "05_param.js"></script>
</head>
<body>
	<h3> 파라미터 전송시 별도로 import된 자바스크립트를 통해서 값을 검증하는 방법</h3><br>
	
	<form method="get" action="ParamServlet" name="frm">
		아이디 : <input type="text" name = "id"><br>
		나이 : <input type="text" name = "age"><br>
		<input type="submit" value= "전송" onclick="return check();"> <br>
	</form>
</body>
</html>