package com.javalab.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.BoardDao;
import com.javalab.vo.BoardVo;
import com.javalab.vo.Criteria;

import lombok.extern.slf4j.Slf4j;


@Service("boardService")
@Slf4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDAO;

	public BoardServiceImpl() {
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		log.info("getBoardList(from BoardServiceImpl) 메소드 실행!");
		log.info(vo.toString());
		List<BoardVo> boardList = boardDAO.getBoardList(vo);
		log.info("boardList.size() : " + boardList.size());
		return boardList;
	}	
	
	@Override
	public BoardVo getBoardById(BoardVo vo) {
		log.info("getBoardById(from BoardServiceImpl) 메소드 실행!");
		return this.boardDAO.getBoardById(vo);
	}
	
	@Override
	public int insertBoard(BoardVo vo) {
		log.info("insertBoard(from BoardServiceImpl) 메소드 실행!");
		int result = 0;
		result = this.boardDAO.insertBoard(vo);
		return result;
	}

	@Override
	public void updateBoard(BoardVo vo) {
		log.info("updateBoard(from BoardServiceImpl) 메소드 실행!");
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		log.info("deleteBoard(from BoardServiceImpl) 메소드 실행!");
		this.boardDAO.deleteBoard(vo);
	}
	
	@Override
	public void updateHit(BoardVo vo) {
		log.info("updateHit(from BoardServiceImpl) 메소드 실행!");
		this.boardDAO.updateHit(vo);
	}
	
	@Override
	public int getTotalBoardCount(Criteria cri) {
		log.info("getTotalBoardCount(from BoardServiceImpl) 메소드 실행!");
		return this.boardDAO.getTotalBoardCount(cri);
	}

	@Override
	public List<BoardVo> getListPagingAndSearching(Criteria cri) {
		log.info("getListPagingAndSearching(from BoardServiceImpl) 메소드 실행!");
		log.info(cri.toString());
		List<BoardVo> boardList = boardDAO.getListPagingAndSearching(cri);
		return boardList;
	}
	
	

}