package com.javalab.spring.service;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javalab.spring.vo.BoardVo;

public interface BoardService {
	
	// 게시물 목록 조회 메소드
	ArrayList<BoardVo> selectBoardList();
	
	// 게시물 삭제 메소드
	int deleteBoard(int no);
	
	//한 명의 회원 조회 메소드
	BoardVo getBoardById(int no);
	
	//회원 수정 메소드
	int modifyBoard(BoardVo boardVo);
	
	//게시물 저장 메소드
	int insertBoard(BoardVo vo);
	
	//조회수 증가 메소드(게시물이 한 번 읽힐때마다 증가)
	void updateHitCount(int no);

}
