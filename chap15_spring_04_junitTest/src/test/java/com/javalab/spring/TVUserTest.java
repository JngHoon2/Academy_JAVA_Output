package com.javalab.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.spring.vo.TV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/root-context.xml")
public class TVUserTest {
	
	@Autowired
	private AbstractApplicationContext context;
	
	@Test @Ignore
	public void testGetPropertiesValue() {
		TV tv = (TV)context.getBean("samsungTV");
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		
		System.out.println(tv.getColor() + "색의 TV");
		System.out.println(tv.getSize() + "사이즈의 TV");
		
		//assertNotNull(tv);
		assertEquals(tv.getColor(), "red");
	}
	
	@Test
	public void testGetPropertiesValue2() {
		TV tv = (TV)context.getBean("samsungTV");
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		
		System.out.println(tv.getColor() + "색의 TV");
		System.out.println(tv.getSize() + "사이즈의 TV");
		
		//assertNotNull(tv);
		assertEquals(tv.getColor(), "red");
	}
}
