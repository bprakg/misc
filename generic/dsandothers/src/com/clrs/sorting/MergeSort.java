package com.clrs.sorting;

public class MergeSort {
	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	private static void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = A[q + 1 + j];
		}
		int i = 0, j = 0;
		for (int k = p; k <= r; k++) {
			if (j >= R.length || (i < L.length && L[i] < R[j])) {
				A[k] = L[i];
				i += 1;
			} else {
				A[k] = R[j];
				j += 1;
			}
		}
	}
}
