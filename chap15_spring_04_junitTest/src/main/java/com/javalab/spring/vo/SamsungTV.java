package com.javalab.spring.vo;

// 삼성 1세대 TV는 소니 스피커만 사용가능
// 직접 스피커 객체 생성해서 사용 [TV-SonySpeaker 결합도 강함.]
public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price;
	private String color;
	private int size;
	
	public SamsungTV() {
		System.out.println("여기는 삼성TV 생성자");
	}
	
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("여기는 삼성TV 오버로딩 생성자 - 생성자 인젝션");
	}
	
	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
		System.out.println("여기는 삼성TV 오버로딩 생성자 - 생성자 인젝션");
	}

	@Override
	public void powerOn() {
		System.out.println("삼성티비 전원 켬(" + this.price + "원)");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성티비 전원 끔");
	}
	
	 public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	@Override
	public String getColor() {
		return color;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
