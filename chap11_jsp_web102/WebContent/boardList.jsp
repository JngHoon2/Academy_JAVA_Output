<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
	<title>게시판 목록</title>

	<style type="text/css">
		* {font-size: 9pt;}
		p {width: 600px; text-align: right;}
		table thead tr th {background-color: gray;}
	</style>
</head>

<body>
<h3 align="center">게시판 목록 화면</h3>
<hr>
	<table border="1" summary="게시판 목록" align = "center">
		<caption>게시판 목록</caption>
		<colgroup>
			<col width="50" />
			<col width="300" />
			<col width="80" />
			<col width="70" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${boardList.size() == 0}">
					<tr>
						<td align="center" colspan="5">등록된 게시물이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:set var="num" value="${totalCount - ((pageNum - 1) * 10) }" ></c:set>				
					<c:forEach var="board" items="${boardList}" varStatus="i">
						<tr>
							<td align="center">
								<c:out value="${i.count}" />
							</td>
							<td align="center">
								<a href="<c:url value='/view.do?no=${board.no}' />">
									<c:out value="${board.subject}" />
									</a>
							</td>								
							<td align="center">
								<c:out value="${board.writer}" />
							</td>
						<td align="center">
								<c:out value="${board.hit}" />
							</td>								
						</tr>
					</c:forEach>
					<tr>
						<td align="center" colspan="9">${page_navigator }</td>
					</tr>
				</c:otherwise>
			</c:choose>			
		</tbody>			
		<tfoot>
			<tr>
				<td align="center" colspan="4">Copyright ⓒ javalab Corp. All Rights Reserved</td>
			</tr>
		</tfoot>
	</table>
	
	<p>
		<input type="button" value="글쓰기"  onclick="location.href='write.do'" />
	</p>
</body>
</html>