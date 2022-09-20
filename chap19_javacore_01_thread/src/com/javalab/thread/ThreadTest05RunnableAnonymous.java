package com.javalab.thread;


class ThreadRunnableAnony implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

public class ThreadTest05RunnableAnonymous {
	public static void main(String[] args) {
		Runnable runnable_0 = new ThreadRunnableAnony();
		Thread t0 = new Thread(runnable_0);
		t0.start();
		
//		Runnable runnable_1 = new ThreadRunnableAnony();
//		Thread t1 = new Thread(runnable_1);		
//		t1.start();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " ");
			}
		});
		thread.start();
	}
}
