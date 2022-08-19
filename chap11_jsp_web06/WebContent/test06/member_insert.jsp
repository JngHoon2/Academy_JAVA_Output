<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, bean01.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<b>회원가입 정보를 확인하세요.</b>
	<br/><br/>
	
	<jsp:useBean id="memberBean" class="bean01.MemberBean"/>
	<jsp:setProperty property="*" name="memberBean"/>
	
	<%
		MemberDAO dao = MemberDAO.getInstance();
		dao.insertMember(memberBean);
	%>
	
	<b>회원가입이 되었습니다.</b><br>
	<a href="${contextPath}/test06/memberList.jsp">메인으로</a>
</body>
</html>