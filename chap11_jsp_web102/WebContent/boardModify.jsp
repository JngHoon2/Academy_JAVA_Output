<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>게시판 수정 폼</title>

	<style type="text/css">
		* {font-size: 9pt;}
		p {width: 600px; text-align: right;}
		table tbody tr th {background-color: gray;} 
		input  {background-color:lime; }
		input  {color:red; }  
	</style>
	
</head>
<body>
<h3 align="center">게시글 수정 화면</h3>
<hr>

	<form action="modify.do" method="post" >
		<input type="hidden" name="no" value="${board.no}" />
		
		<table border="1" summary="게시글 수정 폼" align="center">
			<caption>게시글 수정 폼</caption>
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>
			<tbody>
				<tr>
					<th align="center">제목</th>
					<td>
					<input type="text" name="subject" size="80" maxlength="100" value="${board.subject}"  /></td>
				</tr>
				<tr>
					<th align="center">작성자</th>
					<td><input type="text" name="writer" maxlength="20" value="${board.writer}" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="contents" cols="80" rows="10">${board.contents}</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		
		<p>
			<input type="button" value="글목록으로 가기" onclick="location.href='list.do'" />
			<input type="submit" value="글수정하기" />
		</p>
	
	</form>
</body>
</html>