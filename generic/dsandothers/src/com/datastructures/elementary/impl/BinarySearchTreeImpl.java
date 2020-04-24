package com.datastructures.elementary.impl;

import com.datastructures.elementary.BinarySearchTree;

public class BinarySearchTreeImpl implements BinarySearchTree{

	public class Node {
		public int i;
		public Node p;
		public Node l;
		public Node r;
		Node (int i) {
			this.i = i;
		}
	}
	public Node root;
	
	public void insert(int i) {
		Node node = new Node(i);
		Node u = root, v = null;
		while (u!= null) {
			v = u;
			if (u.i > i) {
				u = u.l;
			}else {
				u = u.r;
			}
		}
		node.p = v;
		if (v == null) {
			root = node;
		}else if (v.i > i) {
			v.l = node;
		} else {
			v.r = node;
		}
	}
	
	public void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.l);
			visit(node);
			inOrderTraversal(node.r);
		}
	}

	private void visit(Node node) {
		System.out.println("Getting "+node.i);
	}
	
	public void preOrderTraversal(Node node) {
		if (node != null) {
			visit(node);
			preOrderTraversal(node.l);
			preOrderTraversal(node.r);
		}
	}
	
	public void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.l);
			postOrderTraversal(node.r);
			visit(node);
		}
	}
}
