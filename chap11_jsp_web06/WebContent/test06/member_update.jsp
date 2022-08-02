<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, bean01.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	System.out.println(id);
	System.out.println(pwd);
	System.out.println(name);
	System.out.println(email);
	
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
	
		MemberBean update = new MemberBean(id, pwd, name, email);
	
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(email);
		
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(update);
	%>
	
	<b>맴버정보가 수정 되었습니다.</b><br>
	<a href="${contextPath}/test06/memberList.jsp">메인으로</a>
</body>
</html>