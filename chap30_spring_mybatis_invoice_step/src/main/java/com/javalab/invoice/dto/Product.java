package com.javalab.invoice.dto;
import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/****************************************************************
 * 
 * This is a Product Model Object
 * [1] temporary variables for the convenience of query work
 * [2] conversion of date type between Oracle and model object
 *     setReceipt_date_from(), setReceipt_date_to()
 * Created by : magicoh
 * Date : 2020.11.04
 *   
 ****************************************************************/
@Getter
@Setter
@NoArgsConstructor
@ToString//(exclude={"product_name"})
public class Product implements Serializable{

	
	private static final long serialVersionUID = 8775250577999383759L;
	private int product_id;			
	private String product_name;
	private String brand;        	
	private int category_id; 		
	private String category_name;  	
	private String description;  	
	private double unit_price;   	
	private int is_active;	   	
	private Date receipt_date;	
	
	//[for query works] These two variables are temporary variables for the convenient query works.
	private String receipt_date_from;	   	
	private String receipt_date_to;	   	
	
}
