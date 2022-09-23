package com.javalab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.dao.BoardDao;
import com.javalab.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;


@Service("boardService")
@Slf4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	public BoardServiceImpl() {
	}

	
	@Override
	public int insertBoard(BoardVo vo) {

		int result = 0;
		result = this.boardDao.insertBoard(vo);
		return result;
	}

	@Override
	public void updateBoard(BoardVo vo) {
		this.boardDao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		this.boardDao.deleteBoard(vo);
	}

	@Override
	public BoardVo getBoardById(BoardVo vo) {
		return this.boardDao.getBoardById(vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		log.info(vo.toString());
		List<BoardVo> boardList = boardDao.getBoardList(vo);
		log.info("voardList.size() : "+boardList.size());
		return boardList;
	}


	@Override
	public void updateHit(BoardVo vo) {
		// TODO Auto-generated method stub
		this.boardDao.updateHit(vo);
	}


	@Override
	public int getTotalBoardCount() {
		// TODO Auto-generated method stub
		return this.boardDao.getTotalBoardCount();
	}

}
