<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/delete?no=${param.no}" method="post">
	    <table>
	        <tr>
	            <td>비밀번호</td>
	            <td><input type="password" name="pwd"></td>
	            <td><input type="submit" value="확인"></td>
	        </tr>
	    </table>
	</form>
	
	<a href="/">메인으로 돌아가기</a>
</body>
</html>