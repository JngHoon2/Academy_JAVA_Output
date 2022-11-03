<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../include/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">사원 정보 수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">사원 정보 수정</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<form id="modifyForm" role="form" 
	        		action="<c:url value="/emp/empModify.do" />"  
	        		method="post">

					  <input type='hidden' id='employeeId' name='employeeId' value='<c:out value="${emp.employeeId}"/>'>
					  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
					  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					  <input type='hidden' name='searchText' value='<c:out value="${cri.searchText}"/>'>
				
				
					<div class="form-group">
						<label>사원ID</label> 
						<input class="form-control" name='employeeId' value='<c:out value="${emp.employeeId }"/>' readonly="readonly">
					</div>
	
					<div class="form-group">
						<label>성명</label> 
						<input class="form-control" name='name' value='<c:out value="${emp.firstName} ${emp.lastName}"/>' readonly="readonly">
					</div>
	
					<div class="form-group">
						<label>이메일</label>
						<input class="form-control" name='email' value='<c:out value="${emp.email}"/>'>
					</div>
	
					<div class="form-group">
						<label>연락처</label> 
						<input class="form-control" name='phoneNumber' value='<c:out value="${emp.phoneNumber }"/>'>
					</div>
	
					<div class="form-group">
						<label>입사일</label> 
						<input class="form-control" name='hireDate' value='<c:out value="${emp.hireDate }"/>'>
					</div>
	
					<div class="form-group">
						<label>급여</label> 
						<input class="form-control" name='salary' value='<c:out value="${emp.salary }"/>'>
					</div>
									
			          <button type="submit" class="btn btn-success">저장</button>
			          <button data-oper='list' value="목록" class="btn btn-info">목록</button>
	
				</form>
			</div>
			<!--  end panel-body -->
		</div>
		<!--  end panel-heading -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {
		var operForm = $("#modifyForm"); 
		// 목록
		$("button[data-oper='list']").on("click", function(e){  
			operForm.find("#employeeId").remove();	//  목록으로 가기 때문에 employeeId 불필요	
			operForm.attr("method","get");
			operForm.attr("action","/emp/list.do");
			operForm.submit();    
		});  
	}); // end ready()
</script>


<%@include file="../include/footer.jsp"%>
