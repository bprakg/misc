package com.datastructures.utility;

public class IntegerUtil {
	
	// Factorial of a number
	public static int factorial(int n) {
		return factorial(n, new int[n+1]);
	}
	
	// factorial of a number - continued
	public static int factorial(int n, int[] memo) {
		if (n==1) return 1;
		if(memo[n] == 0) {
			memo[n] = n*factorial(n-1, memo);
		} 
		return memo[n];
	}
	
	//Finding max without using comparition or if/else
	public static int findMax(int a, int b) {
		return (a*((b-a)>>>31)) + (b*((a-b)>>>31));
	}
	
	// find maximum power of 2
	public static int getTwoToThePowerOf(int i) {
		if (i==1) return 2;
		int mid = i/2;
		int product = getTwoToThePowerOf(mid); 
		if(i%2 == 0) {
			return product*product;
		} else {
			return product*product*2;
		}
	}
}
