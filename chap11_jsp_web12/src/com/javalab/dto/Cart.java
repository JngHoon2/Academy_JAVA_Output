package com.javalab.dto;

import java.sql.Date;

public class Cart {

	private Integer cart_no;
	private String member_id;
	private Integer product_code;
	private Integer quantity;
	private String result;
	private Date regdate;
	
	public Integer getCart_no() {
		return cart_no;
	}
	public void setCart_no(Integer cart_no) {
		this.cart_no = cart_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Integer getProduct_code() {
		return product_code;
	}
	public void setProduct_code(Integer product_code) {
		this.product_code = product_code;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", member_id=" + member_id + ", product_code=" + product_code
				+ ", quantity=" + quantity + ", result=" + result + ", regdate=" + regdate + "]";
	}
	
	
	
}
