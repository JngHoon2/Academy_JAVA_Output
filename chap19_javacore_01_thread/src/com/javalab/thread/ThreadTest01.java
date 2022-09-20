package com.javalab.thread;

import java.sql.Time;

class ThreadExam extends Thread{
	public ThreadExam(String name) {
		super(name);
	}

	@Override
	public void run() {
		for(int num = 1; num <= 100; num++) {
			
			System.out.println(getName() + " : " + num);
		}
	}
}


public class ThreadTest01{
	public static void main(String[] args) {
		ThreadExam t1 = new ThreadExam("첫 번째 스레드");
		ThreadExam t2 = new ThreadExam("두 번째 스레드");
		
		t1.start();
		t2.start();
	}
}
