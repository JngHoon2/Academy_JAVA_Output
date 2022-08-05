package board.vo;

import java.sql.Date;

public class Board {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
	public Board() {}

	public Board(int no, String title, String content, String writer, Date regDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
