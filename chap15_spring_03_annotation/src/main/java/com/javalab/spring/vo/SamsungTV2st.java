package com.javalab.spring.vo;

// 삼성 1세대 TV는 소니 스피커만 사용가능
// 직접 스피커 객체 생성해서 사용 [TV-SonySpeaker 결합도 강함.]
public class SamsungTV2st implements TV{
	
	private SonySpeaker sonySpeaker = null;
	
	public SamsungTV2st() {
		System.out.println("여기는 삼성TV2st 생성자");
	}
	
	public SamsungTV2st(SonySpeaker sonyspeaker) {
		System.out.println("여기는 삼성TV2st 오버로딩 생성자");
		this.sonySpeaker = sonyspeaker;
	}

	@Override
	public void powerOn() {
		System.out.println("삼성티비 전원 켬");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성티비 전원 끔");
	}

	// 1세대 TV는 소비 스피커만 사용
	@Override
	public void volumeUp() {
		sonySpeaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		sonySpeaker.volumeDown();
	}
}
