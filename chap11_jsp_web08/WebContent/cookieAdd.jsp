<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder, java.net.URLDecoder"%>
<%
	Cookie cookie = new Cookie("id", "javalab");
	Cookie cookie2 = new Cookie("name", URLEncoder.encode("건양"));
	
	cookie.setMaxAge(60*60*24);
	cookie2.setMaxAge(60*60*24);
	
	cookie.setPath("/");
	cookie2.setPath("/");
	
	response.addCookie(cookie);
	response.addCookie(cookie2);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 정보 저장하기</h2>
	<h3>쿠키 생성 완료!</h3>
	
<%= cookie.getName()%> 쿠키의 값 = <%=cookie.getValue() %>	<br>
<%= cookie2.getName()%> 쿠키의 값 = <%=URLDecoder.decode(cookie2.getValue(), "utf-8") %>
</body>
</html>