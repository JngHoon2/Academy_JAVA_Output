<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, bean01.*" isELIgnored="false"%>

<%
	request.setCharacterEncoding("utf-8");

	ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
	
	MemberBean mb1 = new MemberBean("lee", "1234", "이순신", "lee@test.com");
	MemberBean mb2 = new MemberBean("son", "1234", "손흥민", "son@test.com");
	
	memberList.add(mb1);
	memberList.add(mb2);
	
	request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward03</title>
</head>
<body>
	<jsp:forward page="member03.jsp" />
</body>
</html>