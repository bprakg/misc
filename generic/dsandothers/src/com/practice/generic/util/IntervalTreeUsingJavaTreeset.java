package com.practice.generic.util;

import java.util.TreeSet;

/**
 * Interval Tree using TreeSet
 * 
 * @author Prakash
 *
 */
public class IntervalTreeUsingJavaTreeset {

	/**
	 * Client code
	 * 
	 * @param strings
	 */
	public static void main(String... strings) {
		IntervalTreeUsingJavaTreeset mit = new IntervalTreeUsingJavaTreeset();
		//Assuming 1st input is smaller than second
		mit.add(1, 5);
		mit.print();
		mit.remove(2, 3);
		mit.print();
		mit.add(6, 8);
		mit.print();
		mit.remove(4, 7);
		mit.print();
		mit.add(2, 7);
		mit.print();
		
		/**
		 * Sample output after each print
		 * 
		 * 	
		 * Intervals = [[1, 5]]
			Intervals = [[1, 2][3, 5]]
			Intervals = [[1, 2][3, 5][6, 8]]
			Intervals = [[1, 2][3, 4][7, 8]]
			Intervals = [[1, 8]]
		 * 
		 */
	}

	/**
	 * Printing all intervals
	 */
	public void print() {
		System.out.printf("Intervals = [");
		s.stream().forEach(e -> {
			System.out.print(e);
		});
		System.out.println("]");
	}

	/**
	 * 
	 * Node
	 *
	 */
	private class Node implements Comparable<Node>{
		int from, to;
		Node(int f, int t) {
			this.from = f;
			this.to = t;
		}
		
		public String toString() {
			return String.format("[%d, %d]", from, to);
		}
		
		public boolean equals(Node n) {
			if(this.to < n.from || this.from > n.to) return false;
			return true;
		}

		@Override
		public int compareTo(Node o2) {
			if (this.to < o2.from)
				return -1;
			if (this.from > o2.to)
				return 1;
			return 0;
		}
		
	}

	/**
	 * Tree holding the intervals
	 */
	private TreeSet<Node> s = new TreeSet<>();

	/**
	 * Adding Intervals
	 * 
	 * @param from
	 * @param to
	 */
	public void add(int from, int to) {
		if(from >= to) return;
		Node n = new Node(from, to);
		Node floor = s.floor(new Node(from, from));
		Node ceiling = s.ceiling(new Node(to, to));
		if(null != floor && n.equals(floor)) n.from = floor.from;
		if(null != ceiling && n.equals(ceiling)) n.to = ceiling.to;
		removeIntervals(n);
		s.add(n);
	}

	/**
	 * Removing all N intervals
	 * 
	 * @param n
	 */
	private void removeIntervals(Node n) {
		while(s.contains(n)) s.remove(n);
	}

	/**
	 * Removing specific interval
	 * 
	 * @param from
	 * @param to
	 */
	public void remove(int from, int to) {
		if(from >= to) return;
		Node n = new Node(from, to);
		if(!s.contains(n)) return;
		Node floor = s.floor(new Node(from, from));
		Node ceiling = s.ceiling(new Node(to, to));
		removeIntervals(n);
		if(from > floor.from && to < ceiling.to){
			s.add(new Node(floor.from, from));
			s.add(new Node(to, ceiling.to));
		}
	}
}
