<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(function(){
			$("#checkJson").click(function(){
				 var jsonStr = '{"members":[{"name":"박지성","age":"25","gender":"남자","nickname":"날센돌이","income":"25"}'
	    	           +', {"name":"손흥민","age":"30","gender":"남자","nickname":"탱크","income":"33"}] }';
				 var jsonInfo = JSON.parse(jsonStr);
				 console.log(jsonInfo.members);
				 
				 var output = "회원 정보(객체)<br>";
				 strTemp += "===============<br>";
				 
				 var strTemp = ""; 
				 strTemp += "<table border = '1'>";
				 strTemp += "<tr><td>순번</td><td>이름</td><td>나이</td><td>성별</td><td>별명</td><td>월급</td></tr>";
				 
				 var sumIncome = 0;
				 $.each(jsonInfo.members, function(index, item){
					strTemp += "<tr>";
					strTemp += "<td>" + (index + 1) + "</td><td>" + item.name + "</td><td>" + item.age + "</td><td>" + item.gender + "</td><td>"
						+ item.nickname + "</td><td>" + item.income + "</td>";
					strTemp += "<tr>";
					sumIncome += item.income;
				 });
				 
				 strTemp += "</table>";
				 strTemp += "<br> 연봉합계 : " + sumIncome + "원";
					
				 $("#output").html(strTemp);
			});
		});
	</script>
<body>
	<a href="#" id = "checkJson" style="cursor:pointer">회원 객체 출력</a><br><br>
	<div id = "output"></</div>
</body>
</html>