package com.javalab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.vo.BoardVo;

@Mapper
public interface BoardDao {
	int insertBoard(BoardVo vo);
	int updateBoard(BoardVo vo);
	int deleteBoard(BoardVo vo);
	
	BoardVo getBoardById(BoardVo vo);
	
	List<BoardVo> getBoardList(BoardVo vo);
	
	void updateHit(BoardVo vo);
	
	int getTotalBoardCount();
}
