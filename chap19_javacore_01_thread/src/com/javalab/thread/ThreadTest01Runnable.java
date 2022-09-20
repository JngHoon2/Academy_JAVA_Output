package com.javalab.thread;

class ThreadRunnableExam implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}


public class ThreadTest01Runnable {
	public static void main(String[] args) {
		
		Runnable runnable_0 = new ThreadRunnableExam();
		Thread t0 = new Thread(runnable_0);
		
		Runnable runnable_1 = new ThreadRunnableExam();
		Thread t1 = new Thread(runnable_1);
		
		
		t0.start();
		t1.start();
	}
}
