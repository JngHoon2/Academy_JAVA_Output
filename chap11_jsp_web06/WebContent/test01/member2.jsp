<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<h2 style="text-align: center">member2 화면</h2>
	<h4 style="text-align: center">
	MemberForm.jsp에서 입력한 input Element 값들을<br>
	두 단계 건너 뛴 화면에서 \${param.id} 형태로 추출 가능<br>
	(같은 request 영역이므로)</h4>
	<table border="1" align="center">
		<thead>
			<tr align="center" bgcolor="99ccff">
				<th width="20%"><b>아이디</b></th>
				<th width="20%"><b>비밀번호</b></th>
				<th width="20%"><b>이름</b></th>
				<th width="20%"><b>이메일</b></th>
		</thead>
		<tbody>
			<tr align="center">
				<td>${param.id}</td>
				<td>${param.pwd}</td>
				<td>${param.name}</td>
				<td>${param.email}</td>
		</tbody>
	</table>
	
	<h4 style="text-align: center">
	바로 전 forward2 화면에서 request.setAttribute("member") 형태로 저장한 값을<br>
	곧바로 추출해서 \${member.id} 형태로 출력 가능!</h4>
	<table border="1" align="center">
		<thead>
			<tr align="center" bgcolor="99ccff">
				<th width="20%"><b>아이디</b></th>
				<th width="20%"><b>비밀번호</b></th>
				<th width="20%"><b>이름</b></th>
				<th width="20%"><b>이메일</b></th>
		</thead>
		<tbody>
			<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
		</tbody>
	</table>
</body>
</html>