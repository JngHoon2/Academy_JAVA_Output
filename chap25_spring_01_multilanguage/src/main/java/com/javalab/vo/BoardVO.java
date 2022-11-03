package com.javalab.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;


/** VO : Value Object **/

public class BoardVO {

	private int no;
	private String title;
	private String id;
	private String content;
	private Date regDate;
	private int hit;
	
	/** 파일 업로드 변수 추가 **/
	private MultipartFile uploadFile;
	
	public BoardVO() {
	}

	/** getter/setter **/
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", id=" + id + ", content=" + content + ", regDate="
				+ regDate + ", hit=" + hit + ", uploadFile=" + uploadFile + "]";
	}


	
}
