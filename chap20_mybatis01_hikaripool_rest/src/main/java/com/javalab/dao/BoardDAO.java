package com.javalab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.javalab.vo.BoardVo;

/*
 * [매퍼 인터페이스]
 */
@Mapper
public interface BoardDAO {

	// 글 등록
	int insertBoard(BoardVo vo);

	// 글 수정
	void updateBoard(BoardVo vo);

	// 글 삭제
	void deleteBoard(BoardVo vo);

	// 글 상세 조회(queryForObject 메소드 사용)
	BoardVo getBoardById(BoardVo vo);

	// 글 목록 조회(query 메소드 사용)
	List<BoardVo> getBoardList(BoardVo vo);

	// 글조회수 증가
	void updateHit(BoardVo vo);	
	
	// 전체 게시물 숫자
	int getTotalBoardCount();

}