package com.javalab.chap33_01_jap_project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity 클래스
 * - 엔티티 클래스를 영속 영역에서 관리하게 된다.
 */
@Entity	// 나는 JPA에서 관리하는 엔티티 클래스임.
@Table(name="board")
public class Board implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// BoardInsertClientIdentity로 테스트
	private int seq;
	
	// 매핑 정보가 없는 필드들은 자동으로 테이블의 컬럼과 매핑
	private String title;
	private String writer;
	private String content;	
	private int cnt;
	private int category_no;
	
	// 날짜 타입의 변수에 선언하여 날짜 타입 매핑
	@Temporal(TemporalType.DATE)
	private Date regDate = new Date();
	
	@Temporal(TemporalType.DATE)
	private Date modifiedDate = new Date();
	
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}	
	
	
	
}
