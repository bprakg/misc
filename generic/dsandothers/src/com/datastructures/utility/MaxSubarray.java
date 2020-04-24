package com.datastructures.utility;

public class MaxSubarray {
	public static void maxSubArray(int[] arr) {
	    int maxEndingHere=arr[0], maxSoFar = arr[0];
	    int begin=0, end=arr.length-1; 
	    for(int i=0; i<arr.length; i++) {
	    	if(arr[i] > maxEndingHere+arr[i]) {
	    		maxEndingHere = arr[i];
	    		begin=i;
	    	} else {
	    		maxEndingHere+=arr[i];
	    	}
	    	if(maxSoFar<maxEndingHere) {
	    		maxSoFar=maxEndingHere;
	    		end = i;
	    	} 
	    }
	    System.out.println("max is = " +maxSoFar+'\n');
	    for (int i=begin; i<=end; i++) {
	    	System.out.print(" "+arr[i]);
	    }
	}
}
