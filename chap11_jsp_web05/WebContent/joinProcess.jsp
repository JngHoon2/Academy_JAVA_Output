<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "javabean.dao.MemberDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리 jsp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<b>회원가입 정보를 확인하세요.</b>
	<br/><br/>
	
	<jsp:useBean id="memberBean" class="javabean.MemberBean"/>
	<jsp:setProperty property="*" name="memberBean"/>
	
	<%
		MemberDAO dao = MemberDAO.getInstance();
		dao.joinMember(memberBean);
	%>
	
	<b>회원가입이 되었습니다.</b><br>
</body>
</html>