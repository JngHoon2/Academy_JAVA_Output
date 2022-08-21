package com.javalab.dto;

public class Address {

	private String zip_num;
	private String sido;
	private String gugun;
	private String dong;
	private String zip_code;
	private String bunji;

	 //pagination field
	 private String pageNum = "1";	//페이지 번호
	 private String searchText = "";//조회 키워드
	 private Integer listCount = 10;	//1페이지당 게시물수
	 private Integer pagePerBlock = 5;	//한 번에 보여질 페이지번호 갯수
	
	public Address() {
	}

	public String getZip_num() {
		return zip_num;
	}

	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
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

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	@Override
	public String toString() {
		return "Address [zip_num=" + zip_num + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", zip_code="
				+ zip_code + ", bunji=" + bunji + ", pageNum=" + pageNum + ", searchText=" + searchText + ", listCount="
				+ listCount + ", pagePerBlock=" + pagePerBlock + "]";
	}



}
