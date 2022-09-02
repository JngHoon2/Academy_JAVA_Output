package com.javalab.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.spring.common.Log4JAdvice;
import com.javalab.spring.common.LogAdvice;
import com.javalab.spring.dao.BoardDao;
import com.javalab.spring.vo.BoardVo;

/*
 [비즈니스 로직 - 서비스 Layer] 
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	private LogAdvice logAdvice;

	public BoardServiceImpl() {
		logAdvice = new LogAdvice();
	}

	@Override
	public void insertBoard(BoardVo vo) {

//		if(vo.getSeq() == 0){
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//		}
		this.boardDao.insertBoard(vo);
	}

	@Override
	public void modifyBoard(BoardVo vo) {

		this.boardDao.modifyBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {

		this.boardDao.deleteBoard(vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		return this.boardDao.getBoard(vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {

		return this.boardDao.getBoardList(vo);
	}
}