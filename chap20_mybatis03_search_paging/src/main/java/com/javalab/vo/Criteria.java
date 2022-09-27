package com.javalab.vo;

import lombok.*;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum = 1;
	private int amount = 10;
	private String searchText = "";
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public Criteria(String searchText) {
		super();
		this.searchText = searchText;
	}
}
