package com.ankit.strings;

public class RotatedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x =31;
		System.out.println(x & x+1);

	}

	public static boolean isRotatedString (String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		String str3 = str1 + str2;
		boolean b = false;
		b = str3.contains(str2);
		return b;
	}
}
