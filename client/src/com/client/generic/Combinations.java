package com.client.generic;

import java.util.Arrays;

public class Combinations {

	// print all subsets of the characters in s
	public static void comb1(String s) {
		comb1("", s);
	}

	// print all subsets of the remaining elements, with given prefix
	private static void comb1(String prefix, String s) {
		if (s.length() > 0) {
			System.out.println(prefix + s.charAt(0));
			comb1(prefix + s.charAt(0), s.substring(1));
			comb1(prefix, s.substring(1));
		}
	}

	// alternate implementation
	public static void comb2(String s) {
		comb2("", s);
	}

	public static void comb2(String prefix, String s) {
		System.out.println(prefix);
		for (int i = 0; i < s.length(); i++) comb2(prefix + s.charAt(i), s.substring(i + 1));
	}
	
	public static void comb2(char[] p, char[] s) {
		System.out.print(p);
		char[] c = Arrays.copyOf(p, p.length + 1);
		for (int i = 0; i < s.length; i++) {
			c[p.length] = s[i];
			comb2(c, Arrays.copyOfRange(s, i + 1, s.length));
		}
	}
}
