package com.javalab.anonymous01;

public class Anonymous {
	Person field = new Person() {
		void walk() {
			System.out.println("산책합니다.");
		}
		
		@Override
		public void wake() {
			System.out.println("6시에 일어납니다.");
			walk();
		}
	};
	
	void method1() {
		Person personLocal = new Person() {
			void work() {
				System.out.println("출근합니다.");
			}
			
			@Override
			public void wake() {
				System.out.println("7시에 일어납니다.");
				work();
			}
		};
		
		personLocal.wake();
		System.out.println(personLocal);
		System.out.println("Anonymous > method1 > PersonLocal : " + personLocal);
	}
	
	void method2(Person person) {
		person.wake();
	}
}
