<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>파일 업로드 홈</title>
</head>
<body>

1. 절대 경로(ex. "c:\\filetest\\upload") : 
      <a href="${pageContext.request.contextPath}/absolutePathForm">
      파일 업로드(절대 경로)</a><br><br>
      
2. 상대 경로(ex. "/webapp/resources/upload/") : 
<a href="${pageContext.request.contextPath}/relativePathForm">파일 업로드(상대 경로)</a>

</body>
</html>