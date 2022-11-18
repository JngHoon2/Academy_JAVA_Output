package com.javalab.invoice.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString//(exclude={"product_name"})
public class InvoiceDetail {

	private Integer invoice_detail_id;   	
	private Integer invoice_id;   	
	private Integer product_id;   		
	private String product_name;   		
	private double unit_price;   	
	private Integer quantity;     		
	private double total_amt;    	
	private Date created_date; 		
	private Date modified_date;		
	
}
