<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		/*
		 $(function() {}); <==  $(document).ready(function(){}); 동일한 의미
		  - 모든 Html 요소들이 준비가 되면 화면이 로딩 됨과 동시에 필요한 작업을 구현
		  - 이벤트는 사용자가 이벤트를 발생 시켰을 때 작동작동
		*/
	    $(function() {
	        $("#checkJson").click(function() {
	        var jsonStr  = '{"name": ["홍길동", "이순신", "임꺽정"] }';          
	        var jsonInfo = JSON.parse(jsonStr); // jsonInfo <- object Object
	        var outputDiv ="회원 이름<br>";
	        outputDiv += "=======<br>";
	        for(var i in jsonInfo.name) {
	            outputDiv += jsonInfo.name[i] + "<br>"; // "홍길동", "이순신", "임꺽정"
	        }
	        $("#outputDiv").html(outputDiv);
	      });
	    });        
	</script>
  </head>
  <body>
    <a id="checkJson" style="cursor:pointer">출력</a><br><br>
    <div id="outputDiv"></div>
  </body>
</html>
