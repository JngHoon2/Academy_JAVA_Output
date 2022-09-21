package com.javalab.anonymous01;

public class AnonymousMain {
	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		System.out.println(anonymous.field);
		
		anonymous.field.wake();
		
		anonymous.method1();
		
		Person person = new Person() {
			void study() {
				System.out.println("공부합니다.");
			}
			
			@Override
			public void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
		};
		
		anonymous.method2(person);
		
		anonymous.method2(new Person() {
			void study() {
				System.out.println("공부합니다.");
			}
			@Override
			public void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
		});
	}
}
