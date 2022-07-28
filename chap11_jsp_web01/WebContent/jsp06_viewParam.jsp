<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>클라이언트가 보낸 요청 파라미터 값 출력</h3>
		1. 아이디 파라미터 : <%= request.getParameter("user_id") %><br>
		2. 비밀번호 파라미터 : <%= request.getParameter("user_pwd") %><br>
		3. 선호하는 프로그래밍 언어 :
		<%
			String[] languages = request.getParameterValues("subject");
			
			if(languages.length > 0){
				for(String str : languages){
		%>		
					<%= str %>
		<%
				}
			}
		%>
</body>
</html>