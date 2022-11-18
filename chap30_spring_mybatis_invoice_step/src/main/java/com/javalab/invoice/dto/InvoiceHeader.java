package com.javalab.invoice.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString//(exclude={"product_name"})
public class InvoiceHeader {

	private Integer invoice_id;      	
	private Integer client_id;       		
	private Date invoice_date;       		
	private String shipping_address;	
	private double total_amt;       	
	private String description;    
	private Date created_date;   
	private Date modified_date;	
	
	private List<InvoiceDetail> invoiceDetails;
	
}
