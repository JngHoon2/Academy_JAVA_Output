package com.javalab.invoice.service.product;


import java.util.List;

import com.javalab.invoice.dto.QnaBbs;

public interface IQnaBbsService
{
	public List<QnaBbs> getQnaBbsList(QnaBbs vo);
	public void insertBoard(QnaBbs vo);
	public QnaBbs getBoardById(int no);
	
//	public List<Product> getProductsByName(String product_name);
//	public List<Product> getProductsByName2(Product product);
//	public Product getProduct(int product_id);
//	public void updateProduct(Product product);
//	public void deleteProduct(int product_id);

}
