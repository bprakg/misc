package com.datastructures.elementary;

public interface Graph {

	void add(int parent, int child);
	boolean isConnect(int sourceNode, int targetNode);
}
