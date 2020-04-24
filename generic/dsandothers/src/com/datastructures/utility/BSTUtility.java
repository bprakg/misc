package com.datastructures.utility;

import com.datastructures.elementary.impl.BinarySearchTreeImpl.Node;

public class BSTUtility {
	
	// find the node closest
	public static int nodeClosestTo(Node node, int i) {
		int closest = 0;
		while (node != null) {
			int closestDiff = Math.abs(closest-i);
			int nodeDiff = Math.abs(node.i-i);
			closest = closestDiff > nodeDiff ? node.i: closest;
			if(i > node.i) {
				node = node.r;
			} else {
				node = node.l;
			}
		}
		return closest;
	}
}
