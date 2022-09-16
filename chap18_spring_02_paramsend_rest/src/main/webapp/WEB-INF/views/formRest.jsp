<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formRest - @PathVariable 사용 예제</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#btn1").on('click', function(e){
			var name = $('#name').val();
			var grade = $('#grade').val();
			
			$.ajax({
				//url : '${contextPath}/action3.do/name/' + name + "/grade/" + grade,
				url : '${contextPath}/action4.do/name/' + name + "/grade/" + grade,
				type : 'get',
				dataType: 'text',
				success : function(data){
					console.log("data : " + data);
					$('#resultDiv').html(data);
					
					// action4.do 전용 *********************************************************
					//[2] JSON Type으로 반환받는 경우 action4.do
                        var jsonInfo = JSON.parse(data); // Json 문자열 -> 자바스크립트 객체로 변환
                        console.log(jsonInfo); // 자바스크립트 객체 출력
                        
                      //html 생성
                   		var table = "<table border='1'><tr><td>이름</td><td>학년</td></tr>";
                     		table += '<tr>';
                     		table += '<td>' + jsonInfo.name + '</td>';   
                     		table += '<td>' + jsonInfo.grade + '</td>';   
                     		table += "</tr>";
                     		table += "</table>";
                        
                        	$('#resultDiv').html(table);
					// action4.do 전용 *********************************************************
				},
				error : function(xhr, status){
					console.log(xhr + " : " + status);
				}
			});
		});
	});
</script>
</head>
<body>
	이름 :
	<input type="text" id="name" value="${name}" />
	<br> 학년 :
	<input type="text" id="grade" />
	<br>
	<br>
	<input type="button" id="btn1" value="전송1" />
	<br>
	<br>
	<input type="button" id="btn2" value="전송2" />
	<br>
	<br>

	<div id="resultDiv"></div>
</body>
</html>