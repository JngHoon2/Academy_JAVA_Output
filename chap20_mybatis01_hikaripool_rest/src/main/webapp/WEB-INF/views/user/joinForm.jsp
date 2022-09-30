<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

     <style type="text/css">
      .backColor{
         background-color: lightBlue;
      }
      #login_error{
         color : red;
         text-align: center;
      }
   </style>   

   <!-- jQuery CDN 포털사이트에서 제공하는 jquery 함수 사용 -->
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   

  <script type="text/javascript">
   
      $(document).ready(function(){
         //body 에 배경색 바꾸는 방법 
      $('body').addClass('backColor');   

      //아이디 중복 체크 리스너(핸들러)
      $("#id").on('change', function() {
         // 아이디 널 체크
         let join_id = $('#id').val();
         if(join_id == "" || join_id == null || join_id == undefined || join_id.length < 1 ){
            alert('아이디를 입력하세요.');
            $("#id").focus();
            return false;
         }
         $.ajax({
            url : '${contextPath}/join/idCheck.do',
            type : 'GET',
            data: {id: join_id},
            success : function(data) {
               console.log(data);      
               if (data == 1) {          // 0 - 아이디 중복
                     $("#id_check").text("이미 사용중인 아이디입니다.");
                     $("#id_check").css("color", "red");
                     $('#id').focus();
                     return false;
               } else if(data == 0) {      //1 - 중복아니므로 아이디 적합성 검사 
                  $('#id_check').text('');
                  if(join_id < 0){   // 문자열 길이 검사
                     $('#id_check').text("아이디는 영문 또는 영문 숫자 1~12자리 입력하세요.");
                     $('#id_check').css('color', 'red');
                     $('#id').focus();
                     return false;
                  }

                  $('#id_check').text('적합한 아이디입니다.');
                  $('#id_check').css('color', 'blue');
               }
            }, 
            error : function() {
               console.log("중복 체크 실패");
            }
         });   // ajax
      });  // 아이디 중복 체크   
                  
       // 비밀번호 + 비밀번호 확인 체크
       $("#pwdConfirm").blur(function() {
          $("#error_pwd_confirm").text("");
          if($("input[name=pwd]").val() != $("input[name=pwdConfirm]").val()){ 
                $("#error_pwd_confirm").text("비밀번호가 일치하지 않습니다.");
              $("#error_pwd_confirm").css("color", "red");
                return false;
         }
         $('#error_pwd_confirm').text('비밀번호가 동일합니다.');
         $('#error_pwd_confirm').css('color', 'blue');
       });   // 비밀번호 확인
          
          
   }); // ready()  
      
      // 자바스크립트에서 컨텍스트 경로 가져오는 방법
      function getContextPath() {
          return window.location.pathname
                .substring(0, window.location.pathname.indexOf("/",2));
      }
   </script>
</head>
<body>
   <form name="frmLogin" id="frmLogin" method="post" action="${contextPath}/join/join.do">
      <h1 style="text-align: center">회원가입</h1>
      <table align="center" border="0">
         <tr>
            <td width="200"><p align="right">아이디</td>
            <td width="400"><input type="text" name="id" id="id" value = "${user.id}">
               <span class="check_font" id="id_check"></span>
            </td>            
         </tr>
         <c:if test="${loginErrMsg}">
            <tr id="loginError">
               <td colspan="2">
                  <p id="login_error">아이디가 존재합니다.(미사용)</p>
               </td>
            </tr>
         </c:if>         
         <tr>
            <td width="200"><p align="right">비밀번호</td>
            <td width="400"><input type="password" name="pwd" id="pwd" value = "${user.pwd}"></td>
         </tr>
      <tr>
         <td width="200"><p align="right">비밀번호 확인</td>
         <td width="400"><input type="password" name="pwdConfirm" id="pwdConfirm" >
            <span class="check_font" id="error_pwd_confirm"></span>
         </td>
      </tr>         
         <tr>
            <td width="200"><p align="right">이름</td>
            <td width="400"><input type="text" name="name" id="name" value = "${user.name}"></td>
         </tr>
         <tr>
            <td width="200"><p align="right">이메일</td>
            <td width="400"><input type="email" name="email" id="email" value = "${user.email}"></td>
         </tr>
         <tr>
            <td width="200"><p align="right">관리자</td>
            <td width="400">               
               <select class="form-control" name="roleId" id="roleId" >
               <c:forEach var="role" items="${roleList}">
                  <option value="${role.roleId }">${role.roleName }</option>
               </c:forEach>   
            </select>
         </td>
         </tr>
         <tr>
            <td width="200"><p>&nbsp;</p></td>
            <td width="400">
               <input type="submit" id="btnJoin" value="회원가입">
               <input type="reset" value="다시입력">
            </td>
         </tr>
      </table>
   </form>

</body>
</html>