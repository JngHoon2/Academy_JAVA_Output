package com.javalab.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.spring.common.LogAdvice;
import com.javalab.spring.dao.BoardDao;
import com.javalab.spring.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	// 멤버 변수
	@Autowired
	private BoardDao boardDao; // BoardDao 객체 자동주입
	
	private LogAdvice logAdvice;

	public BoardServiceImpl() {
		super();
		logAdvice = new LogAdvice();
	}

	@Override
	public ArrayList<BoardVo> selectBoardList() {
		logAdvice.printLog();
		ArrayList<BoardVo> boardList = boardDao.selectBoardList();
		return boardList;
	}

	@Override
	public int deleteBoard(int no) {
		logAdvice.printLog();
		int result = 0;
		result = boardDao.deleteBoard(no);
		return result;
	}

	@Override
	public BoardVo getBoardById(int no) {
		logAdvice.printLog();
		BoardVo boardVo = null;
		updateHitCount(no); // 게시물 조회수 업데이트
		boardVo = boardDao.getBoardById(no);
		return boardVo;
	}

	@Override
	public int modifyBoard(BoardVo boardVo) {
		logAdvice.printLog();
		int result = 0;
		result = boardDao.modifyBoard(boardVo);
		return result;
	}

	@Override
	public int insertBoard(BoardVo vo) {
		logAdvice.printLog();
		int result = 0;
		result = boardDao.insertBoard(vo);
		return result;
	}

	@Override
	public void updateHitCount(int no) {
		logAdvice.printLog();
		boardDao.updateHitCount(no);

	}

}
