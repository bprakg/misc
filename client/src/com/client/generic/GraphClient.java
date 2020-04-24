package com.client.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphClient {

	static class Node {
		Node p;
		boolean visited;
		int s, f;
		char index;
		List<Node> adj;

		Node(char c) {
			index = c;
		}
	}

	Map<Character, Node> g = new HashMap<>();
	LinkedList<Node> ts = new LinkedList<>();
	int t;

	void dfs() {
		// g.entrySet().stream().forEach(e -> System.out.print("
		// "+e.getValue().index));
		// g.entrySet().stream().forEach(e -> {
		// Node n = e.getValue();
		// System.out.println();
		// System.out.print(n.index + " -> ");
		// n.adj.stream().forEach(m -> System.out.print(" " + m.index));
		// });
		g.entrySet().stream().forEach(e -> {
			Node n = e.getValue();
			if (!n.visited)
				dfs(e.getValue());
		});
	}

	void dfs(Node n) {
		t = t + 1;
		n.s = t;
		// System.out.println("t= " + t + " Node = " + n.index);
		n.adj.stream().forEach(g -> {
			if (!g.visited) {
				g.p = n;
				dfs(g);
			}
		});
		t = t + 1;
		n.f = t;
		n.visited = true;
		ts.addFirst(n);
		System.out.println("Visited Node " + n.index);
	}

	public static void main(String[] args) {
		GraphClient gc = new GraphClient();

		Node na = new Node('a');
		gc.g.put('a', na);
		Node nb = new Node('b');
		gc.g.put('b', nb);
		Node nc = new Node('c');
		gc.g.put('c', nc);
		Node nd = new Node('d');
		gc.g.put('d', nd);
		Node ne = new Node('e');
		gc.g.put('e', ne);
		Node nf = new Node('f');
		gc.g.put('f', nf);
		List<Node> lna = new ArrayList<>();
		lna.add(gc.g.get('f'));
		gc.g.get('a').adj = lna;
		List<Node> lnb = new ArrayList<>();
		lnb.add(gc.g.get('f'));
		gc.g.get('b').adj = lnb;
		List<Node> lnd = new ArrayList<>();
		lnd.add(gc.g.get('a'));
		lnd.add(gc.g.get('b'));
		gc.g.get('d').adj = lnd;
		List<Node> lnc = new ArrayList<>();
		lnc.add(gc.g.get('d'));
		gc.g.get('c').adj = lnc;
		gc.g.get('e').adj = new ArrayList<>();
		gc.g.get('f').adj = new ArrayList<>();
		// gc.g.get('a').adj.add(gc.g.get('f'));
		// gc.g.get('b').adj.add(gc.g.get('f'));
		// gc.g.get('d').adj.add(gc.g.get('a'));
		// gc.g.get('d').adj.add(gc.g.get('b'));
		// gc.g.get('c').adj.add(gc.g.get('d'));
		gc.dfs();
		gc.ts.stream().forEach(e -> {
			System.out.print(" " + e.index);
		});
	}

}
