<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<script src="<c:url value="/webjars/jquery/3.5.1/dist/jquery.min.js"/>"></script>
	
	<link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
	
	<script src="${contextPath}/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<script>
		$(function(){
			$("#btnSearch").click(function(e){
				alert("클릭된 요소의 id : " + e.target.id);
			});
		});
	</script>

</head>
<body>
	<h2>webjars 예제</h2>
	<br><br>
	<h4>webjars를 통해서 자바스크립트 라이브러리를 메이븐 라이브러리에 포함.</h4>
	<h4>자바스크립트를 다운로드 받아서 webapp/resources에 import할 필요 없음!</h4>
	<br><br>
	<button type="button" id="btnSearch" class="btn btn-primary mt-2 ml-2">검색</button>
</body>
</html>