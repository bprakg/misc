package com.sample;

public class ThreadTest implements Runnable {
	int i;
	
	ThreadTest(int j) {
		i = j;
	}
	public void run() {
		System.out.println("Inside "+i);
	}
}
