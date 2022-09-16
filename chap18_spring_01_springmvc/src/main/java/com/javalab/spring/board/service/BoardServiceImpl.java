package com.javalab.spring.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.spring.board.dao.BoardDAO;
import com.javalab.spring.board.dao.BoardDAOImpl;
import com.javalab.spring.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDAO boardDAO;

	public BoardServiceImpl() {
	}

	@Override
	public int insertBoard(BoardVO vo) {

		int result = 0;
		result = this.boardDAO.insertBoard(vo);
		return result;
	}

	@Override
	public void updateBoard(BoardVO vo) {
		this.boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		this.boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return this.boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		logger.debug(vo.toString());
		return this.boardDAO.getBoardList(vo);
	}

}
