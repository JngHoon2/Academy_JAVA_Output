package com.magicoh.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.magicoh.springmvc.dto.Category;
import com.magicoh.springmvc.dto.Client;
import com.magicoh.springmvc.dto.InvoiceDetail;
import com.magicoh.springmvc.dto.InvoiceHeader;
import com.magicoh.springmvc.dto.InvoiceCommonDto;
import com.magicoh.springmvc.dto.Product;
import com.magicoh.springmvc.dto.QnaBbs;

/**
 * BBS 인터페이스 매퍼
 *  - 서비스 Layer와 매퍼XML을 연결시켜주는 역할
 */
//@Mapper
public interface IQnaBbsMapperDao
{
	public List<QnaBbs> selectQnaBbsList();
	public void insertQnaBbsList();
}
