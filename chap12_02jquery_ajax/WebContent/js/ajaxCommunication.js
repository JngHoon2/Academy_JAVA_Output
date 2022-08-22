$(document).ready(function(){
    $('#ajaxConGetButton').click(function(){
        AjaxConGet();
    })
    
    $('#ajaxConPostButton').click(function(){
        AjaxConPost();
    })
    
})
 
function AjaxConGet(){
    var url = "http://localhost:8080/test/ajaxCon";
    $.ajax({
        type:"GET",
        url:url,
        dataType:"html",
        data:{
            name : $('#ajaxConName').val(),
            age : $('#ajaxConAge').val()
        },
        success : function(data){
            alert('ajax GET 통신 성공');
            var $div = $('<div></div>');
            var text = document.createTextNode(data);
            $div.append(data);
            $div.appendTo($('#myDiv'))
        
        },
        error : function(request,status,error){
            alert('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error); //에러 상태에 대한 세부사항 출력
            alert(e);
        }
    })
    
}
 
function AjaxConPost(){
    var url = "http://localhost:8080/test/ajaxCon";
    $.ajax({
        type:"POST",
        url:url,
        dataType:"html",
        data:{
            name : $('#ajaxConName').val(),
            age : $('#ajaxConAge').val()
        },
        success : function(data){
            alert('ajax POST 통신 성공');
            var $div = $('<div></div>');
            var text = document.createTextNode(data);
            $div.append(data);
            $div.appendTo($('#myDiv'))
        },
        error : function(request,status,error){
            alert('code:'+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error); //에러 상태에 대한 세부사항 출력
            alert(e);
        }
    })
    
}
