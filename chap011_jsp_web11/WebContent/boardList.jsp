<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.javalab.vo.*, com.javalab.dao.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<jsp:useBean id="memberBean" class="com.javalab.vo.BoardVO"/>    

<%
	//한글 인코딩 처리
	request.setCharacterEncoding("utf-8");

	/* 이 부분은 서블릿 쪽에서 데이터를 만들어서 현재 jsp페이지로 전달해주는 것과 같은 매커니즘 */
	ArrayList<BoardVO> boardList = (ArrayList<BoardVO>) request.getAttribute("boardList");
	
	// 아래와 같이 request 객체에 넣어줘야 현재 페이지에서 사용할 수 있음.
	request.setAttribute("boardList", boardList);
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
	<h1 align="center">게시물 목록</h1>
	<table border=1 align="center">
		<thead>
			<tr align="center" bgcolor="#bbffdd">
				<td width="10%" height="50px"><b>번호</b></td>
				<td width="10%" height="50px"><b>제목</b></td>
				<td width="10%" height="50px"><b>작성자</b></td>
				<td width="10%" height="50px"><b>작성일</b></td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${boardList.size() > 0 }">
					<c:forEach var="board" items="${boardList}">
						<tr align="center">
							<td width="10%" height="50px">${board.getNo()}</td>
							<td width="40%" height="50px">
								<form action="${contextPath}/view" method="post">
									<input type="hidden" name="no" value="${board.getNo()}">
									<input type="hidden" name="title" value="${board.title}">
									<input type="hidden" name="content" value="${board.content}">
									<input type="hidden" name="writer" value="${board.writer}">
									<input style="border: none; background: none; color: blue" type="submit" value="${board.title}">
								</form>
							</td>
							<td width="20%" height="50px">${board.writer}</td>
							<td width="30%" height="50px">${board.regdate}</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
	<p align="center">
		<a href="boardWrite.jsp"><input type="button" value="게시물 작성"/></a>
	</p>
	
</body>
</html>