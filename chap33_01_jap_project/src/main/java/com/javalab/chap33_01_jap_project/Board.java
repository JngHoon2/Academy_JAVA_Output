package com.javalab.chap33_01_jap_project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board
 * - 엔티티 클래스를 영속 영역에서 관리하게 된다.
 */
@Entity
@Table(name="board")
public class Board implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	
	// 매핑 정보가 없는 필드들은 자동으로 테이블의 컬럼과 매
	private String title;
	private String writer;
	private String content;
	private int cnt;
	private int category_no;
	
	@Temporal(TemporalType.DATE)
	private Date regDate = new Date();
    
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", cnt=" + cnt
				+ ", category_no=" + category_no + ", regDate=" + regDate + "]";
	}

}
