package com.practice.generic.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtil {

	// Algo to check if string has unique characters
	public static boolean isUnique(String str) {
		char[] charArr = str.toCharArray();
		Map<Character, String> hash = new HashMap<>();
		for (char c : charArr) {
			if (null != hash.get(c)) {
				return false;
			} else {
				hash.put(c, "true");
			}
		}
		return true;
	}

	// Checking if string 1 is a permutation of Str 2
	public static boolean isPermutation(String str1, String str2) {
		Map<Character, Integer> map = new HashMap<>();
		char[] charArr1 = str1.toCharArray();
		for (char c : charArr1) {
			if (null == map.get(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c).intValue() + 1);
		}
		char[] charArr2 = str2.toCharArray();
		for (char c : charArr2) {
			if (null == map.get(c) || map.get(c) == 0) {
				return false;
			} else {
				map.put(c, map.get(c).intValue() - 1);
			}
		}
		return true;
	}

	// Algo to arrange even digits in even place
	// and odd digits in odd place in an array
	public static void rearrangeIntArray(int[] data) {
		boolean evenFlip = false;
		boolean oddFlip = false;
		for (int evenIndex = 0, oddIndex = 1; (oddIndex < data.length && evenIndex < data.length);) {
			if (data[evenIndex] % 2 == 0) {
				evenIndex += 2;
			} else {
				evenFlip = true;
			}
			if (data[oddIndex] % 2 == 1) {
				oddIndex += 2;
			} else {
				oddFlip = true;
			}
			if (evenFlip && oddFlip) {
				int tmp = data[evenIndex];
				data[evenIndex] = data[oddIndex];
				data[oddIndex] = tmp;
				oddFlip = false;
				evenFlip = false;
				evenIndex += 2;
				oddIndex += 2;
			}
		}

		for (int i : data) {
			System.out.println("data: " + i);
		}
	}

	// Urlifying a string ie replace space with %20
	public static String urlify(String str) {
		StringBuilder sb = new StringBuilder(str.trim());
		System.out.println(sb.toString());
		while (-1 != sb.lastIndexOf(" ")) {
			sb.replace(sb.lastIndexOf(" "), sb.lastIndexOf(" ") + 1, "%20");
		}
		return sb.toString();
	}

	// insert count of character in string and
	// return this if its lenght is less for ex
	// aaaaabbbbbbcccccaaaaa = a5b6c5a5
	public static String stringWithNumbers(String str) {
		StringBuffer sb = new StringBuffer();
		int counter = 1;
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1 && (str.charAt(i) == str.charAt(i + 1))) {
				counter++;
			} else {
				sb.append(str.charAt(i));
				sb.append(counter);
				counter = 1;
			}
		}
		return str.length() < sb.length() ? str : sb.toString();
	}

	// Convert number to binary without using any
	// inbuilt function
	public static void toBinary(int i) {
		StringBuilder sb = new StringBuilder();
		String str = "";
		int num = Math.abs(i);
		while (num > 0) {
			sb.append(Integer.toString(num % 2));
			str = num % 2 + str;
			num /= 2;
		}
		System.out.println(null == sb ? 0 : sb.reverse());
		System.out.println(str);
	}

	// Convert string to integer without using
	// any inbuilt function
	public static String integerToString(int i) {
		String sign = i < 0 ? "-" : "";
		int j = Math.abs(i);
		String str = "";
		while (j > 0) {
			str = j % 10 + str;
			j /= 10;
		}
		return (str == "") ? "0" : sign + str;
	}

	/**
	 * Given a number, print combinations we can derive from number. 1=A, 2=B..
	 * 26=Z, 0+ for ex 1123 aabc can be represented in 5 ways 1,1,2,3: 11,23:
	 * 11,2,3: 1,1,23: 1,12,3:
	 */
	public static int numCombination(int num) {
		Map<Integer, Integer> memo = new HashMap<>();
		return numCombinationHelper(num, memo);
	}

	// Continuation of above
	public static int numCombinationHelper(int num, Map<Integer, Integer> memo) {
		if (num < 10) {
			return 1;
		}
		if (memo.get(num) == null) {
			if (num % 100 < 27) {
				memo.put(num, numCombinationHelper(num / 10, memo) + numCombinationHelper(num / 100, memo));
			} else {
				memo.put(num, numCombinationHelper(num / 10, memo));
			}
		}
		return memo.get(num);
	}

	// Find combination of number that results in sum
	// numbers should be unique
	public static void findCombinationToSum() {
		int[] intArr = { 6, 4, 4, 3, 1, 7, 5, 5 };
		int sum = 10;
		Set<Integer> set = new HashSet<>();
		for (int i : intArr) {
			if (i <= sum) {
				int secondPair = sum - i;
				if (set.contains(i) && set.contains(secondPair)) {
					continue;
				} else if (set.contains(secondPair)) {
					System.out.println(secondPair + " , " + i);
				}
				set.add(i);
			}
		}
	}
	
	public static boolean checkPalindrome(char[] c) {
		int[] i = new int[512];
		boolean isEven = (c.length % 2 == 0) ? true : false;
		boolean oddFound = false;
		for (int j = 0; j < c.length; j++) {
			i[c[j]] = i[c[j]] + 1;
		}
		for (int k : i) {
			if (k % 2 == 0)
				continue;
			if (isEven)
				return false;
			if (!oddFound)
				oddFound = true;
			else
				return false;
		}
		return true;
	}
}
