package com.javalab.spring.service;

import java.util.List;

import com.javalab.spring.vo.BoardVo;

public interface BoardService {

	/** CRUD 기능 메서드 구현 **/
	// 글 등록
	void insertBoard(BoardVo vo); 

	// 글 수정
	void modifyBoard(BoardVo vo); 

	// 글 삭제
	void deleteBoard(BoardVo vo); 

	// 글 상세 조회
	BoardVo getBoard(BoardVo vo); 

	// 글 목록 조회
	List<BoardVo> getBoardList(BoardVo vo); 

}