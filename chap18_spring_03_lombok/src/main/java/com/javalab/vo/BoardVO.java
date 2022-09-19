package com.javalab.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/** VO : Value Object **/
//@Data
@Getter				// 게터 생성 
@Setter				// 세터 생성 
@NoArgsConstructor	// 기본 생성자 생성
@AllArgsConstructor // 모든 클래스 변수를 파라미터로 가지는 생성자 생성
@ToString 			// toString 메소드 생성

public class BoardVO {

	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int hit;

	
	/** 파일 업로드 변수 추가 **/
	private MultipartFile uploadFile;
	
//	public BoardVO() {
//	}
//
//	@Override
//	public String toString() {
//		String values = "";
//		values += "BoardVO [no=" + this.no; 
//		values +=  ", title=" + this.title;
//		values +=  ", writer=" + this.writer;
//		values +=  ", content=" + this.content;
//		values +=  ", regDate=" + this.regDate;
//		values +=  ", hit=" + this.hit;
//		values += ']';
//		return values;
//	}
//
//	/** getter/setter **/
//	public int getNo() {
//		return no;
//	}
//
//	public void setNo(int no) {
//		this.no = no;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public Date getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(Date regDate) {
//		this.regDate = regDate;
//	}
//
//	public int getHit() {
//		return hit;
//	}
//
//	public void setHit(int hit) {
//		this.hit = hit;
//	}
//
//	public MultipartFile getUploadFile() {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
}
