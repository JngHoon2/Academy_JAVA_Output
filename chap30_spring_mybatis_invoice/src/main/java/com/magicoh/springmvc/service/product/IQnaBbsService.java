package com.magicoh.springmvc.service.product;


import java.util.List;

import com.magicoh.springmvc.dto.QnaBbs;

public interface IQnaBbsService
{
	public List<QnaBbs> getQnaBbsList();
	public void insertQna();
	
//	public List<Product> getProductsByName(String product_name);
//	public List<Product> getProductsByName2(Product product);
//	public Product getProduct(int product_id);
//	public void insertProduct(Product product);
//	public void updateProduct(Product product);
//	public void deleteProduct(int product_id);
}
