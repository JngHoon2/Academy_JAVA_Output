<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
%>

포함되는 페이지 includeSub1.jsp 입니다. <p>

<b><%= name %>님 어서오세요 !!</b>
<hr>