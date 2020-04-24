package com.practice.thread;

public class ThreadDemo2 extends Thread{
	String name = null;
	
	public ThreadDemo2 (String name) {
		this.name = name;
	}
	
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println("Name = "+name+" count = "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new ThreadDemo2("T1");
		t1.start();
		Thread t2 = new ThreadDemo2("T2");
		t2.start();

	}
}
