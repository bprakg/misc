package com.clrs.sorting;

public class QuickSort {
	public static void quickSort(int[] A, int p, int r) {
		if(p<r) {
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
	}

	private static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p-1;
		for(int j =p; j< r; j++) {
			if(A[j]<=x) {
				i+=1;
				swap(A, i, j);
			}
		}
		swap(A, i+1, r);
		return i+1;
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
