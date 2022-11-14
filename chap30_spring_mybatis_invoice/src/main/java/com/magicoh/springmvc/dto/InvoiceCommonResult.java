package com.magicoh.springmvc.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCommonResult {

	//invoiceHeader
	private Integer invoice_id;   
	private Integer client_id; 
	private String client_name;			//not database column
	private Date invoice_date;
	private String shipping_address;
	private double total_amt; 
	private String description; 
	private Date created_date;
	private Date modified_date;	
	
	//invoiceDetail
	private Integer invoice_detail_id; 
	private Integer product_id;   		
	private String product_name; //not database table column
	private double unit_price;   	
	private Integer quantity;  
	private double sub_total_amt;       	
	
}
