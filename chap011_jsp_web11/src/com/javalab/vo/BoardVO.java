package com.javalab.vo;

import java.sql.Date;

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	public BoardVO() {
		super();
	}

	public BoardVO(int no, String title, String content, String writer, Date regdate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	
	
	public BoardVO(int no, String title, String content, String writer) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardVO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}


	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the contents
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * @return the regdate
	 */
	public Date getRegdate() {
		return regdate;
	}

	/**
	 * @param id the id to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContent(String contents) {
		this.content = contents;
	}

	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
