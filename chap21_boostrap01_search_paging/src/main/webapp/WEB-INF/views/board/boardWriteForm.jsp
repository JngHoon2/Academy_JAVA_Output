<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- 헤더 부분 인클루드 -->
<%@ include file="../include/header.jsp" %>

<!-- 제목 -->
<div class="row">
  <div class="col-lg-12">
     <h1 class="page-header">게시물 작성</h1>
  </div>
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<!-- 바디(내용) -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시물 작성</div>
			<!-- /.panel-heading -->
				<div class="panel-body">
			
				<form role="form" action="<c:url value="/board/boardWrite.do"/>" method="post">
			
					<div class="form-group">
						<label>제목</label> 
						<input type="text" class="form-control" name='title' id="title">
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea type="text" rows="10" class="form-control" name='content' id="content"></textarea>
						<script>CKEDITOR.replace('content');</script>
					</div>
					<div class="form-group">
						<label>작성자</label> 
						<input class="form-control" name='id' id="id" value='<c:out value="${user.id}"/>' readonly>
					</div>
					<button type="submit" class="btn btn-success">저장</button>
					<button type="rest" class="btn btn-info">초기화</button>
				</form>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
		function goUrl(url) {
			location.href=url;
		}
		// 등록 폼 체크
		function boardWriteCheck() {
			var form = document.boardForm;
			if (form.title.value == '') {
				alert('제목을 입력하세요.');
				form.title.focus();
				return false;
			}
			if (form.writer.value == '') {
				alert('작성자를 입력하세요');
				form.writer.focus();
				return false;
			}
			return true;
		}
	</script>

<!-- 푸터 부분 인클루드 -->
<%@ include file="../include/footer.jsp" %>