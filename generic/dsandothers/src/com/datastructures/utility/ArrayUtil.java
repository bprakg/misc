package com.datastructures.utility;

public class ArrayUtil {

	public static <T> void printArray(T[] array) {
		System.out.print("[");
		for (int i=0; i< array.length-1; i++) {
			System.out.print(array[i]+", ");
		}
		System.out.print(array[array.length-1]+"]\n");
	}
	
	public static void sortArray() {
		Integer[] intArr = {1,0,0,0,0,0,0,1};
		System.out.println("original array = ");
		printArray(intArr);
		for (int i=0,j=i+1; j<intArr.length; j++) {
			if (intArr[i] > intArr[j]) {
				int k = intArr[i];
				intArr[i] = intArr[j];
				intArr[j] = k;
				i++;
			} else if (intArr[i] == intArr[j]){
				continue;
			} else {
				i++;
			}
			printArray(intArr);
		}
		System.out.println("Final array = ");
		printArray(intArr);
	}
}
