/**
 * 
 */
		$(document).ready(function(){
			
			//Ajax 이 기종 언어 간의 데이터 송수신 기법(Javascript <-> jsp)
			//아래 버튼을 클랙했을 때 ajaxResult.jsp 를 호출
			//이 때 ajax() 함수를 사용하여 전송방식을 설정....
			$('#ajaxCall').click(function(){
				var request = $.ajax({		//ajax() 함수 호출
					url : "ajaxResult.jsp",	//Url
					method : "POST",		//보내는 방식
					data : {paramNum : 1},	//전송할 파라미터(없으면 생략가능)
					dataType : "json"		//응답 Type => application/json : json || text/plain:text || text/html : html || text/xml : xml(응답데이터 없으면 생략가능)
				});
				
				//성공시 콜백함수 자동호출
				request.done(function(data){	//json 데이터가 파라미터(data)로 들어감
					console.log(data)			//웹브라우저 개발자도구 콘솔창에 표시됨
					
					//javascript Object형태로 들어가기 때문에 꺼낼 때도 Object형태로 변환
					console.log(data.param1)
					console.log(data.param2)
					
				});
				
				//실패시 콜백함수 자동호출
				request.fail(function(jqXHR, textStatus) {	//파라미터 두 개는 자유명칭(실패한 메시지는 두 번째 파라미터를 통해 전달됨.)
					alert( "Request failed : " + textStatus );
					
				});
				
			});
		});