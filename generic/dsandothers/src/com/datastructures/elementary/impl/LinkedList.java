package com.datastructures.elementary.impl;

import com.datastructures.elementary.List;

public class LinkedList <E> implements List <E>{
	public class Node {
		public Node next;
		public E value;
		public Node(E value) {
			this.value = value;
		}
	}
	
	public Node head;
	
	public void add(E value) {
		Node node = new Node(value);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}
	public E get() {
		return head.value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("LinkedList [");
		Node node = head;
		while (node != null) {
			sb.append(node.next == null?node.value: node.value+", ");
			node = node.next;
		}
		sb.append( "]");
		return sb.toString();
	}
}
