package com.practice.thread;

public class ThreadDemo implements Runnable{
	String name = null;
	public ThreadDemo(String paramName) {
		this.name = paramName;
	}
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Thread is = "+name+" counter = "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadDemo("Thread1"));
		t1.start();
		Thread t2 = new Thread(new ThreadDemo("Thread2"));
		t2.start();
	}
}
