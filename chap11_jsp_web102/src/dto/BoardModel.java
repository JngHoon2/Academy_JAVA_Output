package dto;
/** dto, vo 역할 **/
public class BoardModel {

	/** 외부 접근 불가능 : 값추출 : get~~() return /  값설정 : set~~~(매개변수) **/
	private int no = 0;
	private String subject = null;
	private String writer = null;
	private String contents = null;
	private int hit = 0;

	 // 페이징(pagination) field
	 private String pageNum = "1";		//페이지 번호
	 private Integer listCount = 5;	//1페이지당 게시물수
	 private Integer pagePerBlock = 5;	//한 번에 보여질 페이지번호 갯수
	
	
	public BoardModel() {
	}
	
	public BoardModel(int no, String subject, String writer, String contents) {
		super();
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.contents = contents;
	}

	public BoardModel(int no, String subject, String writer, String contents, int hit) {
		super();
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.contents = contents;
		this.hit = hit;
	}

	/** 아래는 private 변수들에 대한 getter/setter 들  **/
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
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
		return "BoardModel [no=" + no + ", subject=" + subject + ", writer=" + writer + ", contents=" + contents
				+ ", hit=" + hit + ", pageNum=" + pageNum + ", listCount=" + listCount + ", pagePerBlock="
				+ pagePerBlock + "]";
	}	
}
