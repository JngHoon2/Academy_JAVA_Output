package com.javalab.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDto {

	private int startPage;
	private int endPage;
	private boolean prev, next;

	private int total;
	private Criteria cri;

	// 오버로딩 생성자
	public PageDto(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// 끝 페이지 번호
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		// 시작 페이지 번호
		this.startPage = this.endPage - 9;
		// 실제 끝 페이지 번호
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		// 끝 페이지번호 다시 계산
		if (realEnd <= this.endPage) { // 만약 구해둔 endPage가 실제 끝번호보다 큰 경우
			this.endPage = realEnd; // 실제 끝페이지번호가 끝페이지번호가 됨
		}
		// 이전(<)은 시작 페이지번호가 1보다 크면 존재
		this.prev = this.startPage > 1;
		// 다음(>)은 구해둔 끝페이지가 실제 페이지번호보다 작으면 존재
		this.next = this.endPage < realEnd;
	}

}
