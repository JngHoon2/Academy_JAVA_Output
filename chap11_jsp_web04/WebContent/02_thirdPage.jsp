<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv= "Content-Type" content="text/html;" charset="UTF-8">
<title>secondPage</title>
</head>
<body>
	<h3> 현재 Third Page </h3>
	1. 하나의 page 속성 : <%= pageContext.getAttribute("name") %><br>
	&nbsp; => 현재 pageContext name 이라는 속성을 설정하지 않았기 때문에 null<br>
	
	2. 하나의 request 속성 : <%= request.getAttribute("name") %><br>
	&nbsp; => 이전 페이지에서 request 기본객체에 저장한 속성을 못갖고옴. request 증발<br>
	
	3. 하나의 session 속성 : <%= session.getAttribute("name") %><br>
	&nbsp; => 이전 페이지에서 session 기본객체에 저장했고 세션은 브라우저를 끄지 않는 한 유지.<br>
	
	4. 하나의 application 속성 : <%= application.getAttribute("name") %><br>
	&nbsp; => application 기본객체는 현재 어플리케이션이 구동되는 동안 계속 유지.<br>

</body>
</html>