<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Expression Language Example</h2>
	<h3>EL 조건문에 사용</h3>
	
	1. name 이라는 이름으로 전달된 파라미터의 값을 출력(c:out 형태로 사용)
	<br> => param.name : <c:out value="${param.name}"/><hr>
	
	2. param에 name 이라는 값이 비어 있는지 체크? (true/false)
	<br> => true/false : ${empty param.name}<hr>
	
	<c:if test= "${empty param.name}">
	3. 조건 판단으로 c:if 태그 시용하는 방법으로 파라미터 값이 없으면 이름을 <br>입력하도록 입력란을 보여줌
		<form action="" method="get">
			이름을 적어주세여. <br />
			이름 : <input type="text" name="name">
			<input type="submit" value="확인">
		</form>
	</c:if><hr>
	
	4. 파라미터 값이 비어있지 않으면 님 안녕하세요.
	<br>
	<c:if test= "${empty param.name}">
		<c:out value="${param.name}"/> 님 안녕하세요.
	</c:if><hr>
	
	5. 조건 판단으로 c:choose when을 사용하는 방법
	<br>
	<c:choose>
		<c:when test="${empty param.name}">
			이름을 적어주세여. <br />
			이름 : <input type="text" name="name">
			<input type="submit" value="확인">
		</c:when>
		<c:when test="${param.name == 'admin'}">
			관리자님 안녕하세요.
		</c:when>
		<c:otherwise>
			<c:out value="${param.name}"/> 님 안녕하세요.
		</c:otherwise>
	</c:choose>
</body>
</html>