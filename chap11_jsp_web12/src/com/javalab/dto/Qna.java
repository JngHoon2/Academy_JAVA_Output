package com.javalab.dto;

public class Qna {

	private Integer no;
	private String subject;
	private String content;
	private String reply;
	private String member_id;
	private String replyn;
	private String regdate;
	
	 //pagination field
	 private String pageNum = "1";	//페이지 번호
	 private String searchText = "";//조회 키워드
	 private Integer listCount = 10;	//1페이지당 게시물수
	 private Integer pagePerBlock = 5;	//한 번에 보여질 페이지번호 갯수
	
	
	public Qna() {
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getReplyn() {
		return replyn;
	}

	public void setReplyn(String replyn) {
		this.replyn = replyn;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
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
		return "Qna [no=" + no + ", subject=" + subject + ", content=" + content + ", reply=" + reply + ", member_id="
				+ member_id + ", replyn=" + replyn + ", regdate=" + regdate + "]";
	}

	


}
