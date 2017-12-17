package com.ankit.strings;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringCombination {

	public static void main(String[] args) {
		String str = "abcd";
//		List<String> words = getCombination(str);
//		System.out.println(words);
//		System.out.println(words.size());
//		System.out.println(new HashSet<String>(words));
		combination(str);
	}

	public static List<String> getCombination(String word) {
		return null;
	}

	private static String insertCharAt(String w, String first, int i) {
		String start = w.substring(0, i);
		String end = w.substring(i);
		return start + first + end;
	}
	
	public static void combination(String str){
		
		ArrayList<String> al = new ArrayList<>();
		int len = str.length();
		
//		al.add(String.valueOf(str.charAt(len-1)));
		
		for(int i = len -1 ; i >= 0 ; i--){
			char c = str.charAt(i);
			ArrayList<String> tempAl = new ArrayList<>();
			for (int j = 0; j < al.size(); j++) {
				String temp = c+al.get(j);
				//if(temp.length() == 2)
				tempAl.add(temp);
			}
			al.addAll(tempAl);
			al.add(String.valueOf(c));
		}
		
		printAL(al);
		
	}

	private static void printAL(ArrayList<String> al) {
		// TODO Auto-generated method stub
		System.out.println(al);
		
	}

}
