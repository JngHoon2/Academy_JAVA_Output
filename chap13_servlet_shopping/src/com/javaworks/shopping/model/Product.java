package com.javaworks.shopping.model;

import java.sql.Date;

public class Product {
	// 멤버 변수(데이터베이스 필드)
	private String productId;
	private String productName;
	private String categoryId;
	private int unitPrice;
	private String image;
	private Date createDate;
	// 사용 편의를 위한 변수
	private String categoryName;
	private String createDateFrom;	   	
	private String createDateTo;	  
	
	// 기본 생성자
	public Product() {
		super();
	}

	public Product(String productId, String productName, String categoryId, int unitPrice, String image,
			Date createDate, String categoryName, String createDateFrom, String createDateTo) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.unitPrice = unitPrice;
		this.image = image;
		this.createDate = createDate;
		this.categoryName = categoryName;
		this.createDateFrom = createDateFrom;
		this.createDateTo = createDateTo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
		return "Product [productId=" + productId + ", productName=" + productName + ", categoryId=" + categoryId
				+ ", unitPrice=" + unitPrice + ", image=" + image + ", createDate=" + createDate + ", categoryName="
				+ categoryName + ", createDateFrom=" + createDateFrom + ", createDateTo=" + createDateTo + "]";
	}
	
	
	
}
