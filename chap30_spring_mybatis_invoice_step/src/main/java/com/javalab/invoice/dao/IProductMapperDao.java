package com.javalab.invoice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.invoice.dto.Category;
import com.javalab.invoice.dto.Client;
import com.javalab.invoice.dto.InvoiceCommonDto;
import com.javalab.invoice.dto.InvoiceDetail;
import com.javalab.invoice.dto.InvoiceHeader;
import com.javalab.invoice.dto.Product;

/**
 * Product 인터페이스 매퍼
 *  - 서비스 Layer와 매퍼XML을 연결시켜주는 역할
 *  - 카테고리, 상품, 거래처, 인보이스 관련 기능이 복합적으로 구현됨
 */
@Mapper 
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
