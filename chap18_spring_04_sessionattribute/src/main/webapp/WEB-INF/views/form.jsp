<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<h1>스프링 form 태그를 활용한 [회원 수정폼]<br></h1>
	<h4>컨트롤러에서 넘어오는 객체에 맞게 html코드가 생성된다.<br>
	(modelAttribute:스프링 5버전 부터 사용 가능 이전에는 commandName)</h4>
	
	<form:form modelAttribute="demoVO" action="action.do" method="post">
		<label for="id">id : </label>
		<form:input path="id" readonly="true"/> <!-- {demoVO.id} -->
		<br>
		
		<label for="name">name : </label>
		<form:input path="name"/> <!-- {demoVO.name} -->
		<br>
		
		<label for="age">age : </label>
		<form:input path="age"/> <!-- {demoVO.age} -->
		<br>
		
		<label for="bloodType">bloodType : </label>
		<form:select path="bloodType" items="${bloodType}"/> <!-- {demoVO.bloodType} -->
		<br>
		
		<label for="gender">gender : </label>
		<form:input path="gender" items="${gender}"/> <!-- {demoVO.gender} -->
		<br>
		<br>
		
		<input type="submit" value="전송">
	</form:form>
</body>
</html>