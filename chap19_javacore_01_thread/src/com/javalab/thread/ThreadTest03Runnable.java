package com.javalab.thread;

public class ThreadTest03Runnable {
	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		
		new Thread(r).start();
		new Thread(r).start();
		
	}
}

class Account1 {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance -= money;
		}
	}
}

class RunnableEx21 implements Runnable{
	Account1 acc = new Account1();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
	}
}
