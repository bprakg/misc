package com.datastructures.elementary.impl;

public class LinkedListForMap <K, V> {
	public class Node implements Cloneable {
		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
		public Node next;
		public K key;
		public V value;
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public Node head;
	
	public void add(K key, V value) {
		Node node = new Node(key, value);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}
	public V get() {
		return head.value;
	}
	
	public V search(K key) {
		Node temp = head;
		while (temp != null && !temp.key.equals(key)) {
			temp = temp.next;
		}
		if (temp !=  null) {
			return temp.value;
		} else {
			return null;
		}
	}
}
