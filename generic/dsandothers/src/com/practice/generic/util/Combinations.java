package com.practice.generic.util;

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

	private static void comb2(String prefix, String s) {
		System.out.println(prefix);
		for (int i = 0; i < s.length(); i++)
			comb2(prefix + s.charAt(i), s.substring(i + 1));
	}

	// read in N from command line, and print all subsets among N elements
	public static void main(String[] args) {
		int n = 3;
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String elements = alphabet.substring(0, n);

		// using first implementation
		comb1(elements);
		System.out.println();

		// using second implementation
		comb2(elements);
		System.out.println();
	}

	private static void comb(int[] prefix, int[] arr) {
		System.out.println(Arrays.toString(prefix));
		for (int i = 0; i < arr.length; i++) {
			int[] tmp = null;
			if (prefix == null) {
				tmp = new int[1];
				tmp[0] = arr[i];
			} else {
				tmp = Arrays.copyOf(prefix, prefix.length + 1);
				tmp[prefix.length] = arr[i];
			}
			comb(tmp, Arrays.copyOfRange(arr, i + 1, arr.length));
		}

	}
	
}
