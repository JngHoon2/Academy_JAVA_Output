<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.*,com.javalab.dto.*" %>

	<% 
		request.setCharacterEncoding("UTF-8");
		//로그인 실패하면 오는 페이지(세션에 오류 메시지 담고 있음)
		//실패 메시지를 alert으로 띄우주고 바로 이전화면(workerLogin.jsp로 이동)
 		String msg = "";
 		msg = (String)session.getAttribute("msg");
 		System.out.println("msg : " + msg);
 		
 		Worker worker = (Worker)session.getAttribute("worker");
 		System.out.println("worker : " + worker);
		
	 %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>관리자 로그인 화면 : workerLogin.jsp</title>
	<link rel="stylesheet" type="text/css" href="css/shopping.css" />
	<script type="text/javascript" src="script/product.js" ></script>
</head>
<body>

	<%
		PrintWriter script = response.getWriter();
	
		script.println("<script>");
		script.println("alert('로그인에 실패했습니다.');");
		script.println("history.back()");
		script.println("</script>");
	
	%>
	

</body>
</html>