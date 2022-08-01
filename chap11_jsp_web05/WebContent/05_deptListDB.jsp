<%@page import="javabean.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%> <!--isELIgnored = false" => EL을 사용하겠다. -->
<%@page import="javabean.*"%>
<%@page import="javabean.dao.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	MemberDAO dao = MemberDAO.getInstance();
	Map<String, Object> map = new HashMap<String, Object>();

	ArrayList<Dept> deptList = dao.deptList();
	map.put("deptList", deptList);
	
	ArrayList<EmpClass> empList = dao.empList();
	map.put("empList", empList);
	
	ArrayList<MemberBean> memberList = dao.memberList();
	map.put("memberList", memberList);
	
	request.setAttribute("map", map);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 조회</title>
</head>
<body>
	<h3>부서 목록 조회</h3>
	<table border="1">
		<thead>
			<tr>
				<th scope="col">no</th>
				<th scope="col">deptno</th>
				<th scope="col">dname</th>
				<th scope="col">loc</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${map.deptList.size() <= 0}">
					<tr>
						<td colspan="3" align="center" height="23">등록된 부서가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="dept" items="${map.deptList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${dept.deptno}</td>
							<td>${dept.dname}</td>
							<td>${dept.loc}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4" align="center" height="23">전체부서수 : ${map.deptList.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<br>
	<h3>맴버 목록 조회</h3>
	<table border="1">
		<thead>
			<tr>
				<th scope="col">no</th>
				<th scope="col">empno</th>
				<th scope="col">ename</th>
				<th scope="col">job</th>
				<th scope="col">mgr</th>
				<th scope="col">hireDate</th>
				<th scope="col">sal</th>
				<th scope="col">comm</th>
				<th scope="col">deptno</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${map.empList.size() <= 0}">
					<tr>
						<td colspan="9" align="center" height="23">등록된 직원이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="emp" items="${map.empList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.job}</td>
							<td>${emp.mgr}</td>
							<td>${emp.hireDate}</td>
							<td>${emp.sal}</td>
							<td>${emp.comm}</td>
							<td>${emp.deptno}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="9" align="center" height="23">전체사원수 : ${map.empList.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<br>
	<h3>맴버 목록 조회</h3>
	<table border="1">
		<thead>
			<tr>
				<th scope="col">no</th>
				<th scope="col">id</th>
				<th scope="col">pwd</th>
				<th scope="col">name</th>
				<th scope="col">email</th>
				<th scope="col">joinDate</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${map.memberList.size() <= 0}">
					<tr>
						<td colspan="6" align="center" height="23">등록된 맴버가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="member" items="${map.memberList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${member.id}</td>
							<td>${member.pwd}</td>
							<td>${member.name}</td>
							<td>${member.email}</td>
							<td>${member.joinDate}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" align="center" height="23">전체맴버수 : ${map.memberList.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>