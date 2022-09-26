package com.javalab.service;

import java.util.List;

import com.javalab.vo.BoardVo;


public interface BoardService {

	/** CRUD 기능 메서드 구현 **/
	// 글 등록
	int insertBoard(BoardVo vo); 

	// 글 수정
	void updateBoard(BoardVo vo); 

	// 글 삭제
	void deleteBoard(BoardVo vo); 

	// 글 상세 조회
	BoardVo getBoardById(BoardVo vo); 

	// 글 목록 조회
	List<BoardVo> getBoardList(BoardVo vo); 
	
	// 글 조회수 증가
	void updateHit(BoardVo vo);
	
	// 전체 게시물 숫자
	int getTotalBoardCount();

}

