<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.javalab.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="memberBean" class="com.javalab.vo.BoardVO"/>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	//한글 인코딩 처리
	request.setCharacterEncoding("utf-8");

	/* 이 부분은 서블릿 쪽에서 데이터를 만들어서 현재 jsp페이지로 전달해주는 것과 같은 매커니즘 */
	BoardVO boardView = (BoardVO)request.getAttribute("boardView");
	
	// 아래와 같이 request 객체에 넣어줘야 현재 페이지에서 사용할 수 있음.
	request.setAttribute("boardView", boardView);
 %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기 폼</title>
</head>
<body>
	<h1 align="center">게시물 상세보기 폼</h1>
	<form action="boardModify.jsp" method="post">
		<input type="hidden" name="no" value="${boardView.getNo()}"/>
		<input type="hidden" name="title" value="${boardView.getTitle()}"/>
		<input type="hidden" name="writer" value="${boardView.getWriter()}"/>
		<input type="hidden" name="content" value="${boardView.getContent()}"/>
	
		<table border=1 align="center" summary="게시판 상세보기 폼">
			<!-- <caption>게시판 상세보기 폼</caption> -->
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>
			<tbody>
				<tr>
					<th bgcolor="#bbffdd" align="center">제목</th>
					<td>${boardView.getTitle()}</td>
				</tr>
				<tr>
					<th bgcolor="#bbffdd" align="center">작성자</th>
					<td>${boardView.getWriter()}</td>
				</tr>
				<tr>
					<td colspan="2" width="100%">
						<label>${boardView.getContent()}</label>
					</td>
				</tr>
			</tbody>
		</table>
		<p align="center">
			<a href="${contextPath}/list"><input type="button" value="목록" /></a>
			<input type="submit" value="수정" />
		</p>
	</form>
</body>
</html>