package com.javalab.invoice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.invoice.dto.QnaBbs;


/**
 * BBS 인터페이스 매퍼
 *  - 서비스 Layer와 매퍼XML을 연결시켜주는 역할
 */
@Mapper
public interface IQnaBbsMapperDao
{
	public List<QnaBbs> selectQnaBbsList(QnaBbs vo);
	public void insertBoard(QnaBbs vo);
	public QnaBbs getBoardById(int no);
}
