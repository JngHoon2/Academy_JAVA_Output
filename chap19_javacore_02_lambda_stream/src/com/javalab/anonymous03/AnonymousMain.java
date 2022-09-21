package com.javalab.anonymous03;

public class AnonymousMain {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		System.out.println("AnonymousMain > main > anony.field : " + anony.field);
		
		anony.field.run();
		
		anony.method1();
		
		anony.method2(new Vehicle() {
			
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}
}
