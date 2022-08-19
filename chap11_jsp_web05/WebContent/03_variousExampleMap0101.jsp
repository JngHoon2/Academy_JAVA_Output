<%@page import="javabean.Fruit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%> <!--isELIgnored = false" => EL을 사용하겠다. -->
<%@page import="javabean.MemberBean"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 3. 컬렉션에 담아서 반복 </h3>
	
	<%
		Map<Integer, Fruit> hm = new HashMap<>();
		hm.put(1, new Fruit("사과", 2000));
		hm.put(2, new Fruit("포도", 3000));
		hm.put(3, new Fruit("배", 5000));
		
		request.setAttribute("map", hm);
	%>
	
	<h4>3.2 Map을 통한 반복문</h4>
	<h5>3.2.1 MemberBean 데이터 출력</h5>
	<table border="7">
	
		<thead>
			<tr>
				<th scope="col">no</th>
				<th scope="col">key</th>
				<th scope="col">name</th>
				<th scope="col">price</th>
				
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${map.size() <= 0}">
					<tr>
						<td colspan="3" align="center" height="23">등록된 과일이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="fruit" items="${map}" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td>${fruit.key}</td>
							<td>${fruit.value.name}</td>
							<td>${fruit.value.price}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="center" height="23">전체 과일수 : ${map.size()}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>