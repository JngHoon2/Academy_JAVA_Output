<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 등록</title>
</head>
<body>
	<form action="productInsert.do" method="post">
		<table border="1" summary="상품 등록 폼">
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>	
			<tbody>
				<tr>
					<th align="center">상품명</th>
					<td><input type="text" name="name" size=80 maxlength="100" required="required" /></td>
				</tr>
				<!-- 
				<tr>
					<th align="center">가격</th>
					<td><input type="text" pattern="[0-9]{5,16}" name="price" maxlength="20" required="required" placeholder="숫자를 입력하세요." /></td>
				</tr>
				<tr>
					<th align="center">사진</th>
					<td>
						<input type="file" name="picture" values="a.jpb"/>
						<!-- <input type="file" name="picture" values="b.jpb"/>
						<input type="file" name="picture" values="c.jpb"/> 
					</td>
				</tr>
				-->	
				<tr>
					<th align="center">원가</th>
					<td><input type="text" name="cost_price" size="80" 
						value="<fmt:formatNumber value="${product.cost_price }" pattern="#,###"/>" required />
					</td>
				</tr>
				<tr>
					<th align="center">정가</th>
					<td><input type="text" name="list_price" size="80" 
						value="<fmt:formatNumber value="${product.list_price }" pattern="#,###"/>" required />
					</td>
				</tr>
							
				<tr>
					<th align="center">설명</th>
					<td><textarea name="description" rows="5" cols="100" required="required"></textarea></td>
				</tr>
			</tbody>
		</table>
		<p>
			<input type="submit" value="저장" />
			<input type="button" value="목록" onclick="location.href='productList'" />
		</p>
	</form>

</body>
</html>