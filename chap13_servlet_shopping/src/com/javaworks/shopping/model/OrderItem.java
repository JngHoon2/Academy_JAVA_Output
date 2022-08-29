package com.javaworks.shopping.model;

public class OrderItem extends Product{
	
	private int orderItemId;
	private int orderId;
	private String productId;
	private int quantity;
	private int unitPrice;
	private int amt;
	private String createDate;
	
	public OrderItem() {
		super();
	}

	public OrderItem(int orderItemId, int orderId, String productId, int quantity, int unitPrice,
			int amt, String createDate) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.amt = amt;
		this.createDate = createDate;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", amt=" + amt + ", createDate=" + createDate
				+ "]";
	}

	
	
}
