<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int multiply(int a, int b){
		int c = a  * b;
		return c;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>request 예제</h3>
	
	1. 클라이언트의 IP : <%= request.getRemoteAddr() %> <br>
	2. 클라이언트 요청 정보의 인코딩 값  : <%= request.getCharacterEncoding() %> <br>
	3. 클라이언트의 전송방식(get/post) : <%= request.getMethod() %> <br>
	4. contextPath(경로) : <%= request.getContextPath() %> <br>
	
</body>
</html>