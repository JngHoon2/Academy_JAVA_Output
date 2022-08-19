package com.javalab.vo;

import java.sql.Date;

/**
 * 게시판 vo 클래스
 * @since 2020.02.05
 * @author javalab
 */
public class BoardVo {
	
	/** 번호 */
	private int no;
	/** 제목 */
	private String title;
	/** 내용 */
	private String content;
	/** 작성자ID */
	private String id;
	/** 조회수 */
	private int hit;
	/** 등록 일시 */
	private Date regdate;
	/** 그룹번호 */
	private int reply_ref;
	/** 그룹내순서 */
	private int reply_lev;	
	/** 들여쓰기 */
	private int reply_seq;
	
	public BoardVo() {
		super();
	}

	public BoardVo(String title, String content, String id) {
		this.title = title;
		this.content = content;
		this.id = id;
	}

	public BoardVo(int no, String title, String content, String id) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.id = id;
	}

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



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReply_ref() {
		return reply_ref;
	}

	public void setReply_ref(int reply_ref) {
		this.reply_ref = reply_ref;
	}

	public int getReply_lev() {
		return reply_lev;
	}

	public void setReply_lev(int reply_lev) {
		this.reply_lev = reply_lev;
	}

	public int getReply_seq() {
		return reply_seq;
	}

	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}

	public int getHit() {
		return hit;
	}



	public void setHit(int hit) {
		this.hit = hit;
	}




	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", id=" + id + ", hit=" + hit
				+ ", regdate=" + regdate + ", reply_ref=" + reply_ref + ", reply_lev=" + reply_lev + ", reply_seq="
				+ reply_seq + "]";
	}


}
