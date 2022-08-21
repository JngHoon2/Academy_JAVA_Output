package com.javalab.dto;

public class Order_item {
	
	private Integer item_no;
	private Integer order_no;
	private Integer product_code;
	private Integer quantity;
	private String result;
	
	public Order_item() {
	}

	public Integer getItem_no() {
		return item_no;
	}

	public void setItem_no(Integer item_no) {
		this.item_no = item_no;
	}

	public Integer getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
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

	@Override
	public String toString() {
		return "Order_item [item_no=" + item_no + ", order_no=" + order_no + ", product_code=" + product_code
				+ ", quantity=" + quantity + ", result=" + result + "]";
	}
	
}
