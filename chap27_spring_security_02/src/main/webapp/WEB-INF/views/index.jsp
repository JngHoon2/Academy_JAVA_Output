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
	
	<%-- <a href="<c:url value='/login' />">로그인	</a> <br><br> --%>
	
	<p>
		<a href="<c:url value='/admin/home' />">어드민 전용 페이지</a>
	</p>
	<p>
		<a href="<c:url value='/secured/home' />">일반 사용자 페이지</a>
	</p>	

	<sec:authorize access="isAnonymous()">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
		</ul>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
  			<ul>
			<li><a href="#" onclick="document.getElementById('logoutForm').submit();">로그아웃</a>
				<form id="logoutForm" 
					action="<c:url value='/logout?${_csrf.parameterName}=${_csrf.token}' />"  
					method="POST">
				</form>
			</li>
		</ul>
	</sec:authorize>

    <div id="register-link" class="text-right">
        <a href="${pageContext.request.contextPath}/emp/employeeList2" class="text-info">부트스트랩 폼</a>
    </div>

<%-- 	<table>
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		<tbody>
			<tr>
				<th align="center">사원번호</th>
				<td><c:out value="${member.employeeId}" /></td>
			</tr>
			<tr>
				<th align="center">성명</th>
				<td><c:out value="${member.firstName} ${member.lastName}" escapeXml="false"/></td>
			</tr>
			<tr>
				<th align="center">이메일</th>
				<td><c:out value="${member.email}" /></td>
			</tr>
			<tr>
				<th align="center">연락처</th>
				<td><c:out value="${member.phoneNumber}" /></td>
			</tr>

			<tr>
				<th align="center">입사일자</th>
				<td><c:out value="${member.hireDate}" /></td>
			</tr>
			<tr>
				<th align="center">업무</th>
				<td><c:out value="${member.jobId}" /></td>
			</tr>

			<tr>
				<th align="center">급여</th>
				<td><c:out value="${member.salary}" /></td>
			</tr>				
		</tbody>
	</table> --%>

</body>
</html>
