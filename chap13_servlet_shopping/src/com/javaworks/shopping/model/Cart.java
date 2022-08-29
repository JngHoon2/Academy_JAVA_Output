package com.javaworks.shopping.model;

import java.sql.Date;

public class Cart extends Product{

	private String userId;
	private String productId;	
	private int quantity;
	private int unitPrice;
	private Date createDate;
	// 사용 편의를 위한 변수(DB에는 없지만 조회할 때 필요)
	private String createDateFrom;	   	
	private String createDateTo;
	
	public Cart() {
		super();
	}

	public Cart(String userId, String productId, int quantity, int unitPrice) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Cart(String userId, String productId, String productName, int quantity, int unitPrice) {
		super();
		this.userId = userId;
		this.productId = productId;
		super.setProductName(productName);
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateDateFrom() {
		return createDateFrom;
	}

	public void setCreateDateFrom(String createDateFrom) {
		this.createDateFrom = createDateFrom;
	}

	public String getCreateDateTo() {
		return createDateTo;
	}

	public void setCreateDateTo(String createDateTo) {
		this.createDateTo = createDateTo;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", createDate=" + createDate + ", createDateFrom=" + createDateFrom + ", createDateTo="
				+ createDateTo + "]";
	}


}
