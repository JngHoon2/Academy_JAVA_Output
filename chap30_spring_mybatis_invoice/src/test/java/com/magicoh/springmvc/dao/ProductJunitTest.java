package com.magicoh.springmvc.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.magicoh.springmvc.dto.Category;
import com.magicoh.springmvc.dto.Client;
import com.magicoh.springmvc.dto.InvoiceCommonDto;
import com.magicoh.springmvc.dto.InvoiceDetail;
import com.magicoh.springmvc.dto.InvoiceHeader;
import com.magicoh.springmvc.dto.Product;

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
   @Test @Ignore
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
      Product product = new Product();
      product.setProduct_name("새로운 상품02");
      product.setBrand("SAMSUNG");
      product.setDescription("설명2");
      product.setUnit_price(2000000);
      product.setCategory_id(1);
      product.setReceipt_date(new Date());
      
      dao.insertProduct(product);
   }
   
   // 거래처(Client) 조회
   @Test @Ignore
   public void testClientList() {
      List<Client> clients = dao.selectClientList();
      clients.stream().forEach(c -> log.info(c.toString()));
   }   
   
   // 클라이언트 저장 테스트
   @Test @Ignore
   public void testInsertClient() {
      Client client = new Client();
      client.setClient_name("GS");
      client.setAddress("서울시 영등포구");
      client.setPhone("010-2222-3333");
      client.setPostal_code("12345");
      client.setFax("010-3333-5555");
      client.setEmail("m@a.com");
      client.setIs_active('1');
      
      dao.insertClient(client);
   }
   
   // 인보이스 조회
   @Test @Ignore
   public void testGetInvoiceList() {
	   List<InvoiceCommonDto> list = dao.getInvoiceList();
	   for(InvoiceCommonDto l : list) {
		   log.info(l.toString());
	   }
   }
   
   // 인보이스 헤더만 등록
   @Test @Ignore
   public void testInsertInvoiceHeader() {
	   InvoiceHeader header = new InvoiceHeader();
	   header.setInvoice_id(22);
	   header.setClient_id(1);
	   header.setTotal_amt(10000);
	   header.setInvoice_date(new Date());
	   header.setShipping_address("서울");
	   header.setDescription("desc");
	   
	   dao.insertInvoiceHeader(header);
	   
   }
   
   // 인보이스 헤더 + 디테일 동시 등록
   @Test
   public void testInsertDetail() {
	   InvoiceHeader header = new InvoiceHeader();
	   header.setInvoice_id(99);
	   header.setClient_id(1);
	   header.setTotal_amt(10000);
	   header.setInvoice_date(new Date());
	   header.setShipping_address("서울");
	   header.setDescription("desc");
	   
	   // 인보이스 디테일 보관용 ArrayList 생성
	   List<InvoiceDetail> detailList = new ArrayList<InvoiceDetail>();
	   
	   // 상품1 
	   InvoiceDetail detail = new InvoiceDetail();
	   detail.setInvoice_id(28);
	   detail.setProduct_id(1);
	   detail.setProduct_name("냉장고");
	   detail.setQuantity(5);
	   detail.setUnit_price(1000);
	   detail.setTotal_amt(5000);
	   
	   // 상품1 리스트에 추가
	   detailList.add(detail);
	   
	   // 상품2 
	   InvoiceDetail detail2 = new InvoiceDetail();
	   detail.setInvoice_id(28);
	   detail.setProduct_id(2);
	   detail.setProduct_name("에어컨");
	   detail.setQuantity(5);
	   detail.setUnit_price(1000);
	   detail.setTotal_amt(5000);
	   
	   // 상품2 리스트에 추가
	   detailList.add(detail2);
	   
	   // 헤더 디비 저
	   dao.insertInvoiceHeader(header);
	   
	   // 디테일 리스트 저장
	   dao.insertInvoiceDetailsMulti(detailList);
   }
}