<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Locale</h2>
	<pre>
		default locale : <%= response.getLocale() %>
		set locale : ko <fmt:setLocale value="ko"/>
		now: <%= response.getLocale() %>
		set locale : ja <fmt:setLocale value="ja"/>
		now: <%= response.getLocale() %>
		set locale : en <fmt:setLocale value="en"/>
		now: <%= response.getLocale() %>
	</pre>
</body>
</html>