package com.practice.generic.util;

public class GenericUtil {

	public static void main(String[] args) {

//		System.out.println(getCount("abcaabcbb"));
		int[][] arr = new int[3][3];
		arr[0][0] = 1;
		arr[1][0] = 2;
		arr[2][0] = 3;
		arr[0][1] = 4;
		arr[1][1] = 5;
		arr[2][1] = 6;
		arr[0][2] = 7;
		arr[1][2] = 8;
		arr[2][2] = 9;
		printSpiralForm(arr);
	}

	static void printSpiralForm(int[][] arr) {

		// have top side, left, right
		// while they are less than each other
		// read and print from matrix
		// decrement each of them

		int xpos = 0, ypos = 0, xneg = arr.length-1, yneg = arr[0].length-1;

		while (xpos <= xneg && ypos <= yneg) {
			for (int i = xpos; i <= xneg; i++) {
				System.out.println(arr[i][ypos]);
			}
			ypos++;
			for (int j = ypos; j <= yneg; j++) {
				System.out.println(arr[xneg][j]);
			}
			xneg--;
			for (int k = xneg; k >= xpos; k--) {
				System.out.println(arr[k][yneg]);
			}
			yneg--;
			for (int l = yneg; l >= ypos; l--) {
				System.out.println(arr[xpos][l]);
			}
			xpos++;
		}
	}

}
