package com.javalab.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.BoardDAO;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;

import lombok.extern.slf4j.Slf4j;


@Service("boardService")
@Slf4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		log.info(vo.toString());
		List<BoardVo> boardList = boardDAO.getBoardList(vo);
		log.info("boardList.size() : " + boardList.size());
		return boardList;
	}	
	
	@Override
	public BoardVo getBoardById(BoardVo vo) {
		return this.boardDAO.getBoardById(vo);
	}
	
	@Override
	public int insertBoard(BoardVo vo) {

		int result = 0;
		result = this.boardDAO.insertBoard(vo);
		return result;
	}

	@Override
	public void updateBoard(BoardVo vo) {
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		this.boardDAO.deleteBoard(vo);
	}
	
	@Override
	public void updateHit(BoardVo vo) {
		this.boardDAO.updateHit(vo);
	}
	
	@Override
	public int getTotalBoardCount(Criteria cri) {
		return this.boardDAO.getTotalBoardCount(cri);
	}
	
	@Override
	public List<BoardVo> getListPagingAndSearch(Criteria cri){
		log.info(cri.toString());
		List<BoardVo> boardList = boardDAO.getListPagingAndSearch(cri);
		return boardList;
	}

}