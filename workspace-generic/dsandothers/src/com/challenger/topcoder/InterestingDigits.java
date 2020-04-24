package com.challenger.topcoder;

import java.util.ArrayList;
//find the max
//iterate from 1 to base
//iterate from twice base to max
//find this number in required base
//check if its a multiple of base
//if sum is divisible by base print
import java.util.List;

public class InterestingDigits {
	public static int[] digits(int base) {
		List<Integer> list = new ArrayList<>();
		String maxStr = Integer.toString(base - 1) + Integer.toString(base - 1) + Integer.toString(base - 1);
		int max = Integer.parseInt(maxStr);
		System.out.println(" max = "+max);
		boolean[] donotcheck = new boolean[base];
		for (int i = 2; i < base; i++) {
			if (donotcheck[i]) continue;
			boolean found = false;
			for (int j = i; j <= max; j++) {
				int jInReqBase = Integer.parseInt(Long.toString(j, base));
				System.out.println(i+" jInReqBase "+jInReqBase);
				if (jInReqBase % i != 0)
					continue;
				int sumOfDigits = 0;
				while (jInReqBase > 0) {
					sumOfDigits += (jInReqBase % 10);
					jInReqBase /= 10;
				}
				if ((sumOfDigits%i) != 0) {
					found = false;
					donotcheck[i] = true;
					break;
				}
				found = true;
			}
			if (found){ 
				list.add(i);
				System.out.println(i+" is interesting");
			} else {
				for(int k = i*i; k< donotcheck.length; k++) {
					if(k%i==0) donotcheck[k] = true;
				}
			}
		}
		int[] intArr = new int[list.size()];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = list.get(i);
		}
		return intArr;
	}
}
