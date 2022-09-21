package com.javalab.lambda;

public class Lambda005 {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 5; i++) {
					System.out.println(Thread.currentThread().getName() + " " + i);
				}
			}
		});
		thread.start();
		System.out.println();
		
		Runnable runnable1 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 10; i++) {
					System.out.println("runnable1 : " + i);
				}
			}
		};
		System.out.println("runnable1 : " + runnable1);
		
		Runnable runnable2 = () ->{
			for(int i = 1; i <= 10; i++) {
				System.out.println("runnable2 : " + i);
			}
		};
		
		Thread thread1 = new Thread(runnable1);
		thread1.start();
		System.out.println();
		
		Thread thread2 = new Thread(runnable2);
		thread2.start();
		System.out.println();
		
		Thread thread3 = new Thread(() -> {
			for(int i = 1; i <= 10; i++) {
				System.out.println("메인스레드 : " + i);
			}
		});
		thread3.start();
	}
}
