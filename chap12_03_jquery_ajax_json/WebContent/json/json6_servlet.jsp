<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 

<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
  
	<style type="text/css">
		.backColor{
			background-color: lightBlue;
		}
	</style>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  	
  	<script type="text/javascript">
  	
	    $(function() {
	    	
			//body 에 배경색 바꾸는 방법 
			$('body').addClass('backColor'); 	    	
	    	
	    	// 클릭 이벤트 핸들러(메소드)
	        $("#checkJson").click(function() {
		        // ajax 호출
		    	$.ajax({
		            type:"post",
		            async:false, 
		            url:"${contextPath}/json2",
		            success:function (data, textStatus){
		            	console.log(data);
		            	// Json 문자열을 자바 객체로 변환(파싱-역직렬화)
						var jsonInfo = JSON.parse(data);	
						console.log(jsonInfo);
						
						var memberInfo ="회원 정보<br>";
						memberInfo += "==========<br>";
						for(var i in jsonInfo.members){
							memberInfo += "이름: " + jsonInfo.members[i].name+"<br>";
							memberInfo += "나이: " + jsonInfo.members[i].age+"<br>";
							memberInfo += "성별: " + jsonInfo.members[i].gender+"<br>";
							memberInfo += "별명: " + jsonInfo.members[i].nickname+"<br><br><br>";
				    	}
					    $("#output").html(memberInfo);
					},
					error:function(data,textStatus){
					   alert("에러가 발생했습니다.");ㅣ
					},
					complete:function(data,textStatus){
					}
			   }); // end ajax
	       }); // end click
	    });	// end $(function()
	</script>
</head>
<body>
   <a href="#" id="checkJson" style="cursor:pointer">회원 정보 수신하기</a><br><br>
    <div id="output"></div>
</body>
</html>