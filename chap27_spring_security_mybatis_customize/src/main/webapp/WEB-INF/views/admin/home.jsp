<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Secured Admin Home</title>
</head>
<body>
<h3>Admin 관리자 전용 페이지</h3>
<h4>관리자 ${username},  ${message}</h4>
<c:if test="${not empty pageContext.request.userPrincipal.name}">
		${pageContext.request.userPrincipal.name} 님 환영합니다.<br>
		<input type="button" 
			   value="로그아웃"
			   onclick="location.href='${pageContext.request.contextPath}/logoutProc'" />	
	</c:if>
</body>
</html>