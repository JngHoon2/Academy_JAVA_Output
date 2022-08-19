<%@page import="javabean.Fruit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%> <!--isELIgnored = false" => EL을 사용하겠다. -->
<%@page import="javabean.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
</head>
<body>
	<h3> 3. 컬렉션에 담아서 반복 </h3>
	
	<%
		Map<String, Object> map = new HashMap<String, Object>();
		
		ArrayList<MemberBean> memberList = new ArrayList<MemberBean>();
		
		memberList.add(new MemberBean("dream", "1234", "정만호", "a@c.com"));
		memberList.add(new MemberBean("momo", "4567", "모모", "b@c.com"));
		memberList.add(new MemberBean("goldi", "8520", "골디", "c@c.com"));
		memberList.add(new MemberBean("orang", "4568", "오랑이", "d@c.com"));
		
		map.put("memberList", memberList);
		
		ArrayList<EmpClass> empList = new ArrayList<EmpClass>();
		
		empList.add(new EmpClass(1, "김민종", "Developer", "2020-01-01", 400));
		empList.add(new EmpClass(2, "정수경", "Consultant", "2015-02-17", 700));
		empList.add(new EmpClass(3, "채리나", "SalesMan", "2010-12-30", 900));
		empList.add(new EmpClass(4, "나후나", "Accountant", "2021-05-25", 350));
		
		map.put("empList", empList);
		
		request.setAttribute("map", map);
	%>
	
	<h4>3.2 Map을 통한 반복문</h4>
	<h5>3.2.1 MemberBean 데이터 출력</h5>
	<table border="1">
	
		<thead>
			<tr>
				<th scope="col">no</th>
				<th scope="col">id</th>
				<th scope="col">pwd</th>
				<th scope="col">name</th>
				<th scope="col">email</th>
				
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${map.memberList.size() <= 0}">
					<tr>
						<td colspan="5" align="center" height="23">등록된 회원이 없습니다.</td>
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
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="center" height="23">전체회원수 : ${map.memberList.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<br>
	<h5>3.2.2 EmpClass 데이터 출력</h5>
	<table border="1">
		<thead>
			<tr>
				<th scope="col">no</th>
				<th scope="col">id</th>
				<th scope="col">name</th>
				<th scope="col">job</th>
				<th scope="col">hireDate</th>
				<th scope="col">sal</th>	
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${map.empList.size() <= 0}">
					<tr>
						<td colspan="6" align="center" height="23">등록된 회원이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="emp" items="${map.empList}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.job}</td>
							<td>${emp.hireDate}</td>
							<td>${emp.sal}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" align="center" height="23">전체사원수 : ${map.empList.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>