<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "board.dao.*" %>
<%@ page import = "board.vo.*" %>
<%@ page import = "java.util.*" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("utf-8");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<jsp:useBean id="board" class="board.vo.Board"/>
	<jsp:setProperty property="*" name="board"/>
	
	<%
		BoardDAO dao = BoardDAO.getInstance();
	
		ArrayList<Board> list = new ArrayList<Board>();	
	
		list = dao.listBoard();
		
		request.setAttribute("boardList", list);
	%>
	
	
</body>
</html>