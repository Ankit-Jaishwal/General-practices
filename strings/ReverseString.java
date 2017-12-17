/**
 * 
 */
package com.ankit.strings;

/**
 * @author Ankit
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("Ankit"));
	}
	
	public static String reverseString(String inputStr){
		StringBuilder builder = new StringBuilder(inputStr);
		char[] reverseStr = inputStr.toCharArray();
		char temp ;
		for (int i = 0, j = reverseStr.length-1 ; i < reverseStr.length/2; i++, j--) {
//			temp = reverseStr[i];
//			reverseStr[i] = reverseStr[j];
//			reverseStr[j] = temp;
			temp = builder.charAt(i);
			builder.setCharAt(i, builder.charAt(j));
			builder.setCharAt(j, temp);
			
		}
		//return String.copyValueOf(reverseStr);
		return builder.toString();
	}

}
