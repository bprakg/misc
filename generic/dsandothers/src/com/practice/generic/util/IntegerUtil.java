package com.practice.generic.util;

public class IntegerUtil {
	public static int convertToInt(String s) {
		if(s==null || s.isEmpty()) return 0;
		int c = s.charAt(s.length()-1)-'0';
		return c+convertToInt(s.substring(0, s.length()-1))*10;
	}
	
	public static void iterativeConvertToInt(String s) {
		int d=0;
		for(int i=0; i<s.length(); i++) {
			d = s.charAt(i)-'0'+(d*10);
		}
		System.out.println("recurseive int = "+d);
	}
	
	public static void parseDouble(String s) {
		if (s==null) return;
		float d = 0.0f;
		for(int i = s.length()-1; i>=0; i--) {
			float c = s.charAt(i)-'0';
			System.out.println("c = "+c/10+" d = "+d/10.00);

			d= (d/10)+(c/10);
			System.out.println("sum = "+d);
		}
		System.out.println("final = "+d);
	}
	
	public static boolean isPowerOf2(int n) {
		return (n&n-1)==0;
	}
}
