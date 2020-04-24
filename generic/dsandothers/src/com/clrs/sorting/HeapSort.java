package com.clrs.sorting;

public class HeapSort {

	public static void main(String... args) {
		int[] arr = { 564, 968496, 651, 35465, 6546, 654, 654, 29184 };
		System.out.println("Original Array");
		printArr(arr);
		heapsort(arr, arr.length);
		System.out.println("\nHeap Sorted Array");
		printArr(arr);
	}

	static void printArr(int[] arr) {
		System.out.print("[ ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.print("]\n");
	}

	static void buildMaxHeap(int[] arr, int heapSize) {

		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			maxHeapify(i, arr, heapSize);
		}
	}

	static void maxHeapify(int i, int[] arr, int heapSize) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (l < heapSize && arr[largest] < arr[l])
			largest = l;
		if (r < heapSize && arr[largest] < arr[r])
			largest = r;
		if (largest == i)
			return;
		else {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(largest, arr, heapSize);
		}
	}

	static void heapsort(int[] arr, int heapSize) {
		buildMaxHeap(arr, heapSize);
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapSize = heapSize - 1;
			maxHeapify(0, arr, heapSize);
		}
	}
}
