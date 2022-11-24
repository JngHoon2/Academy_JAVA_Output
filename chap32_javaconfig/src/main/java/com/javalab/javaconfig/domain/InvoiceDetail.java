package com.javalab.javaconfig.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	// 자바 객체 -> json type으로 변환 될 때 yyyy-mm-dd 형태로 바뀌도록 설정
	// 이 설정 없으면 정수 형태로 jsp로 전송됨
	@JsonFormat(pattern = "yyyy-MM-dd")	
	private Date created_date; 		
	// 자바 객체 -> json type으로 변환 될 때 yyyy-mm-dd 형태로 바뀌도록 설정
	// 이 설정 없으면 정수 형태로 jsp로 전송됨
	@JsonFormat(pattern = "yyyy-MM-dd")	
	private Date modified_date;		
	
}
