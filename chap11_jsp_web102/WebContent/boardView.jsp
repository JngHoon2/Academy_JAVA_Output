<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>게시판 상세보기</title>
	
	<style>
		* {font-size: 9pt;}
		.btn_align {width: 600px; text-align: right;}
		table tbody tr th {background-color: gray;}
	</style>

</head>

<body>
<h3 align="center">게시글 상세보기 화면</h3>
<hr>

	<table border="1" summary="게시판 상세조회" align="center">
		<caption>게시글 상세보기</caption>
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		<tbody>
			<tr>
				<th align="center">제목</th>
				<td>${board.subject}</td>
			</tr>
			<tr>
				<th align="center">작성자/조회수</th>
				<td>${board.writer} / ${board.hit}</td>
			</tr>

			<tr>
				<td colspan="2">${board.contents}</td>
			</tr>
		</tbody>
	</table>
	
	<p class="btn_align">
		<input type="button" value="글목록으로 가기" onclick="location.href='list.do'"/>
		<input type="button" value="글수정으로 가기" onclick="location.href='modify.do?no=${board.no}'" />
		<input type="button" value="삭제하기" onclick="location.href='delete.do?no=${board.no}'" />
	</p>
	
</body>
</html>



