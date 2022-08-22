/**
 * 
 */

	$(document).ready(function(){
		
		$('#idCheckBtn').click(function(){
			
		var id = $('#memberId').val();
		alert("id : " + id);
			
			var request = $.ajax({		//ajax() 함수 호출
				url : "ajaxCallTest.jsp",	//Url
				method : "POST",		//보내는 방식
				data : {paramId : id},	//전송할 파라미터(없으면 생략가능)
				dataType : "json"		//응답 Type => application/json : json || text/plain:text || text/html : html || text/xml : xml(응답데이터 없으면 생략가능)
			});
				
			request.done(function(data){
				console.log(data)
				var result = data.result;
				
				if(result == '0'){
					alert('사용가능한 아이디입니다.');
				}else{
					alert('중복된 아이디입니다.');
				}
			});
			
			request.fail(function(qjFp, textStatus){
				alert('아이디를 확인하세요.' + textStatus);
			});
		});	
	});	
