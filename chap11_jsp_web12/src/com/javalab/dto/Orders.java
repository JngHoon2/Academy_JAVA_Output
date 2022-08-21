package com.javalab.dto;

import java.sql.Date;

public class Orders {

	private Integer order_no;
	private String member_id;
	private Date order_date;

	 //pagination field
	 private String pageNum = "1";	//페이지 번호
	 private String searchText = "";//조회 키워드
	 private Integer listCount = 10;	//1페이지당 게시물수
	 private Integer pagePerBlock = 5;	//한 번에 보여질 페이지번호 갯수
	
	
	public Orders() {
	}
	
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
	
	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Integer getListCount() {
		return listCount;
	}

	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}

	public Integer getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(Integer pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	@Override
	public String toString() {
		return "Orders [order_no=" + order_no + ", member_id=" + member_id + ", order_date=" + order_date + "]";
	}
	
	
	
}
