<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="./images/bird.png"/>
image Url : <c:url value="/images/bird.png"/>
<img src="<c:url value= "./images/bird.png"/>">
</body>
</html>