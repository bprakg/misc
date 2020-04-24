package com.datastructures.elementary.impl;

import com.datastructures.elementary.Stack;

public class StackImpl<T> implements Stack<T> {
	private Node current;
	private class Node {
		T value;
		Node next;
		Node(T t) {
			value = t;
		}
	}

	@Override
	public void push(T t) {
		Node node = new Node(t);
		if (current == null) {
			current = node;
		} else {
			node.next = current;
			current = node;
		}
	}

	@Override
	public T pop() {
		Node node = current;
		current = current.next;
		return node.value;
	}

	@Override
	public T peek() {
		if (current == null || current.next == null) {
			return null;
		} else {
			return current.next.value;
		}
	}
}
