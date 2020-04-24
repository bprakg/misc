package com.clrs.sorting;

public class CountingSort {
	/*
	 * A - input array
	 * B - Output array
	 * k - range 0-k
	 */
	public static void countingSort(int[] A, int[] B, int k) {
		int[] C = new int[k+1];

		for (int i=0; i< A.length; i++) {
			C[A[i]]=C[A[i]]+1;
		}
		for(int i=1; i<=k; i++) {
			C[i]=C[i]+C[i-1];
		}
		for(int i=A.length-1; i>=0; i--) {
			B[--C[A[i]]] = A[i];
		}
	}
}
