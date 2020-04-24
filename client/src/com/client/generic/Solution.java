package com.client.generic;

import java.util.Arrays;

public final class Solution {

	public static void main(String[] args) {
		int[] arr = {1 ,5 ,4, 3, 2, 6};
		if (isInOrder(arr)) {
			System.out.println("yes");
			return;
		}

		int i = 0, j = 0, count = 0;
		for (int k = 1; k < arr.length; k++) {
			if (arr[k - 1] > arr[k] && ++count > 2)
				break;
			if (i == 0) {
				i = k - 1;
				j = k;
			} else
				j = k;
		}
		swap(arr, i, j);
		if (isInOrder(arr)) {
			System.out.println("yes");
			System.out.printf("swap %d %d%n", ++i, ++j);
			return;
		}
		swap(arr, j, i);
		System.out.println(Arrays.toString(arr));
		int s = i;
		while (i < arr.length - 1 && arr[i] > arr[++i]) {
		}
		int e = i-1;
		int s1 = s, e1 = e;
		while (s1 < e1) {
			System.out.println(Arrays.toString(arr));
			swap(arr, s1++, e1--);
		}
		if (isInOrder(arr)) {
			System.out.println("yes");
			System.out.printf("reverse %d %d%n", ++s, ++e);
			return;
		}
		System.out.println("no");
	}

	private static boolean isInOrder(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i])
				return false;
		}
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		System.out.printf("i = %d j = %d%n", i, j);
		int k = arr[i];
		arr[i] = arr[j];
		arr[j] = k;
	}
}
