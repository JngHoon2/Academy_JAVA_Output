package com.javalab.spring.vo;

import org.springframework.stereotype.Component;

@Component("sonySpeaker")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("소니 스피커 객체 생성");
	}
	
	public void volumeUp() {
		System.out.println("소니 스피커 사운드 증가");
	}
	
	public void volumeDown() {
		System.out.println("소니 스피커 사운드 감소");
	}
}
