<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
  <title>JSON ajax 연습</title>
   	<style type="text/css">
		.backColor{
			background-color: lightBlue;
		}
	</style>  
  	<!-- jquery 사용을 위한 CDN(jquery 재단에서 제공하는 jquery 라이브러리 사용 -->
	 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	  
	 <script type="text/javascript">
	    /* $(document).ready(function() {	 와 같은 의미임 */
	 	$(function() {	 	
	 		
	 		//body 에 배경색 바꾸는 방법 
			$('body').addClass('backColor');
	 		
	 		// sendBtn의 onclick 이벤트 처리기(리스너, 핸들러)
	        $("#sendBtn").on('click', function() {

	        	var name = $('#name').val();		// 이름
	    		var age = $('#age').val();			// 나이
	    		var gender = $('#gender').val();	// 성별
	    		var nickname = $('#nickname').val();// 닉네임
	    		//alert(name + age + gender + nickname);	// 입력값 확인
	    		
	    		// 자바스크립트 객체 생성해서 form 태그의 값들 저장
	    		// 선수 1번
	    		var scriptObj = new Object(); 		
	    		scriptObj.name = name;				// 객체의 name 속성을 만들고 값 저장
	    		scriptObj.age = age;				// 객체의 age 속성을 만들고 값 저장
	    		scriptObj.gender = gender;			// 객체의 gender 속성을 만들고 값 저장
	    		scriptObj.nickname = nickname;		// 객체의 nickname 속성을 만들고 값 저장

	        	var name2 = $('#name2').val();				// 이름
	    		var age2 = $('#age2').val();				// 나이
	    		var gender2 = $('#gender2').val();			// 성별
	    		var nickname2 = $('#nickname2').val();		// 닉네임
	    		//alert(name2 + age2 + gender2 + nickname2);// 입력값 확인
	    		
	    		// 자바스크립트 객체 생성해서 form 태그의 값들 저장
	    		// 선수 2번
	    		var scriptObj2 = new Object(); 		
	    		scriptObj2.name = name2;				// 객체의 name2 속성을 만들고 값 저장
	    		scriptObj2.age = age2;					// 객체의 age2 속성을 만들고 값 저장
	    		scriptObj2.gender = gender2;			// 객체의 gender2 속성을 만들고 값 저장
	    		scriptObj2.nickname = nickname2;		// 객체의 nickname2 속성을 만들고 값 저장
	    		
	    		// 자바스크립트 객체를 담을 자바스크립트 배열 선언
	    		var arrStars = new Array();
	    		arrStars.push(scriptObj);	// 배열에 객체 추가
	    		arrStars.push(scriptObj2);	// 배열에 객체 추가
	    		
	    		// 자바스크립트 객체를 json 형태의 문자열로 변환({"키" : "값"})
	    		var jsonStarInfo = JSON.stringify(arrStars); 
	    		
	    		console.log(arrStars);
	    		console.log(jsonStarInfo);
	    	   	
	    	   	// ajax 함수를 통해서 서버에 전송
	    	   	$.ajax({
					type:"post",
					async:false,
					url:"${contextPath}/starList",
					data : { jsonStar: jsonStarInfo},	// 서버로 보낼 데이터
					dataType : "json",	// 서버로부터 받을 데이터 타입
					success:function (data, textStatus){
		
						console.log(data); // 서버에서 온 값 검증
						
						$('#output').empty();
		 				
		       			//table 변수에 제목 부분 만들어서 보관
		    			var table = "<table border='1'><tr><td>순번</td><td>이름</td><td>나이</td><td>성별</td><td>별명</td></tr>";
		    			
						$.each(data, function(index){
							table += '<tr>';
							table += '<td>' + (index + 1) + '</td>';	
							table += '<td>' + data[index].name + '</td>';	
							table += '<td>' + data[index].age + '</td>';	
							table += '<td>' + data[index].gender + '</td>';	
							table += '<td>' + data[index].nickname + '</td>';	
							table += "</tr>";
						});
						table += "</table>";
		   				$('#output').append(table);
		   				
			     	}, // 처리결과 실패시 호출되는 콜백 함수
			     	error:function(data,textStatus){
			        	alert("에러가 발생했습니다.");ㅣ
			     	},
			     	complete:function(data,textStatus){
			     		//success 콜백 호출후에 호출되는 콜백함수
			     	}
				});  //end ajax		
			});	// end onclick				
		});	// end $(function() {
	 </script>
	 
</head>
<body>
	<form action="" method="post">
		이름 : <input type="text" name="name" id="name" value="손흥민"/><br>
		나이 : <input type="number" name="age"  id="age" value="31"/><br>
		성별 : <input type="text" name="gender"  id="gender" value="남" /><br>
		별명 : <input type="text" name="nickname"  id="nickname"  value="써니"/>
		<br><br>
		이름 : <input type="text" name="name2" id="name2" value="황희찬"/><br>
		나이 : <input type="number" name="age2"  id="age2" value="27"/><br>
		성별 : <input type="text" name="gender2"  id="gender2" value="남" /><br>
		별명 : <input type="text" name="nickname2"  id="nickname2"  value="황소"/>
		<br><br>

		<input type="button" id="sendBtn" value="전송하기"  /><br><br>
		
	</form>

    <div id="output"></div>
    
</body>
</html>