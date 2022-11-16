<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="container" style="width:400px;">
	    <nav class="navbar navbar-default">
<%-- 			<form action="${pageContext.request.contextPath}/sales/client_modal" class="navbar-form pull-right" method="GET"> --%>
				<form  name="client_modal_form" class="navbar-form pull-right" >
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" id="client_id" name="client_id" />
				<input type="text" id="client_name_m" name="client_name" class="form-group client_name" placeholder="검색" value="${client_name}" />
				<button type="submit" id="btnSearch_m" class="btn btn-success">조회</button>
			</form>
	    </nav>
		<div class="row">
			<div>
				<table id="client_datatable" class="table table-bordered table-hover table-striped"  style="width:100%">
					<thead>
						<tr>
							<th style="background-color: #eeeeee">client_id</th>
							<th style="background-color: #eeeeee">client_name</th>
							<th style="background-color: #eeeeee">address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="client" items="${clientList}">
						<tr>
							<td align=left>${client.client_id }</td>
							<td align=left><a href="#">${client.client_name}</a></td>
							<td align=left>${client.address }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script>
		var table ;
 		$(document).ready(function(){
 			
 			// 팝업 오픈과 동시에 컨트롤러에서 받은 거래처로  데이터테이블 만들기
			$('#client_datatable').removeAttr('width').DataTable({
					select: true,
			    	"processing": true,
			    	"lengthChange": true,
			    	"searching": true,
			    	"order": [[ 0, "desc" ]],	//default order column index and sort direction
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
		                }
					], 
			        fixedColumns: true
			 });	//end of product_datatable 			
 			
            // 팝업에서 조회
            $('#btnSearch_m').on('click', function () {
            	event.preventDefault(); //모달 창에서 조회했을 때 팝업이 닫히는 문제를 막아줌.	
            	var client_name = $('#client_name_m').val();
                Fn_Search_Client(client_name);
            });
            
            //Attaches click events for newly added rows. 
            $("#client_datatable").on("click", "a", function(event) { 
				var temp = $(this);
				Fn_Click_ClientName(temp);
			});

            //click specified client name(when the popup dialog first opened)
// 			$('#client_datatable a').on("click", function(event){
// 				alert("a href click");
// 				var temp = $(this);
// 				Fn_Click_ClientName(temp);
// 			});	
            
		});	//end of ready()
		
		//put the selected client name to parents window
		function Fn_Click_ClientName(that) {
			var row = that.closest("tr");
			var td = row.find("td");
			var clientId = td.eq(0).html().trim();
			var clientName = td.eq(1).text();	//a href가 있어서 text()
	        var clientPrice = td.eq(2).html();

	        $('#client_id').val(clientId);
	        $('#client_name').val(clientName);
	        $('#myModal').modal('hide');
		}

		// 팝업에서 조회
		function Fn_Search_Client(client_name) {
			var url = getContextPath() + "/sales/client_modal_search";
			var data = $("form[name=client_modal_form]").serializeObject();
			$.ajax({
				type : "POST",
				url : url,
				data : JSON.stringify(data),
               //setting before ajax call for spring security
                beforeSend: function(xhr){
                	var csrf_tocken = $("meta[name='_csrf']").attr("content");
                	var csrf_header = $("meta[name='_csrf_header']").attr("content");
                	xhr.setRequestHeader(csrf_header, csrf_tocken);
               	},
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(data) {
					console.log(data);
					// 이미 데이터테이블 인스턴스가 만들어져 있으면 그걸 지움
					if ($.fn.dataTable.isDataTable('#client_datatable')) {
						//alert('aleady instincaited');
             		    $('#client_datatable').DataTable().clear().destroy();               
            		}
					// 데이터테이블 새로 만듦
					$('#client_datatable').DataTable({
				    	"data": data,
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
			                }  
						], 
						"columns": [
		                    { "data": "client_id", "name": "client_id", "width": "100px"},
		                    { 
		                    	"data": "client_name", "name": "client_name", "width": "100px",
		                    	"render": function (data, type, full, meta) {
		                    		return $('<a>').attr('href', '#').text(data).wrap('<td></td>').parent().html();
		                    	}			
		                    },
		                    { "data": "address", "name": "address", "width": "100px"}
		          		]						
				    });					
				},
				failure : function(data) {
					alert(data);
				},
				error : function(xhr, status) {
					alert(xhr.responseText);
				}
			});
		}	//end of Fn_Search_Category

		
		/*
		//client list 조회(그리드 컨트롤 미사용)
		function Fn_Search_Client(client_name) {
			var url = getContextPath() + "/sales/client_modal_search";
			//var url = "/springmybatis/sales/client_modal_search";
			var data = {client_name: client_name};
			$.ajax({
				type : "GET",
				url : url,
				data : data,
				contentType : "application/json; charset=utf-8",
				dataType : "html",
				success : function(response) {
					//alert(response);
					
					//convert response data to javascript Object
					var jasonData = JSON.parse(response);
					$('#client_datatable tr:not()').remove();
	
					var text = "";
					text += "<tr>\n";
					text += "<th style='background-color: #eeeeee; text-align:center;'>client_id</th> \n";
					text += "<th style='background-color: #eeeeee; text-align:center;'>client_name</th> \n";
					text += "<th style='background-color: #eeeeee; text-align:center;'>address</th> \n";
					text += "</tr>\n";
					for (var i = 0; i < jasonData.length; i++) {
						text += "<tr>\n";
						text += "<td>" + jasonData[i].client_id
								+ "</td>\n";
						text += "<td><a href='#'>"
								+ jasonData[i].client_name
								+ "</a></td>\n";
						text += "<td>" + jasonData[i].address
								+ "</td>\n";
						text += "</tr>\n";
					}
					$('#client_datatable').append(text);
				},
				failure : function(response) {
					alert(response);
				},
				error : function(response) {
					alert(response);
				}
			});
		}
		*/
		
	</script>	
</body>
</html>