package com.datastructures.elementary.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphImpl {

	static class Node {
		int index, d;
		boolean visited;
		List<Node> adj = new ArrayList<>();
		Node p;

		Node(int v) {
			index = v;
		}
	}

	Map<Integer, Node> g = new java.util.HashMap<>();

	public void dfs(Integer s) {
		if (g == null)
			return;
		Queue<Node> q = new java.util.LinkedList<>();
		q.add(g.get(s));
		while (!q.isEmpty()) {
			Node u = q.poll();
			if (u!=null && !u.visited) {
				for (Node v : u.adj) {
					v.d = u.d + 1;
					v.p = u;
				}
				u.visited = true;
			}
		}
	}

	public void add(int parent, int child) {
		// TODO Auto-generated method stub
	}

	public boolean isConnect(int sourceNode, int targetNode) {
		dfs(sourceNode);
		Node target = g.get(targetNode);
		Node source = g.get(sourceNode);
		while (target != null && target.p != source) {
			System.out.println(target.index);
			target = target.p;
		}
		return (target != null);
	}

	public static void main(String[] args) {
		GraphImpl gi = new GraphImpl();
		gi.g.put(1, new Node(1));
		gi.g.put(2, new Node(2));
		gi.g.put(3, new Node(3));
		gi.g.put(4, new Node(4));
		gi.g.get(1).adj.add(gi.g.get(2));
		gi.g.get(2).adj.add(gi.g.get(4));
		gi.g.get(4).adj.add(gi.g.get(3));
		gi.g.get(3).adj.add(gi.g.get(1));
		System.out.println("Connected ? = " + gi.isConnect(1, 4));
	}
}
