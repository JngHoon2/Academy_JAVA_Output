<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Security</title>
</head>

<body>
	<h2>Spring Security Index Page</h2>
	
	<a href="<c:url value='/emp/employeeList' />">Employee List</a>
	<br><br>

    <div id="register-link" class="text-right">
        <a href="${pageContext.request.contextPath}/admin/employeeList2" class="text-info"> Bootstrap Employee List</a>
    </div>

	<!-- 로그인 안한 사용자 -->
	<sec:authorize access="isAnonymous()">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
		</ul>
	</sec:authorize>
	<!-- 로그인한 사용자 -->
	<sec:authorize access="isAuthenticated()">	
		<hr>
		name : <sec:authentication property="name"/><br>
	    username : <sec:authentication property="principal.username"/><br>
	    principal : ${pageContext.request.userPrincipal}<br>
		<hr>
	
  			<ul>
			<li><a href="#" onclick="document.getElementById('logoutForm').submit();">로그아웃</a>
				<form id="logoutForm" 
					action="<c:url value='/logout?${_csrf.parameterName}=${_csrf.token}' />"  
					method="POST">
				</form>
			</li>
		</ul>
	</sec:authorize>
	
</body>
</html>
