package com.datastructures.elementary.impl;

import com.datastructures.elementary.Queue;

public class SimpleQueue<T> implements Queue <T>{
	
	class Node {
		T t;
		Node next;
		Node (T paramt) {
			t= paramt;
		}
	}

	Node head, tail;
	
	public void enqueue(T t) {
		Node node = new Node(t);
		if (head == null) {
			head = tail = node;
		} else {
			node.next = tail;
			tail = node;
		}
	}
	public T dequeue() {
		T t;
		if (head == null) return null;
		else if (head == tail) {
			t = head.t;
			head = tail = null;
		} else {
			t = tail.t;
			tail = tail.next;
		}
		return t;	
	}
	public T seek() {
		if (tail != null)
			return tail.t;
		return null;
	}
}
