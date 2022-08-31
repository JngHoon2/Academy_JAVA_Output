package com.javalab.spring.vo;

public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("애플 스피커 객체 생성");
	}
	
	public void volumeUp() {
		System.out.println("애플 스피커 사운드 증가");
	}
	
	public void volumeDown() {
		System.out.println("애플 스피커 사운드 감소");
	}
}
