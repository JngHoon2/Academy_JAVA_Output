<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("memberId")){
					response.sendRedirect("loginOk.jsp");
				}
			}
		}
	%>
	<form action="${pageContext.request.contextPath}/loginCheck" method="post">
		ID : <input type="text" name="userID"><br>
		Password : <input type="password" name="userPWD"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>