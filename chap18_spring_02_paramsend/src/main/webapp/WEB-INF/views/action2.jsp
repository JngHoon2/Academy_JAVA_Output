[action2.jsp]

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<title>return void example</title>
</head>
<body>
<h3>1. 컨트롤러에서 @ModelAttribute 어노테이션으로 커멘드 객체의 이름(mem)을 바꿔서 전달함</h3>
<h3>   커멘드 객체로 선언하면 model에 담지 않아도 자동으로 전달됨.</h3>
mem.id : ${mem.id}<br>
mem.pwd : ${mem.pwd}<br>
mem.name : ${mem.name}<br>
mem.age : ${mem.age}<br><br>

<h3>2. 컨트롤러에서 model에 값을 넣어서 전달함(일반적인 형태 "member") </h3>

member.id : ${member.id}<br>
member.pwd : ${member.pwd}<br>
member.name : ${member.name}<br>
member.age : ${member.age}<br>
</body>
</html>