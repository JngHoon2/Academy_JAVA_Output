package com.javalab.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.javalab.rest.domain.Ticket;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
      })
@Slf4j
@WebAppConfiguration 
public class SampleControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test @Ignore
	public void testGetText() throws Exception{
		String tempString = "";
		mockMvc.perform(get("/sample/getText/3")
						.contentType(MediaType.APPLICATION_JSON)
						.content(tempString))
						.andExpect(status().is(200));
	}
	
	@Test
	public void testConvert1() throws Exception{
		Ticket ticket = new Ticket();
		ticket.setTno(100);
		ticket.setOwner("홍길동");
		ticket.setGrade("A 등급");
		
		String jsonStr = new Gson().toJson(ticket);
		log.info("티켓 Java Object -----> Json 문자열로 변환된 형태: " + jsonStr);
		
		mockMvc.perform(post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr))
				.andExpect(status().is(200));
	}
	
	@Test @Ignore
	public void testConvert2() throws Exception{
		Ticket ticket = new Ticket();
		ticket.setTno(100);
		ticket.setOwner("홍길동");
		ticket.setGrade("A 등급");
		
		String jsonStr = new Gson().toJson(ticket);
		log.info("티켓 Java Object -----> Json 문자열로 변환된 형태: " + jsonStr);
		
		mockMvc.perform(post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr))
				.andExpect(status().is(200));
	}
}
