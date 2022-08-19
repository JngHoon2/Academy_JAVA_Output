<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%> <!--isELIgnored = false" => EL을 사용하겠다. -->
<%@page import="javabean.MemberBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	/* 이 부분은 서블릿 쪽에서 데이터를 만들어서 현재 jsp페이지로 전달해주는 것과 같은 매커니즘 */
	ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
	memberList.add(new MemberBean("dream", "1234", "정만호", "a@c.com"));
	memberList.add(new MemberBean("momo", "4567", "모모", "b@c.com"));
	memberList.add(new MemberBean("goldi", "8520", "골디", "c@c.com"));
	memberList.add(new MemberBean("orang", "4568", "오랑이", "d@c.com"));
	
	// 아래와 같이 request 객체에 넣어줘야 현재 페이지에서 사용할 수 있음.
	//request.setAttribute("memberList", memberList);
%>


<!DOCTYPE html>
<html>
<head>
<title>JSTL: Expression Language Support -- Set Example</title>
</head>
<body bgcolor="#FFFFFF">

	<h3>jstl을 이용한 회원 목록 출력 예시</h3>

	<c:set var="list" value="<%= memberList %>"></c:set>
	<%-- <c:set var="list" value="${memberList} }"></c:set> --%>

	<table border="1">
		<thead>
			<tr>
				<th scope="col">아이디</th>
				<th scope="col">비밀번호</th>
				<th scope="col">이름</th>
				<th scope="col">이메일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${list.size() <= 0}">
					<tr>
						<td colspan="4" align="center" height="23">회원이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="member" items="${list}">
						<tr>
							<td>${member.id}</td>
							<td>${member.pwd}</td>
							<td>${member.name}</td>
							<td>${member.email}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4" align="center" height="23">전체회원수 :
							${list.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>