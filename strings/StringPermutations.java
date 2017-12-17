package com.ankit.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringPermutations {

	public static void main(String[] args) {
		String inputStr = "abcd";
//		List<String> words = getPermutation("abca");
//		System.out.println(words);
//		System.out.println(words.size());
//		System.out.println(new HashSet<String>(words));
		permute(inputStr, 0, inputStr.length());
		
	}

	public static List<String> getPermutation(String word) {
		List<String> words = new ArrayList<String>();
		if (word.length() == 1) {
			words.add(word);
			return words;
		}
		String first = word.substring(0, 1);
		String remainder = word.substring(1);
		words = getPermutation(remainder);
		List<String> permList = new ArrayList<String>();
		for (String w : words) {
			for (int i = 0; i <= w.length(); i++) {
				permList.add(insertCharAt(w, first, i));
			}
		}
		return permList;
	}

	private static String insertCharAt(String w, String first, int i) {
		String start = w.substring(0, i);
		String end = w.substring(i);
		return start + first + end;
	}
	
	public static void permute(String s, int sI, int eI){
		if (sI == eI) {
			System.out.println(s);
			return;
		}
		for (int i = sI; i < s.length(); i++) {
			String temp = swap(s, sI, i);
//			System.out.println("temp : "+temp);
			permute(temp, sI + 1, eI);
		}
	}

	private static String swap(String s, int sI, int i) {
		char[] arr = s.toCharArray();
		char sIChar = arr[sI];
		char iChar = arr[i];
		arr[sI] = iChar;
		arr[i] = sIChar;
		
		return new String(arr);
	}

}
