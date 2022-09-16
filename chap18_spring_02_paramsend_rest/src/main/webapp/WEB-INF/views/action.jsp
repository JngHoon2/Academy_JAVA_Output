<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c ;set var="contextPath" value="${pageContext.request.contextPath }" />

<html>
<head>
<meta charset="UTF-8">
<title>Home(화면에서 파타미터 전송)</title>
</head>
<body>
	<h3>1. 컨트롤러에서 Model 개별적으로 저장한 값 추출</h3>
	id : ${id}
	<br> pwd : ${pwd}
	<br> name : ${name}
	<br> age : ${age}
	<br>

	<h3>2. 컨트롤러에서 커맨드 객체로 받아서 사용(MemberVo member)</h3>
	<h4>컨트롤러 메소드의 파라미터로 선언한 memberVo에서 앞자를 소문자로 변환해서 memberVo사용</h4>
	<h4>별다른 설정을 하지 않아도 객체 타입은 자동으로 jsp화면으로 전달됨.</h4>
	<h4>기본현(int, long etc)등은 기본적으로 전달되지 않음.</h4>
	<h4>기본형을 별다른 설정 없이 전달하기 위해서는 @ModelAttribute("..")사용</h4>

	memberVo.id : ${memberVo.id}
	<br> memberVo.pwd : ${memberVo.pwd}
	<br> memberVo.name : ${memberVo.name}
	<br> memberVo.age : ${memberVo.age}
	<br> mem.id : ${mem.id}
	<br> mem.pwd : ${mem.pwd}
	<br> mem.name : ${mem.name}
	<br> mem.age : ${mem.age}
	<br>

	<h3>3. 컨트롤러에서 ArrayList 타입의 객체를 받아서 사용</h3>
	<div>
		<table border="1">
			<colgroup>
				<col width="100" />
				<col width="200" />
				<col width="200" />
			</colgroup>
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>

				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${memberList.size() <= 0}">
						<tr>
							<td align="center" colspan="5">넘어온 사용자 정보가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="member" items="${memberList}" varStatus="i">
							<tr>
								<td><c:out value="${member.id}" /></td>
								<td align="center"><c:out value="${member.pwd}" /></td>
								<td align="center"><c:out value="${member.name}" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

	<h3>4. 컨트롤러에서 Map 타입의 객체를 받아서 사용</h3>
	<div>
		<table border="1">
			<colgroup>
				<col width="100" />
				<col width="200" />
				<col width="200" />
			</colgroup>
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>

				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${memberMap.memberList.size() <= 0}">
						<tr>
							<td align="center" colspan="5">넘어온 사용자 정보가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="member" items="${memberMap.memberList}"
							varStatus="i">
							<tr>
								<td><c:out value="${member.id}" /></td>
								<td align="center"><c:out value="${member.pwd}" /></td>
								<td align="center"><c:out value="${member.name}" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

	<h3>5 @RequestBody requestBodyStr</h3>
	requestBodyStr: ${requestBodyStr}

	<h3>6 기본형 타입 인자를 받고 싶을때</h3>
	age : ${age}
</body>
</html>
