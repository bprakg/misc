package com.datastructures.elementary;

public interface Queue <T>{
	void enqueue(T t);
	T dequeue();
	T seek();
}
