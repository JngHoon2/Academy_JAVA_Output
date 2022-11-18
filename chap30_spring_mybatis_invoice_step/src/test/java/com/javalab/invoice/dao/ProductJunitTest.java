package com.javalab.invoice.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.invoice.dto.Category;
import com.javalab.invoice.dto.Client;
import com.javalab.invoice.dto.CustomUser;
import com.javalab.invoice.dto.InvoiceCommonDto;
import com.javalab.invoice.dto.InvoiceDetail;
import com.javalab.invoice.dto.InvoiceHeader;
import com.javalab.invoice.dto.Product;
import com.javalab.invoice.dto.UserRole;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/application-context.xml"
      })
@Slf4j
@RequiredArgsConstructor
public class ProductJunitTest {
	/*
	 * 카테고리, 상품, 거래처(Client) 관련 테스트
	 */
	@Inject
	private IProductMapperDao dao;
	
	// dao 인터페이스 빈 생성 유무 확인
	@Test  @Ignore 
	public void testDao() {
		assertNotNull(this.dao);
	}

	// 카테고리 조회 테스트
	@Test @Ignore   
	public void testGetCategoryList() {
		List<Category> categories = dao.selectCategoryList();
		categories.stream().forEach(c -> log.info(c.toString()));
	}

	// 카테고리 등록 테스트
	@Test    
	public void testInsertCategory() {
		Category category = new Category();
		category.setCategory_id(10);
		category.setCategory_name("New Category11");
		category.setIs_active(1);
		category.setDescription("New Category11 description");
		
		dao.insertCategory(category);
		log.info("카테고리 저장 성공");
		
		List<Category> categories = dao.selectCategoryList();
		categories.stream().forEach(c -> log.info(c.toString()));
	}

	// 상품 조회
	@Test   @Ignore 
	public void testGetProductList() {
		List<Product> products = dao.selectProductList();
		products.stream().forEach(p -> log.info(p.toString()));
	}
	
	// 상품 등록
	@Test @Ignore 
	public void testInsertProduct() {
//		Product product = new Product();
//		product.setProduct_name("새로운 상품02");
//		product.setBrand("SAMSUNG");
//		product.setDescription("설명2");
//		product.setUnit_price(2000000);
//		product.setCategory_id(1);
//		product.setReceipt_date(new Date());
//		
//		dao.insertProduct(product);
	}
	
	// 거래처(Client) 조회
	@Test @Ignore
	public void testClientList() {
		List<Client> clients = dao.selectClientList();
		clients.stream().forEach(c -> log.info(c.toString()));
	}	
	
	// 거래처 등록
	@Test @Ignore
	public void testInsertClient() {
		Client client = new Client();
		client.setClient_name("새로운 거래처10");
		client.setAddress("주소지");
		client.setEmail("a@ac.com");
		client.setFax("010");
		client.setIs_active('1');
		client.setPostal_code("1234");

		dao.insertClient(client);
	}	
	
	// 인보이스 조회
	@Test
	public void testGetInvoiceList() {
		List<InvoiceCommonDto> invoices = dao.getInvoiceList();
		invoices.stream().forEach(invoice -> log.info(invoice.toString()));
	}
	
	// 인보이스  헤더만 등록
	@Test @Ignore
	public void testInsertInvoiceHeader() {
		InvoiceHeader header = new InvoiceHeader();
		header.setInvoice_id(26);
		header.setClient_id(1);
		header.setTotal_amt(10000);
		header.setInvoice_date(new Date());
		header.setShipping_address("서울");
		header.setDescription("desc");

		dao.insertInvoiceHeader(header);
	}	
	
	// 인보이스  헤더 + 디테일 동시 등록
	@Test @Ignore
	public void testInsertDetail() {
		// 인보이스 헤더 데이터 생성
		InvoiceHeader header = new InvoiceHeader();
		header.setInvoice_id(25);
		header.setClient_id(1);
		header.setTotal_amt(10000);
		header.setInvoice_date(new Date());
		header.setShipping_address("서울");
		header.setDescription("desc");

		// 인보이스 디테일 보관용 ArrayList 생성
		List<InvoiceDetail> detailList = new ArrayList<InvoiceDetail>();

		// 상품1
		InvoiceDetail detail = new InvoiceDetail();
		detail.setInvoice_id(25);
		detail.setProduct_id(1);
		detail.setProduct_name("냉장고");
		detail.setQuantity(5);
		detail.setUnit_price(1000);
		detail.setTotal_amt(5000);
		
		// 상품1 리스트에 추가
		detailList.add(detail);
		
		// 상품2 생성
		InvoiceDetail detail2 = new InvoiceDetail();
		detail2.setInvoice_id(25);
		detail2.setProduct_id(2);
		detail2.setProduct_name("에어컨");
		detail2.setQuantity(5);
		detail2.setUnit_price(1000);
		detail2.setTotal_amt(5000);
		
		// 상품2 리스트에 추가
		detailList.add(detail2);
		
		// 헤더 디비 저장
		dao.insertInvoiceHeader(header);
		// 디테일 리스트 저장
		dao.insertInvoiceDetailsMulti(detailList);		
	}
	
	
}