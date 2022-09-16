package com.javalab.spring.board.dao;

import java.util.List;

import com.javalab.spring.board.vo.BoardVO;

public interface BoardDAO {

	// 글 등록
	int insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회(queryForObject 메소드 사용)
	BoardVO getBoard(BoardVO vo);

	// 글 목록 조회(query 메소드 사용)
	List<BoardVO> getBoardList(BoardVO vo);

}