<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 </title>
</head>
<body>
	<h2>포워딩하는 페이지 : forward_Form2.jsp</h2>
	<%	
		request.setCharacterEncoding("utf-8");
		String bloodType = request.getParameter("bloodType") + ".jsp";
	%>
	
	<jsp:forward page = "<%= bloodType %>" />
	<%-- 독립된 객체이기 때문에 스크립트 안에 안쓴다. --%>
</body>
</html>