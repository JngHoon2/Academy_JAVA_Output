<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/shared/header.jsp" %>
<%-- <jsp:include page="/WEB-INF/views/shared/header.jsp" flush="false"/> --%>


<div class="container">
	<div id="wrap" align="center">
		<h4><b>인보이스 등록</b></h4>
		<form method="POST" class="form-horizontal"	role="form"	
		 	action="${pageContext.request.contextPath}/sales/invoice_insert">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 

			<!-- 첫번째줄 -->
	        <div class="form-group" align="right">
	            <label class="control-label col-sm-3" for="invoice_id">
	                인보이스 ID
	            </label>
	            <div class="col-sm-3" align="left">
					<input type="text" class="form-control" name="invoice_id" id="invoice_id" value="${map.invoice_id }" />
	            </div>
	            <label class="control-label col-sm-3" for="invoice_date">
	                인보이스 날짜
	            </label>
	            <div class="col-sm-3">
	                <input type="text" class="form-control date-picker" id="invoice_date" name="invoice_date" maxlength="10" value="${map.invoice_date }">
	            </div>
	        </div>
	
			<!-- 두번째줄 -->
	        <div class="form-group" align="right">
	            <label class="control-label col-sm-3" for="description">
	                인보이스 설명
	            </label>
	            <div class="col-sm-3">
	                <input type="text" class="form-control" id="description" name="description" maxlength="50">
	            </div>
	            <label class="control-label col-sm-3" for="client_id">
	                Client
	            </label>
	            <div class="col-sm-3">
					<select class="form-control" name="client_id" id="client_id" >
						<c:forEach var="client" items="${map.clientList}">
							<option value="${client.client_id }">${client.client_name }</option>
						</c:forEach>	
					</select>
	
	            </div>
	        </div>
	
			<!-- 세번째줄 -->
	        <div class="form-group" align="right">
	            <label class="control-label col-sm-3">
	                <a class="btn btn-info" style="margin-bottom:5px" id="addRow"><i class="fa fa-plus"></i> Add Row</a>
	            </label>
	            <div class="col-sm-3"></div>
	            <label class="control-label col-sm-3">
	                Amount
	            </label>
	            <div class="col-sm-3">
	                <input type="text" name="total_amt" id="subTotAmt" class="subTotAmt form-control" readonly />
	            </div>
	        </div>

			<!-- start of container -->
			<div class="container" style="width:100%; margin:0 auto">
				<div class="row">
					<table id="invoiceDetails" class="table table-responsive table-bordered table-hover table-striped" >
		              <thead>
		                    <tr>
		                        <th >No</th>
		                        <th style="width: 163.006px;">product_name</th>
		                        <th>product_id</th>
		                        <th>unit_price</th>
		                        <th>quantity</th>
		                        <th>total_amt</th>
								<th>Operation</th>
		                    </tr>
		                </thead>						
		                <tbody>
		                	<% 
		                		int i = 1; 
		                	%>
							<c:forEach var="invoiceDetail" items="${map.invoiceDetailList}" varStatus="status">
							<tr>
								<td><c:out value="${status.count}" /></td>
								<td align=left>${invoiceDetail.product_name}</td>
								<td align=left>${invoiceDetail.product_id}</td>
								<td align=left>${invoiceDetail.unit_price}</td>
								<td align=left>${invoiceDetail.quantity }</td>
								<td align=left>${invoiceDetail.total_amt }</td>
							</tr>
		                	<% 
		                		i++; 
		                	%>
							</c:forEach>
						</tbody>				
					</table>
						
		            <div>
			            <span id="invoiceItemError" style="color:red"></span>
		            </div>
		            <div>
		                <button type="button" id="btnSave" class="btn btn-block btn-success btn-flat"><span class="hide-on-mobile">Save</span>&nbsp;<i class="fa fa-save"></i></button>
		            </div>
					
				</div>
			</div>
			<!-- end of container -->

		</form>  
		<div id="dialog" title="dialog"></div>	
					
		<!--   Modal Dialog Div -->
	    <div id="myModal" class="modal fade" data-backdrop="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	        <div class="modal-dialog modal-size">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <button type="button" id="closbtn" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                    <h4 class="modal-title" id="myModalLabel">Modal</h4>
	                </div>
	                <div class="modal-body" id="myModalContent" ></div>
	                <div class="modal-footer">
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</div>

<%@ include file="/WEB-INF/views/shared/footer.jsp" %>	

	<script type="text/javascript">
		var table;
		var rowCount = 1;
		$(document).ready(function(){
			$('.date-picker').datepicker({ 
				dateFormat: 'yy-mm-dd', 
				changeMonth: 'true', 
				changeYear: 'true',
		         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
		         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
		         monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
				showButtonPanel: true, 
		        currentText: '오늘 날짜', 
		        closeText: '닫기',
			});
			
			table = $("#invoiceDetails").DataTable({
			    "processing": false,
                columnDefs: [
                    { "targets": 0, "orderable": false, 'width': '20px'   },
                    { "targets": 1, "orderable": false,  className: "input-group"  },
                    { "targets": 2, "orderable": false, 'width': '100px'  },
                    { "targets": 3, "orderable": false, 'width': '200px'  },
                    { "targets": 4, "orderable": false, 'width': '200px'  },
                    { "targets": 5, "orderable": false, 'width': '250px'  },
                    { "targets": 6, "orderable": false, 'width': '100px'  }
               ],
                "language": {"emptyTable": "Add a row."}
			});
			
			$('#addRow').on('click', function () {

                //if basically added row by datatable plugin
                if ($('#invoiceDetails tbody tr td').hasClass('dataTables_empty')) {
                    rowCount = 1;
                }
                table.row.add([
                    '<td>' + rowCount + '</td>',
                    '<td><input type="text" name="invoiceDetails[' + rowCount + '].ProductName" name="item.ProductName[' + rowCount + ']" class="ProductName form-control text-box single-line" value="" /> <span class="input-group-btn"><button class="ProductNameBtn btn btn-default" data-toggle="modal" data-target="#myModal" type="button"><i class="fa fa-search"></i></button></span></td>',
                    '<td><input type="text" name="invoiceDetails[' + rowCount + '].ProductId" name="item.ProductId[' + rowCount + ']" class="ProductId form-control" value="" /></td>',
                    '<td><input type="text" name="invoiceDetails[' + rowCount + '].ProductAmt" name="item.ProductAmt[' + rowCount + ']" class="ProductAmt form-control" value="" /></td>',
                    '<td><input type="text" name="invoiceDetails[' + rowCount + '].Quantity" name="item.Quantity[' + rowCount + ']" class="Quantity form-control" value="" /></td>',
                    '<td><input type="text" name="invoiceDetails[' + rowCount + '].TotAmt" name="item.TotAmt[' + rowCount + ']" class="TotAmt form-control" readonly value=""/></td>',
                    '<td><button type="button" style="width:95px" id=btn_delete' + rowCount + '" class="btn btn-delete btn-danger"><i class="fa fa-trash"></i>  Delete</button></td>'
                ] ).draw( false);
                rowCount++;
            });
			
            //Basaically 5 rows add
            var initRow = 5;
            for (var i = 0; i < 5; i++) {
                $('#addRow').click();
            }

            $('#btnSave').click(function () {
                Fn_Save_Invoice();
            });

            //click productNameBtn Button
            $('#invoiceDetails tbody').on('click', '.ProductNameBtn', function () {
                var $tr = $(this).closest('tr');
                var $td = $(this).closest('td');
                
                var trIndex = $tr.index();  //row number of clicked
                var tdIndex = $td.index();
                
                var productName = table.cell(trIndex, 1).nodes().to$().find('input').val().trim();
                $td.find('input').attr('value', this.value);

                if (productName == '') {
                    table.cell(trIndex, 2).nodes().to$().find('input').val('');
                    table.cell(trIndex, 3).nodes().to$().find('input').val('');
                }
                //alert("befor call Modal");
                
                Fn_Product_Modal(productName, trIndex);
            });
			
			//select product modal dialog open(productName click)
            $('#invoiceDetails tbody').on('change', '.ProductName', function () {
                var $tr = $(this).closest('tr');
                var $td = $(this).closest('td');
                
                var trIndex = $tr.index();	//row number of clicked
                var tdIndex = $td.index();
                
                var productName = table.cell(trIndex, 1).nodes().to$().find('input').val().trim();
                $td.find('input').attr('value', this.value);

                if (productName == '') {
                    table.cell(trIndex, 2).nodes().to$().find('input').val('');
                    table.cell(trIndex, 3).nodes().to$().find('input').val('');
                }
                //alert('before call modal -2')
                Fn_Product_Modal(productName, trIndex);
            });
          
            // One row remove
            $('#invoiceDetails tbody').on('click', '.btn-delete', function () {
                if (confirm("Do you want to delete this row?")) {
                    $(this).parents('tr').addClass('selected');     //delete 버튼 클릭된 행을 .selected 해놓고 아래에서 삭제
                    table.row('.selected').remove().draw(false);    //선택된 행 삭제

                    Fn_Remove_OneRow(table);                        //모든 행의 Qty * Price = TotAmt and Grand sum 재계산

                    //reordering each row number
                    $('#invoiceDetails tbody tr').each(function (index, ele) {
                        table.cell(index, 0).data(index + 1);
                    });

                    //reordering이 끝난 다음에 현재 row length + 1 값을 rowCount에 세팅
                    rowCount = $('#invoiceDetails tbody tr').length + 1;
                }
            });
            
            //keyup from productAmt(unit_price)
            $('#invoiceDetails tbody').on('keyup', '.ProductAmt', function () {
                //Get the cell of the input
                var $tr = $(this).closest('tr');
                var $td = $(this).closest('td');
                var trIndex = $tr.index();
                var tdIndex = $td.index();

				Fn_Valdation_And_Sum(table, trIndex);   //Recalculate sum
            });

            //unitprice or quantity column onkeyup event handler
            $('#invoiceDetails tbody').on('keyup', '.Quantity', function () {
                //Get the cell of the input
                var $tr = $(this).closest('tr');
                var $td = $(this).closest('td');
                var trIndex = $tr.index();
                var tdIndex = $td.index();

				Fn_Valdation_And_Sum(table, trIndex);   //Recalculate sum
            });

		});	//End of ready()

        //Open Product Madal Dialog
        function Fn_Product_Modal(productName, trIndex) {
            //alert("1");
			var url = getContextPath() + "/sales/product_modal";
            //var url = "/springmybatis/sales/product_modal"; 
            var data = {product_name: productName,
            			parentsLowNo: trIndex}
            $.ajax({
                type: "GET",
                url: url,
                data: data,
                contentType: "application/json; charset=utf-8",
                dataType: "html",
                success: function (data) {
                    $('#myModalContent').html(data);
                    //$('#myModal').modal(options);		//var options = { "backdrop": "static", keyboard: true };
                    $('#myModal').modal('show');
                }, failure: function (data) {
                    alert(data.responseText);
                }, error: function (data) {
                    alert(data.responseText);
                }
            });
        }        

        //Sum Quantity and TotAmt each row
        function Fn_Sum_Qty_Amt() {
            var quantity = 0, totalAmt = 0.0;
            $('#invoiceDetails tbody tr').each(function (index, ele) {
                var tempQuantity = table.cell(this, 4).nodes().to$().find('input').val();       //quantity
                quantity = quantity + parseInt(Fn_Remove_Comma(tempQuantity));
                var tempTotalAmt = table.cell(this, 5).nodes().to$().find('input').val();       //totAmt
                totalAmt = totalAmt + parseFloat(Fn_Remove_Comma(tempTotalAmt));
            });
            $('#subTotQty').val(Fn_Add_Comma(quantity));
            $('#subTotAmt').val(Fn_Add_Comma(totalAmt.toFixed(2)));
        }


        //Add comma at thousand unit(int and decimal)
        function Fn_Add_Comma(number) {
            var number_string = number.toString();
            var number_parts = number_string.split('.');
            var regexp = /\B(?=(\d{3})+(?!\d))/g;
            if (number_parts.length > 1) {
                return number_parts[0].replace(regexp, ',') + '.' + number_parts[1];
            }
            else
            {
                return number_string.replace(regexp, ',');
            }
        }

        //remove comma
        function Fn_Remove_Comma(number) {
            if (typeof number == "undefined" || number == null || number == "") {
                return "";
            }
            var txtNumber = '' + number;
            return txtNumber.replace(/(,)/g, "");
        }		
		
        //Save Invoice
        function Fn_Save_Invoice() {
            var list = [];
            var isAllValid = true;
            var sumTotAmt = 0;
            var exitFunction = false;
            $('#invoiceItemError').text('');

            //invoice Header validation
            if ($('#invoice_date').val() == '') {
                alert('Please enter the invoice date');
                $('#invoice_date').siblings('span.error').css('visibility', 'visible');
                $('#invoice_date').focus();
                exitFunction = true;    //exit each loop and function
                return false;           //exit only each loop
                isAllValid = false;
            }
            else {
                $('#invoice_date').siblings('span.error').css('visibility', 'hidden');
            }

            if ($('#client_id').val() == '') {
                alert('Please select the client');
                $('#client_id').siblings('span.error').css('visibility', 'visible');
                $('#client_id').focus();
                exitFunction = true;    //exit each loop and function
                return false;           //exit only each loop
                isAllValid = false;
            }
            else {
                $('#client_id').siblings('span.error').css('visibility', 'hidden');
            }

            //행별 합산 금액 맞는지 검증
            //if (sumTotAmt != parseFloat($('#subTotAmt').val().replace(/[^-\.0-9]/g, ""))) {
            //    alert('Please check Amount each rows.');
            //    $('#invoiceItemError').text('Please check the Sub Total amount.');
            //    exitFunction = true;    //exit each loop and function
            //    return false;           //exit only each loop
            //}

            //detail items validation
            $('#invoiceDetails tbody tr').each(function (index, ele) {
                var productName = "";
                var productId = "";
                var unitPrice = "";
                var quantity = "";
                var totalAmt = "";

                //한 행의 자료 Get
                productName = table.cell(this, 1).nodes().to$().find('input').val();    //productName
                productId = table.cell(this, 2).nodes().to$().find('input').val();      //productId
                unitPrice = table.cell(this, 3).nodes().to$().find('input').val();      //unitPrice
                quantity = table.cell(this, 4).nodes().to$().find('input').val();       //quantity
                totalAmt = table.cell(this, 5).nodes().to$().find('input').val();       //totAmt

                //만들어진 행이 한 개도 없을때
                if (isNaN(productId)) {
                    $('#invoiceItemError').text('At least 1 invoice item required.');
                    alert('At least 1 invoice item required.');
                    exitFunction = true;    //exit each loop and function
                    return false;           //exit only each loop
                }

                //Invoice Detail필수 입력 필드 값 체크(productId, productName, unitPrice, quantity, totalAmt)
                if (productId == '') {
                    //alert('Please check product information in row number ' + (index + 1));
                    table.cell(this, 1).nodes().to$().find('input').focus();
                    return true;    //go next loop(continue....)
                }
                if (productName == '') {
                    //alert('Please check product information in row number ' + (index + 1));
                    table.cell(this, 2).nodes().to$().find('input').focus();
                    return true;    //go next loop(continue....)
                }
                if (unitPrice == '') {
                    alert('Please check product unitPrice in row number ' + (index + 1));
                    table.cell(this, 3).nodes().to$().find('input').focus();
                    exitFunction = true;    //for exit each loop and function
                    return false;           //exit only each loop
                }
                if (quantity == '') {
                    alert('Please check product quantity in row number ' + (index + 1));
                    table.cell(this, 4).nodes().to$().find('input').focus();
                    exitFunction = true;    //exit each loop and function
                    return false;           //exit only each loop
                }
                if (totalAmt == '') {
                    alert('Please check product unitPrice and quantity in row number ' + (index + 1));
                    table.cell(this, 5).nodes().to$().find('input').focus();
                    exitFunction = true;    //exit each loop and function
                    return false;           //exit only each loop
                }
                //모든 필수 입력 값 OK -> insert Detail List
                var invoiceItem = {
                		product_id: parseInt(productId.trim()),
                		product_name: productName.trim(),
                		quantity: parseInt(quantity.trim().replace(/[^0-9]/g, "")),
                		unit_price: parseFloat(unitPrice.trim().replace(/[^-\.0-9]/g, "")),
                		total_amt: parseFloat(totalAmt.trim().replace(/[^-\.0-9]/g, ""))
                }
                list.push(invoiceItem);
                sumTotAmt += parseFloat(totalAmt.trim().replace(/[^-\.0-9]/g, ""));
            }); //end of each loop

            //exit function(특정 Loop안에서 return false해도 그 Loop만 빠지고 그 상위로 계속 진행)
            if(exitFunction) {
                exitFunction = false;
                return false;
            }

            if (list.length == 0) {
                alert('At least 1 invoice item required.');
                $('#invoiceItemError').text('At least 1 invoice item required.');
                return false;
            }

            //invoice Header setting
            if (isAllValid) {
                var data = {                                        //Invoice Header Columns
                	invoice_id: $('#invoice_id').val(),               //invoice No
                	invoice_date: $('#invoice_date').val(),           //invoice Date
                    client_id: parseInt($('#client_id').val()),       //client_id
                    total_amt: parseFloat($('#subTotAmt').val().replace(/[^-\.0-9]/g, "")),  //Sub Total Amount
                    description: $('#description').val(),           //Description
                    invoiceDetails: list                            //Array of InvoiceDetail
                }
                $(this).val('Please wait....');
                //alert(JSON.stringify(data));
                var url = getContextPath() + "/sales/invoice_insert";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: JSON.stringify(data),
                    contentType: "application/json",
            		beforeSend: function(xhr){
            			var csrf_tocken = $("meta[name='_csrf']").attr("content");
                        var csrf_header = $("meta[name='_csrf_header']").attr("content");
                        xhr.setRequestHeader(csrf_header, csrf_tocken);
                	},
                    success: function (data) {	/* 컨트롤러에서 보내는 변수이름(data)과 동일해야 함. */
						console.log("data : " + data);
						
                        if (data == "success") {
                            list = [];
                            //$.notify(data.message, { globalPosition: "top center", className: "success" });
                            location.href = getContextPath() + "/sales/invoice_list";
                        } else {
                            //$.notify(data.message, { globalPosition: "top center", className: "error" });
                        }
                    },
                    error: function (xhr) {
                    	console.log("오류 코드 : " + xhr.status);
                        console.log("오류 메시지 : " + xhr.responseText);
                        //$.notify(data.message, { globalPosition: "top center", className: "error" });
                    }
                });
            }
        }

        //unitPrice and quantity number validation and sum
        function Fn_Valdation_And_Sum(table, tr) {

            var intQty = 0, floatPrice = 0.0, totAmt = 0.0;
            var qty, price, totAmt;

            //unitPrice validation(allowed numeric, comma, decimal point because unitPrice is decimal type)
            if (table.cell(tr, 3).nodes().to$().find('input').val() != "") {    //unitPrice column
                var inputUnitPrice = table.cell(tr, 3).nodes().to$().find('input').val().replace(/[^-\.0-9]/g, "").replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
                table.cell(tr, 3).nodes().to$().find('input').val(inputUnitPrice);
                price = table.cell(tr, 3).nodes().to$().find('input').val().replace(/,/g, "");
                floatPrice = Number(price);

                //Decimal Point don't be first digit and twice
                if (price.indexOf('.') == 0) {
                    alert('The decimal point cannot be in the first digit');
                    return false;
                }
                if (Number(price.split('.').length) > 2) {
                    alert('The decimal point cannot be entered twice.');
                    return false;
                }
            }
            else {
                table.cell(tr, 5).nodes().to$().find('input').val('');
            }

            //quantity validation(numeric and comma because quantity is integer type)
            if (table.cell(tr, 4).nodes().to$().find('input').val() != "") {    //quantity column
                var inputQty = table.cell(tr, 4).nodes().to$().find('input').val().replace(/[^0-9]/g, "").replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
                table.cell(tr, 4).nodes().to$().find('input').val(inputQty);
                qty = table.cell(tr, 4).nodes().to$().find('input').val().replace(/,/g, "");
                intQty = Number(qty);
            }
            else {
                table.cell(tr, 5).nodes().to$().find('input').val('');
            }

            if (floatPrice > 0 && intQty > 0) {
                totAmt = (intQty * floatPrice).toFixed(2);	// ex) 10,230.45

                //var length = totAmt.toString().length;
                //var idxOfPoint = totAmt.toString().indexOf(".");
                ////var beforePoint = totAmt.toString().substr(0, idxOfPoint).replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","); //before decimal point add comma
                //var beforePoint = totAmt.toString().substr(0, idxOfPoint).replace(/\B(^-\.\d*)(?=(\d{3})+(?!\d))/g, ","); //before decimal point add comma
                //var afterPoint = totAmt.toString().substr(idxOfPoint + 1, length - idxOfPoint - 1);	//under decimal point
                //table.cell(tr, 5).nodes().to$().find('input').val(beforePoint.toString() + "." + afterPoint.toString());    //각 row의 totAmt에 Assign
                table.cell(tr, 5).nodes().to$().find('input').val(Fn_Add_Comma(totAmt));    //각 row의 totAmt에 Assign

                var sumAmt = 0.0;
                var sumQty = 0;
                var data = table.rows().data();
                data.each(function (value, index) {
                    var tempAmt = Number(table.cell(index, 5).nodes().to$().find('input').val().replace(/,/g, ""));
                    sumAmt = sumAmt + tempAmt;
                    var tempQty = Number(table.cell(index, 4).nodes().to$().find('input').val().replace(/,/g, ""));
                    sumQty = sumQty + tempQty;
                });

                //$('#subTotQty').val(sumQty.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",")); //Sum of qty add comma thousand unit
                //$('#subTotQty').val(sumQty.toString().replace(/\B(^-\.\d*)(?=(\d{3})+(?!\d))/g, ",")); //Sum of qty add comma thousand unit
                $('#subTotQty').val(Fn_Add_Comma(sumQty)); //Sum of qty add comma thousand unit

                totAmt = sumAmt.toFixed(2);

                //if (totAmt > 0) {                                       //소숫점 앞뒤로 잘라서 앞 부분에 천단위 콤머 추가
                    //var length = totAmt.toString().length;
                    //var idxOfPoint = totAmt.toString().indexOf(".");    //get the index of decimal point
                    ////var beforePoint = totAmt.toString().substr(0, idxOfPoint).replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","); //add comma every thousand unit
                    //var beforePoint = totAmt.toString().substr(0, idxOfPoint).replace(/\B(^-\.\d*)(?=(\d{3})+(?!\d))/g, ","); //add comma every thousand unit
                    //var afterPoint = totAmt.toString().substr(idxOfPoint + 1, length - idxOfPoint - 1);	//under decimal point
                    //$('#subTotAmt').val(beforePoint.toString() + "." + afterPoint.toString());	//Integer part + "." + decimal part
                //}
                $('#subTotAmt').val(Fn_Add_Comma(totAmt));
            }
        }

        //Remove one row then recalculate sum of all rows
        function Fn_Remove_OneRow(table)
        {
            var sumAmt = 0.0
            var totAmt = 0.0;
            var sumQty = 0;
            var data = table.rows().data();

            data.each(function (value, index) {

                var tempAmt = Number(table.cell(index, 5).nodes().to$().find('input').val().replace(/,/g, ""));
                if (tempAmt > 0) {
                    sumAmt = sumAmt + tempAmt;  //sum of TotAmt each row
                }

                var tempQty = Number(table.cell(index, 4).nodes().to$().find('input').val().replace(/,/g, ""));
                if(tempQty > 0)
                    sumQty = sumQty + tempQty;  //sum of Qty each row
            });

            $('#subTotQty').val(Fn_Add_Comma(sumQty)); 
            totAmt = sumAmt.toFixed(2); //ex) 10,234.78
            $('#subTotAmt').val(Fn_Add_Comma(totAmt));
        }

        function Delete_InvoiceDetailItem(url) {
            if (confirm('Are you sure to delete this record?')) {
                $.ajax({
                    type: "POST",
                    url: url,
                    success: function (data) {
                        if (data.success)
                        {
                            dataTable.ajax.reload();
                            $.notify(data.message, {
                                globalPosition: "top center",
                                className: "success"
                            })
                        }
                        else
                        {
                            $.notify(response.message, "error");
                        }
                    }
                });
            }
        }        

	</script>

	<style>
	
	    .modal-size {
	        width: 530px;
	        margin: auto;
	    }
	
	    span.error {
	        display: block;
	        visibility: hidden;
	        color: red;
	        font-size: 90%;
	    }
	
	    tr.error {
	        background-color: rgba(255,0,0,0.35);
	    }
	
	    table.TABLE_V_SCROLL > thead, div.TABLE_V_SCROLL > div.thead {
	        display: table;
	    }
	</style>

	
