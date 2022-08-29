package com.javaworks.shopping.model;

import java.util.List;

public class OrderHeader {

	private int orderId;		//주문번호(PK)
	private String userId;		//고객ID
	private String email;		//이메일
	private String phoneNumber; //전화번호
	private String address;		//주소
	private int totalAmt;		//주문총액
	private String status;		//주문상태(0-입금전/1-입금/2-배송전/3-배송중/4-도착/5-반품
	private String paymentMethod;//결제방법(0-현금/1-카드/2-휴대폰결제)
	private String createDate;	//주문일자
	private List<OrderItem> orderItems;	//주문상세
	
	public OrderHeader() {
		super();
	}	

	public OrderHeader(int orderId, String userId, String email, String phoneNumber, String address, int totalAmt,
			String status, String paymentMethod, String createDate, List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.totalAmt = totalAmt;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.createDate = createDate;
		this.orderItems = orderItems;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderHeader [orderId=" + orderId + ", userId=" + userId + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", totalAmt=" + totalAmt + ", status=" + status
				+ ", paymentMethod=" + paymentMethod + ", createDate=" + createDate + ", orderItems=" + orderItems
				+ "]";
	}
}
