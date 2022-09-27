package com.javalab.vo;

import lombok.*;

@Getter
@ToString
public class PageDto {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDto(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// 끝 페이지 번호
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		// 시작 페이지 번호
		this.startPage = this.endPage - 9;
		// 실제 끝 페이지 번호
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		// 끝 페이지 번호 다시 계산
		if(realEnd <= this.endPage) { // 실제 끝 번호보다 endPage보다 큰 경우
			this.endPage = realEnd;	// 실제 끝 페이지 번호가 끝페이지 번호가 됨.
		}
		// 이전은 시작페이지 번호가 1보다 크면존재
		this.prev = this.startPage > 1;
		
		// 다음은 끝페이지 번호가 실제 페이지 번호보다 작으면 존재
		this.next = this.endPage < realEnd;
	}
	
}
