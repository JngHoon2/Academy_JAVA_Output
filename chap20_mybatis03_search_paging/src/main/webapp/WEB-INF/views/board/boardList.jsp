<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
   
   <!-- 부트스트랩 -->
   <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src='<c:url value="/resources/jquery/jquery.min.js"/>' type="text/javascript"></script>
   <script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
   
   <style type="text/css">
      * {
         font-size: 12px;
      }
      a {
        text-decoration: none;   /* a tag 태그 밑줄 제거 */
      }      
      p {
         width: 600px;
         text-align: right;
      }
      table{
         width: 100%;
         border: 1px solid;
         border-collapse: collapse;  /* 테이블 border 한줄로 나오게 */
         padding : 5px; 
      }      
      table, th, td {
        padding: 10px;
        text-align: left;
      }
      th, td {
        border-bottom: 1px solid #ddd;
      }
      table thead tr th {
         background-color: #05bcac;
      }
      tr:hover {
         background-color: #dce7e6;
      }
   </style>
   
   <!-- 자바스크립트 -->
   
   
</head>
<body>
   <h1 style="text-align:center;">게시물 목록</h1>
   <div style="text-align: right;">
      <c:if test="${not empty user.id}" >
         <strong>${user.name}(${user.id})님</strong>
         <a href="${pageContext.request.contextPath}/login/logout.do"><strong>로그아웃</strong></a>
      </c:if>
      <c:if test="${empty user.id}" >
         <a href="${pageContext.request.contextPath}/login/login.do"><strong>로그인</strong></a>
      </c:if>
   </div>
   <div style="text-align: center; margin-bottom:5px;">
      <form id="searchForm" action="<c:url value="/board/boardList.do" />" method="get">
          제목/내용 : 
         <input type="text" name="searchText" id="searchText" value="${pageMaker.cri.searchText }"/>
         <input type="button" id="btnSearch" value="검색" />
         <input type="button" onclick="location.href='<c:url value="/board/boardList.do" />'" value="전체보기" />
         <input type="button" value="게시물 작성" onclick="location.href='<c:url value="/board/boardWrite.do" />'" />
      </form>   
   </div>
   <div>
      <table>
         <colgroup>
            <col width="50" />
            <col width="200" />
            <col width="200" />
            <col width="200" />
            <col width="200" />
         </colgroup>
         <thead>
            <tr>
               <th>번호</th>
               <th>제목</th>
               <th>작성자</th>
               <th>조회수</th>
               <th>등록 일시</th>

            </tr>
         </thead>
         <tbody>
            <c:choose>
               <c:when test="${boardList.size() <= 0}">
                  <tr>
                     <td align="center" colspan="5">등록된 게시물이 없습니다.</td>
                  </tr>
               </c:when>
               <c:otherwise>
                  <c:forEach var="board" items="${boardList}" varStatus="i">
                     <tr>
                        <td align="center">
                           <c:out value="${i.count}" />
                        </td>
                        <td>
                           <a class="move" href='<c:out value="${board.no}"/>'>
                              <c:out value="${board.title}" />
                           </a>
                        </td>
                        <td align="center">
                           <c:out value="${board.id}" />
                        </td>
                        <td align="center">
                           <c:out value="${board.hit}" />
                        </td>
                        <td align="center">
                           <c:out value="${board.regDate}" />
                        </td>
                     </tr>
                  </c:forEach>
               </c:otherwise>
            </c:choose>
         </tbody>
      </table>
   </div>
   <!-- 페이징 or 페이지네이션 시작 -->
   <div  style="text-align: center;">
      <ul class="pagination">
            <c:if test="${pageMaker.prev}">
               <li class="paginate_button previous"><a
                  href="${pageMaker.startPage -1}">Previous</a></li>
            </c:if>

            <c:forEach var="num" begin="${pageMaker.startPage}"
               end="${pageMaker.endPage}">
               <li class="paginate_button  ${pageMaker.cri.pageNum == num ? "active":""} ">
                  <a href="${num}">${num}</a>
               </li>
            </c:forEach>

            <c:if test="${pageMaker.next}">
               <li class="paginate_button next"><a
                  href="${pageMaker.endPage +1 }">Next</a></li>
            </c:if>
         </ul>
      </div>
      <!-- 페이징 or 페이지네이션 종료 -->
      <!--  end Pagination -->
      <form id='actionForm' action="/board/boardList.do" method='get'>
         <input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
         <input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
         <input type='hidden' name='searchText'   value='<c:out value="${ pageMaker.cri.searchText}"/>'>
      </form>      
      
      <!-- Modal  추가 -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
         <div class="modal-dialog">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal"
                     aria-hidden="true">&times;</button>
                  <h4 class="modal-title" id="myModalLabel">Modal title</h4>
               </div>
               <div class="modal-body">처리가 완료되었습니다.</div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-default"
                     data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary">Save
                     changes</button>
               </div>
            </div>
            <!-- /.modal-content -->
         </div>
         <!-- /.modal-dialog -->
      </div>
      <!-- /.modal -->      
   <br>
   <input type="button" value="게시물 작성" onclick="location.href='<c:url value="/board/boardWrite.do" />'" />
   
<script type="text/javascript">
   $(document).ready(function() {
      var result = '<c:out value="${result}"/>';
      checkModal(result);
      history.replaceState({}, null, null);
      
      function checkModal(result) {
         if (result === '' || history.state) {
            return;
         }
         if (parseInt(result) > 0) {
            $(".modal-body").html(
                  "게시글 " + parseInt(result)
                        + " 번이 등록되었습니다.");
         }
         $("#myModal").modal("show");
      }

      $("#regBtn").on("click", function() {
         self.location = "${pageContext.request.contextPath}/board/boardWrite.do";
      });
      
      var actionForm = $("#actionForm");
      
      $(".paginate_button a").on("click",   function(e) {
               e.preventDefault();
               console.log('click');
               actionForm.find("input[name='pageNum']").val($(this).attr("href"));
               actionForm.submit();
      }); // 
      
      // 페이지 번호 클릭 이벤트 처리기(리스너, 핸들러)
      $(".move").on("click", function(e) {
         e.preventDefault();
         actionForm.append("<input type='hidden' name='no' value='"
            + $(this).attr(
                  "href")
            + "'>");
         actionForm.attr("action", "${pageContext.request.contextPath}/board/boardView.do");
         actionForm.submit();
      }); // end of move
   }); // end of ready()
</script>   
   
</body>
</html>