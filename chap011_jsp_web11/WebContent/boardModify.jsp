<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.javalab.vo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="memberBean" class="com.javalab.vo.BoardVO"/>  
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	//한글 인코딩 처리
	request.setCharacterEncoding("utf-8");

	int no = Integer.parseInt(request.getParameter("no"));
	String title = (String)request.getParameter("title");
	String content = (String)request.getParameter("content");
	String writer = (String)request.getParameter("writer");
	
	content = content.replace("<p>", "");
	content = content.replace("</p>", "");
	content = content.replace("</br>", "");
	
	/* 이 부분은 서블릿 쪽에서 데이터를 만들어서 현재 jsp페이지로 전달해주는 것과 같은 매커니즘 */
	BoardVO boardWrite = new BoardVO(no, title, content, writer);
	
	// 아래와 같이 request 객체에 넣어줘야 현재 페이지에서 사용할 수 있음.
	request.setAttribute("boardWrite", boardWrite);
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정 폼</title>

<script type="text/javascript" src='<c:url value="/ckeditor/ckeditor.js" />'></script>

</head>
<body>
	<h1 align="center">게시판 수정 폼</h1>
	<form action="<c:url value="/modify"/>" method="post">
	
		<input type="hidden" name="no" value="${boardWrite.no}">
		<input type="hidden" name="title" value="${boardWrite.title}">
		<input type="hidden" name="writer" value="${boardWrite.writer}">
	
		<table border=1 align="center" summary="게시판 수정 폼">
			<!-- <caption>게시판 수정 폼</caption> -->
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>
			<tbody>
				<tr>
					<th bgcolor="#bbffdd" align="center">제목</th>
					<td>${boardWrite.title}</td>
				</tr>
				<tr>
					<th bgcolor="#bbffdd" align="center">작성자</th>
					<td>${boardWrite.writer}</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="content" cols="80" rows="10">
							${boardWrite.content}
						</textarea>
						<script>CKEDITOR.replace('content');</script>
					</td>
				</tr>
			</tbody>
		</table>
		<p align="center">
			<input type="submit" value="수정하기" />
		</p>
	</form>
	
	<form method="post" encType="utf-8" action="${contextPath}/list">
		<input type="hidden" name="no" value="${boardWrite.no}">
		<input type="hidden" name="title" value="${boardWrite.getTitle()}"/>
		<input type="hidden" name="writer" value="${boardWrite.getWriter()}"/>
		<input type="hidden" name="content" value="${boardWrite.getContent()}"/>
		<p align="center">
			<input type="submit" value="목록"/>		
		</p>
	</form>
	<form method="post" encType="utf-8" action="${contextPath}/delete">
		<input type="hidden" name="no" value="${boardWrite.no}">
		<p align="center">	
			<input type="submit" value="삭제하기"/>
		</p>
	</form>
	
</body>
</html>