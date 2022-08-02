<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, bean01.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");

	MemberDAO dao = MemberDAO.getInstance();
	ArrayList<MemberBean> memberList = dao.listMembers();
	
	request.setAttribute("memberList", memberList);
	
%>
    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
	<h1 align="center">맴버 목록</h1>
	<table border="1" align="center">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">아이디</th>
				<th scope="col">비밀번호</th>
				<th scope="col">이름</th>
				<th scope="col">이메일</th>		
				<th scope="col">삭제</th>		
				<th scope="col">수정</th>		
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${memberList.size() <= 0}">
					<tr>
						<td colspan="7" align="center" height="23">등록된 맴버가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="member" items="${memberList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${member.id}</td>
							<td>${member.pwd}</td>
							<td>${member.name}</td>
							<td>${member.email}</td>
							<td><a href = "${contextPath}/test06/member_delete.jsp?id=${member.id}">회원삭제</a></td>
							<td><a href = "${contextPath}/test06/memberUpdateForm.jsp?id=${member.id}">정보수정</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="7" align="center" height="23">전체 맴버수 : ${memberList.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<h5 align="center"><a href = "${contextPath}/test06/memberForm.jsp">회원가입</a></h5>
</body>
</html>