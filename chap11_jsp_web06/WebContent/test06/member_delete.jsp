<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, bean01.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String id = request.getParameter("id");
	System.out.println(id);
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맴버 삭제</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<br/><br/>
	
	<jsp:useBean id="memberBean" class="bean01.MemberBean"/>
	<jsp:setProperty property="*" name="memberBean"/>
	
	<%
		MemberDAO dao = MemberDAO.getInstance();
		dao.delMember(id);
	%>
	
	<b>맴버가 삭제 되었습니다.</b><br>
	<a href="${contextPath}/test06/memberList.jsp">메인으로</a>
</body>
</html>