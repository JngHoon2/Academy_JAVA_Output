<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>

<%
	//Product product =  (Product)request.getAttribute("product");
	//String[] arr_picture = product.getPicture().split(","); //arr_picture 를 session객체에 담아서 사용할것.
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>상품 등록화면 : productInsert.jsp</title>
	<link rel="stylesheet" type="text/css" href="css/shopping.css" />
	<script type="text/javascript" src="script/product.js" ></script>
</head>

<body>
<div id="wrap" align="center">
	<h1>상품 상세 화면 - 관리자 페이지</h1>
	<table border="1" summary="상품 상세조회">
		<input type="hidden" name="code" value="${product.getCode()}" />
		<caption>상품 정보 보기</caption>
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		<tbody>
			<tr>
				<th align="center">상품명</th>
				<td><c:out value="${product.getName()}" /></td>
			</tr>
			<tr>
				<th align="center">원가</th>
				<td><fmt:formatNumber value="${product.cost_price }" pattern="#,###"/></td>
			</tr>
			<tr>
				<th align="center">정가</th>
				<td><fmt:formatNumber value="${product.list_price }" pattern="#,###"/></td>
			</tr>

			<tr>
				<th align="center">사진</th>
				<td>
					<c:choose>
						<c:when test="${product.image eq 'noImage.jpg'}">
							<img src="<c:out value="images/noImage.jpg" />">
						</c:when>
						<c:otherwise>
							<img src="<c:out value="upload/${product.image}" />">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>

			<tr>
				<th>상품 설명</th>
				<td colspan="2"><c:out value="${product.content}" /></td>
			</tr>
			<tr>
				<th>사용 유무</th>
				<!-- <td colspan="2"><c:out value="${product.useyn}" /></td> -->
				<td colspan="2">
					<select id="useyn" title="사용유무" >
					    <option value="1" <c:if test="${product.useyn eq '1'}">selected</c:if>>사용</option>
					    <option value="0" <c:if test="${product.useyn eq '0'}">selected</c:if>>미사용</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>인기상품 유무</th>
				<td colspan="2">
					<select id="useyn" title="사용유무" >
					    <option value="1" <c:if test="${product.bestyn eq '1'}">selected</c:if>>사용</option>
					    <option value="0" <c:if test="${product.bestyn eq '0'}">selected</c:if>>미사용</option>
					</select>
				</td>
			</tr>
		</tbody>
	</table>  
	
	<p class="btn_align">
		<input type="button" value="상품목록" onclick="location.href='productList.do'" />
		<input type="button" value="글수정으로 가기" onclick="location.href='productModify.do?code=${product.getCode()}'" />
		<input type="button" value="삭제하기" onclick="location.href='productDelete.do?code=${product.getCode()}'" />
	</p>
</div>	
</body>
</html>