t<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Security</title>
    
	<!--  jQuery CSS--> 
	<link href="http://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
	<!--  Bootstrap CSS--> 
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<!--  Datatable CSS--> 
	<!-- <link href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />  -->
    <link href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/responsive/2.2.6/css/responsive.bootstrap.min.css" rel="stylesheet" />
	<!--  Datatable Buttons CSS--> 
    <link href="https://cdn.datatables.net/buttons/1.6.4/css/buttons.dataTables.min.css" rel="stylesheet" />  
    <link href="https://cdn.datatables.net/buttons/1.6.4/css/buttons.bootstrap.min.css" rel="stylesheet" />  
	<!--  font-awesome CSS--> 
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

	<!-- [jQuery] -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<!-- ckEditor -->
	<script src="//cdn.ckeditor.com/4.11.4/standard/ckeditor.js"></script>
	<!-- [Bootstrap] -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<!-- [DataTable] -->	
    <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.6/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.6/js/responsive.bootstrap.min.js"></script>
	<!-- [DataTable Buttons Excel PDF CSV] -->    
    <script src="https://cdn.datatables.net/buttons/1.6.4/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.flash.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.6.4/js/buttons.print.min.js"></script>
    
</head>

<body>

	<div class="container">	
		<div id="wrap" align="center">
				<!-- 제목 -->
	        <div class="row">
	            <div class="col-lg-12">
	                <h3 class="page-header" style="text-align: center;">사원 조회</h3>
	            </div>
	            <!-- /.col-lg-12 -->
	        </div>
	        <!-- /.row -->
	        <!-- 바디(내용) -->
	        <div class="row">
	            <div class="col-lg-12">
	                <div class="panel panel-default">
	                    <div class="panel-heading">
	                        	조회 조건을 입력하세요.
	                    </div>
	                    <!-- /.panel-heading -->
	                    <div class="panel-body">
	            			<!-- start search -->	
			 				<div class='row' style="text-align: center; margin-bottom:10px;">
								<div class="col-lg-12">
									<form name="invoiceForm" class="form-horizontal" role="form">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								        
								        <div class="form-group">
								            <label class="control-label col-sm-3" for="invoice_id">인보이스 ID</label>
								            <div class="col-sm-3" >
												<input type="text" class="form-control" id="invoice_id" name="invoice_id">
								            </div>
								            <label class="control-label col-sm-3" for="client_name">거래처명</label>
								            <div class="col-sm-3">
								            	<div class="input-group">
									                <input type="text" class="form-control" id="client_name" name="client_name" >
									                <input type="hidden" class="form-control" id="client_id" name="client_id">
									                <span class="input-group-btn">
														<button class="clientBtn btn btn-default" id="clientBtn" data-toggle="modal" data-target="#myModal" type="button"><i class="fa fa-search"></i></button>
													</span>
												</div>
								            </div>
								        </div>
								
								        <div class="form-group">
								            <label class="control-label col-sm-3" for="product_name">제품명</label>
								            <div class="col-sm-3">
								            	<div class="input-group">
								                	<input type="text" class="form-control" id="product_name" name="product_name" >
								                	<input type="hidden" class="form-control" id="product_id" name="product_id">
								                	<span class="input-group-btn">
														<button class="productBtn btn btn-default" id="productBtn" data-toggle="modal" data-target="#myModal" type="button"><i class="fa fa-search"></i></button>
													</span>
												</div>	 
								            </div>
								            <label class="control-label col-sm-3" for="category_name">카테고리</label>
								            <div class="col-sm-3">
								            	<div class="input-group">
								                	<input type="text" class="form-control" id="category_name" name="category_name" >
								                	<input type="hidden" class="form-control" id="category_id" name="category_id" >
								                	<span class="input-group-btn">
														<button class="categoryBtn btn btn-default" id="categoryBtn" data-toggle="modal" data-target="#myModal" type="button"><i class="fa fa-search"></i></button>
													</span>
												</div>	 
								            </div>
								        </div>
							        
									    <div class="form-group">
								            <label class="control-label col-sm-3" for="invoice_date_from">인보이스 날짜(From)</label>
								            <div class="col-sm-3" >
												<input type="date"	class="form-control date-picker" id="invoice_date_from"	name="invoice_date_from" maxlength="10" value="${invoice_date_from }">
								            </div>
								            <label class="control-label col-sm-3" for="invoice_date_to">인보이스 날짜(To)</label>
								            <div class="col-sm-3">
								                <input type="date"	class="form-control date-picker" id="invoice_date_to" name="invoice_date_to" maxlength="10" value="${invoice_date_to }">
								            </div>
								        </div>
							        
									    <div>
											<button type="submit" id="btnSearch" class="btn btn-primary">조회</button>
										</div>
									</form>
									
			 					</div>
							</div> 
	            			<!-- end search -->	
	                    	<!-- start table contents -->
	                    	<div class='row'>
	                    		<div class="col-lg-12">
			                        <table id="dataTable" width="100%" class="table table-striped table-bordered table-hover" >
			                            <thead>
			                                <tr>
			                                    <th>순서</th>
			                                    <th>사번</th>
			                                    <th>성명</th>
			                                    <th>이메일</th>
			                                    <th>연락처</th>
			                                    <th>입사일</th>
			                                    <th>업무</th>
			                                    <th>급여</th>
			                                    <!-- <th>부서명</th> -->
			                                    <!-- <th>근무지역</th>
			                                    <th>근무도시</th>
			                                    <th>근무국가</th> -->
			                                </tr>
			                            </thead>
			                            <tbody>
											<c:forEach items="${employeesList}" var="emp" varStatus="i">
												<tr>
													<td align="center">
														<c:out value="${i.count}" />
													</td>
													<td>
														<c:out value="${emp.employeeId}" />
													</td>
													<td>
														<a class='move' href='<c:out value="${emp.employeeId}"/>'>
															<c:out value="${emp.firstName} ${emp.lastName}" /> 
														</a>
													</td>	
													<td>
														<c:out value="${emp.email}" />
													</td>
													<td>
														<c:out value="${emp.phoneNumber}" />
													</td>
													<td>
														<fmt:formatDate pattern="yyyy-MM-dd" value="${emp.hireDate}" />
													</td>
													<td>
														<c:out value="${emp.jobId}" />
													</td>
													<td>
														<c:out value="${emp.salary}" />
													</td>
	<%-- 												<td>
														<c:out value="${emp.departmentName}" />
													</td>
													<td>
														<c:out value="${emp.stateProvince}" />
													</td>
													<td>
														<c:out value="${emp.city}" />
													</td>
													<td>
														<c:out value="${emp.countryName}" />
													</td> --%>
													
												</tr>
											</c:forEach>
										</tbody>
			                        </table>
								</div>			                        
							</div>
							<!-- end table contents -->
							<!-- start Pagination -->						           				
	            			<div style="text-align: center;">
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
							<!-- end Pagination -->
							<!-- 페이지 번호 클릭시 전달될 폼 -->
							<div>
								<form id='actionForm' action="/admin/employeeList2" method='get'>
									<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
									<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
									<input type='hidden' name='searchText'	value='<c:out value="${ pageMaker.cri.searchText}"/>'>
								</form>		
							</div>
	                    </div>
	                    <!-- panel-body -->
	                </div>
	                <!-- panel -->
	            </div>
	            <!-- col-lg-12 -->
	        </div>

			
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			
			Fn_Init_Datatable();
			
			var actionForm = $("#actionForm");
			
			// [1] 사원명 클릭 이벤트(핸들러)
			// - 사원목록 제목에 href=${emp.employeeId}를 걸어놓음. 그리고 그 값을 employeeId라는 name 태그로 서버에 전송
			$(".move").on("click", function(e) {
				e.preventDefault();	// 안막으면 원래 걸려있는 링크로 submit()이 되버림.(a href가 제 기능하지 않도록 방지)
				console.log('게시물 클릭');
				actionForm.append("<input type='hidden' name='employeeId' value='"
					+ $(this).attr("href")
					+ "'>");
				actionForm.attr("action", "${pageContext.request.contextPath}/emp/empView.do");
				actionForm.submit();
			});
			
			// [2] 페이지 번호 클릭 이벤트 처리기(리스너, 핸들러)
			// - 페이지 버튼 클릭시 폼태그에 해당 페이지 번호를 세팅해서 서버로 전달(submit)
			$(".paginate_button a").on("click",	function(e) {
				//alert('페이지 번호 클릭');
				e.preventDefault();	// 안막으면 원래 걸려있는 링크로 submit()이 되버림.(a href가 제 기능하지 않도록 방지)
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
			});

	         // [3] 검색 버튼 클릭 이벤트 핸들러(리스너)
	        $('#btnSearch').on('click', function(){

	        	// 검색 키워드 널 체크
	 			let searchText = $('#searchText').val();	// let은 var과 동일한 기능, 변수명 중복 체크해주는 장점.
	 			if(searchText == "" || searchText == null || searchText == undefined || searchText.length < 1 ){
	 				alert('검색어를 입력하세요.');
	 				$("#searchText").focus();
	 				return false;
	 			}
				$('#searchForm').submit();					
			});  
			
		}); // end of ready()
		
		// 그리드 솔루션인 데이터테이블(DataTable) 초기화
		function Fn_Init_Datatable(){
			//datatables setting
			table =  $('#dataTable').removeAttr('width').DataTable({
					"bPaginate": false, /* datatable paging hidden 처리 */
					select: true,
					mark: true, // Highlight search terms
					aLengthMenu: [
						// Show entries incrementally
						[10, 15, 30, 50, -1],
						[10, 15, 30, 50, "All"]
					],
					dom: 'Bfrtip',
			        buttons: [
			        	  { extend: 'pdf', text: '<i class="fa fa-pencil" aria-hidden="true"> PDF</i>' },
		                  { extend: 'csv', text: '<i class="fas fa-file-csv fa-1x">CSV</i>' },
		                  { extend: 'excel', text: '<i class="fas fa-file-excel" aria-hidden="true">EXCEL</i>' }
			        ],
		        	"scrollCollapse": true,
			    	"processing": true,
			    	"lengthChange": false,
			    	"searching": false,
			    	"order": [[ 0, "asc" ]],	//default order column index and sort direction
			    	"columnDefs": [
			    		{  
		                    "targets": [0],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                }, 
			    		{  
		                    "targets": [1],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                },  
		                {  
		                    "targets": [2],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                },  
		                {  
		                    "targets": [3],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                },  
		                {  
		                    "targets": [4],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                },
		                {  
		                    "targets": [5],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                },
		                {  
		                    "targets": [6],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                },
		                {  
		                    "targets": [7],  
		                    "visible": true,  
		                    "searchable": true,
		                    "orderable": true
		                }
					], 
			        fixedColumns: true
			 });	//end of datatable
		}		
		
	</script>




</body>
</html>
