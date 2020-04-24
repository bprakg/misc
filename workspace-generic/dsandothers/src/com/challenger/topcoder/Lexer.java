package com.challenger.topcoder;

import java.util.ArrayList;

public class Lexer {
	public static String[] tokenize(String[] tokens, String input) {
		if (tokens.length == 0 || input == null)
			return null;
		ArrayList<String> as = new ArrayList<>(); 
		sortTokensByLength(tokens);
		StringBuilder inputSB = new StringBuilder(input);
		while (inputSB.length() > 0) {
			for (String tokenSTR : tokens) {
				if (tokenSTR.length() > inputSB.length()) continue;
				String compareStr = (tokenSTR.length() ==1)? inputSB.substring(0,1): inputSB.substring(0, tokenSTR.length());
				if (tokenSTR.equals(compareStr)) {
					as.add(tokenSTR);
					if(tokenSTR.length() ==1){
						inputSB.delete(0, 1);
					} else {
						inputSB.delete(0, tokenSTR.length()-1);
					}
				}
			}
			inputSB.delete(0, 1);
		}
		String[] arr = new String[as.size()];
		return as.toArray(arr);
	}

	private static void sortTokensByLength(String[] tokens) {
		for (int i = 0; i < tokens.length-1; i++) {
			for(int j = i+1; j< tokens.length; j++) {
				if(tokens[i].length() < tokens[j].length()) {
					swapArrayEntries(tokens, i, j);
				}
			}
		}
	}
	
	private static void swapArrayEntries(String[] tokens, int source, int target) {
		String temp = tokens[source];
		tokens[source] = tokens[target];
		tokens[target] = temp;
	}
}
