package com.datastructures.elementary;

import com.datastructures.elementary.impl.BinarySearchTreeImpl.Node;

public interface BinarySearchTree {
	void inOrderTraversal(Node node);
	void preOrderTraversal(Node node);
	void postOrderTraversal(Node node);
	void insert(int i);
}
