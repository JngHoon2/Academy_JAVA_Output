package com.javalab.spring.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.javalab.spring.vo.*;

public class TVMain {
	public static void main(String[] args) {
		
		/*
		 * [1] 스프링 컨테이너 구동(IOC 컨테이너)
		 *	xsml 파일을 이용하여 스프링 컨테이너 객체 생성
		 * root-context.xml 파일은 resource config 폴더에 들어가 있어야 함.
		 * 빈 설정파일의 경로를 설정할 때 classpath:config/root-context.xml 하면
		 * resource 폴더 안의 config 폴더 안의 root-context.xml을 찾게 됨,
		 * (resource 폴더는 자바에서 기본 classpath로 인식하고 있음.)
		 * GenericXmlApplocationContext : XML 파일로부터 정보를 읽어와
		 * 객체를 생성하고 초기화.(스프링 컨테이너 생성)   
		 */
		
		AbstractApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:config/root-context2.xml");
		
		/*
		 * 2. 스프링 컨테이너로부터 필요한 객체를 요청(lookup)한다.
		 * 	- root-context.xml에서 "tv"로 세팅해놓음. 
		 */
		
		 TV tv = (TV) applicationContext.getBean("samsungTV");
		 tv.powerOn();
		 tv.volumeUp();
		 tv.volumeDown();
		 tv.powerOff();
		 
		 // 3. 스프링 컨테이너 종료
		 applicationContext.close();
	}
}
