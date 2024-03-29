package com.magicoh.springmvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.magicoh.springmvc.dto.Category;
import com.magicoh.springmvc.dto.Client;
import com.magicoh.springmvc.dto.InvoiceDetail;
import com.magicoh.springmvc.dto.InvoiceHeader;
import com.magicoh.springmvc.dto.InvoiceCommonDto;
import com.magicoh.springmvc.dto.Product;

/**
 * Product 인터페이스 매퍼
 *  - 서비스 Layer와 매퍼XML을 연결시켜주는 역할
 */
//@Mapper 
public interface IProductMapperDao
{
	//Category
	public List<Category> selectCategoryList();
	public List<Category> selectCategorysByName(Category category);
	public List<Category> selectCategorysByName2(String category);
	public Category selectCategory(int category_id);
	public void insertCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(int category_id);

	//Product
	public List<Product> selectProductList();
	public List<Product> selectProductsByName(String product_name);
	public List<Product> selectProductsByName2(Product product);
	public Product selectProduct(int product_id);
	public void insertProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int product_id);
	
	//Client
	public List<Client> selectClientList();
	public List<Client> selectClientsByName(String client);
	public Client selectClient(int client_id);
	public void insertClient(Client client);
	
	//Invoice
	public List<InvoiceCommonDto> getInvoiceList();
	public List<InvoiceCommonDto> getInvoiceListByCon(InvoiceCommonDto invoiceCommonDto);
	public List<InvoiceCommonDto> getInvoiceDetail(int invoice_id);
	public int getMaxInvoiceId();
	public InvoiceCommonDto selectInvoiceHeader(int invoice_no);
	public int insertInvoiceHeader(InvoiceHeader invoiceHeader);
	public void insertInvoiceDetail(InvoiceDetail invoiceDetail);
	public void insertInvoiceDetailsMulti(List<InvoiceDetail> invoiceDetails);	//insert from update processing
	public InvoiceHeader getInvoiceHeaderForUpdate(int invoice_id);
	public int updateInvoiceHeader(InvoiceHeader invoiceHeader);
	public int updateInvoiceDetailsMulti(List<InvoiceDetail> invoiceDetails);
	
}
