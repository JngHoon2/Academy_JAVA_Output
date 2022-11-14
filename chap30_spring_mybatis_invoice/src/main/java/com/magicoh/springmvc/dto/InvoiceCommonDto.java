package com.magicoh.springmvc.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString//(exclude={"product_name"})
public class InvoiceCommonDto {

	//invoiceHeader
	private Integer invoice_id;   
	private Integer client_id; 
	private Date invoice_date;
	private String shipping_address;
	private double total_amt; 
	private String description; 
	private Date created_date;
	private Date modified_date;	
	
	//invoiceDetail
	private Integer invoice_detail_id; 
	private Integer product_id;   		
	private Integer category_id;   		
	private double unit_price;   	
	private Integer quantity;  
	private double sub_total_amt;       	
	
	//only data transfer
	private String product_name; 		//not database column
	private String client_name;			//not database column
	private String category_name;		//not database column
	private String invoice_date_from;	//not database column   	
	private String invoice_date_to;	  	//not database column
	
}
