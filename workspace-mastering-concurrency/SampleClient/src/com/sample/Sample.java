package com.sample;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Sample {

	public static void main(String[] args) {
		ThreadPoolExecutor e = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		e.shutdown();
	}

}
