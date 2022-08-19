<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8"></meta>
<title>게시물 등록 폼</title>

<script type="text/javascript" src='<c:url value="/ckeditor/ckeditor.js" />'></script>

<style type="text/css">
	
	table{
		border-collapse: collapse; 
	}
	table tbody tr th {
		background-color: #bbffdd;
	}
</style>
<script type="text/javascript">
	function goUrl(url) {
		location.href=url;
	}
	// 등록 폼 체크
	function boardWriteCheck() {
		var form = document.boardWriteForm;
		if (form.subject.value == '') {
			alert('제목을 입력하세요.');
			form.subject.focus();
			return false;
		}
		if (form.writer.value == '') {
			alert('작성자를 입력하세요');
			form.writer.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h1 align="center">게시판 등록 폼</h1>
	
	<form name="boardWriteForm" action="<c:url value="/write" />" 
			method="post" onsubmit="return boardWriteCheck();">
		<table border="1" align="center" summary="게시판 등록 폼">
			<!-- <caption>게시판 등록 폼</caption> -->
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>
			<tbody>
				<tr>
					<th align="center">제목</th>
					<td><input type="text" name="title" size="80" maxlength="100" /></td>
				</tr>
				<tr>
					<th align="center">작성자</th>
					<td><input type="text" name="writer" maxlength="20" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="content" cols="80" rows="10">
						</textarea>
						<script>CKEDITOR.replace('content');</script>
					</td>
				</tr>
			</tbody>
		</table>
		<p align="center">
			<input type="button" value="목록" onclick="goUrl('<c:url value="/list" />');" />
			<input type="submit" value="저장하기" />
		</p>
	</form>
</body>
</html>