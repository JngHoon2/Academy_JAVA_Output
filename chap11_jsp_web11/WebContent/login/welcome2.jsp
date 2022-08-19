<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.javalab.vo.MemberBean"%>

<!DOCTYPE html>
<html>
<head>
<title>Simple LogIn</title>
</head>
<body  topmargin="100">
	<table width="75%" border="1" align="center"  cellspacing="1" >
		<tr >
			<td height="190" colspan="7">
				<table width="50%" border="1" align="center" cellspacing="0"
					cellpadding="0">
					<tr>
						<td colspan="2"><div align="center">Welcome</div></td>
					</tr>
					<tr>
						<td>
							<div align="center">
								<strong>${member.name}(${member.id})님</strong> 님이 로그인 하셨습니다.
							</div>
						</td>
						<td>
							<div align="center">
								<a href="${pageContext.request.contextPath}/logout"><strong>로그아웃</strong></a>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>