package com.javalab.invoice.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.javalab.invoice.dto.CustomUser;
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
public class InvoiceJunitTest {

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
	@Test @Ignore    
	public void testInsertCategory() {
		Category category = new Category();
		category.setCategory_id(10);
		category.setCategory_name("New Category10");
		category.setIs_active(1);
		category.setDescription("New Category1 description");
		
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
	@Test
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
//		
		
	}
}