package com.javalab.spring.board.service;

import java.util.List;

import com.javalab.spring.board.vo.BoardVO;

public interface BoardService {

	/** CRUD 기능 메서드 구현 
	 * @return **/
	int insertBoard(BoardVO vo); 

	// 글 수정
	void modifyBoard(BoardVO vo); 

	// 글 삭제
	void deleteBoard(BoardVO vo); 

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo); 

	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo); 

}