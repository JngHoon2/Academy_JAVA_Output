package com.javalab.invoice.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.invoice.dao.IQnaBbsMapperDao;
import com.javalab.invoice.dto.QnaBbs;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaBbsServiceImpl implements IQnaBbsService
{
	@Autowired
	private IQnaBbsMapperDao mapperDao;

	@Override
	public List<QnaBbs> getQnaBbsList(QnaBbs vo) {
		List<QnaBbs> qnaBbsList = mapperDao.selectQnaBbsList(vo);
		return qnaBbsList;

	}

	@Override
	public void insertBoard(QnaBbs vo) {
		this.mapperDao.insertBoard(vo);
	}

	@Override
	public QnaBbs getBoardById(int no) {
		QnaBbs vo = this.mapperDao.getBoardById(no); 
		return vo;
	}


}
