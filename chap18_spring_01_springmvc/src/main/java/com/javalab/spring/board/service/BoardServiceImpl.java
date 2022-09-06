package com.javalab.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.spring.board.advice.*;
import com.javalab.spring.board.dao.BoardDAOImpl;
import com.javalab.spring.board.vo.BoardVO;

/*
 [비즈니스 로직 - 서비스 Layer] 
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOImpl boardDao;

	private LogAdvice logAdvice;
	

	public BoardServiceImpl() {
		logAdvice = new LogAdvice();
	}

	@Override
	public int insertBoard(BoardVO vo) {
		
		int result = 0;
		
		if(vo.getNo() == 0){
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}
		
		result = this.boardDao.insertBoard(vo);
		result = this.boardDao.insertBoard(vo);
		
		return result;
	}

	@Override
	public void modifyBoard(BoardVO vo) {

		this.boardDao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {

		this.boardDao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return this.boardDao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {

		return this.boardDao.getBoardList(vo);
	}
}