/**
 * 
 */
package com.ankit.strings;

/**
 * @author Ankit
 *
 */
public class PermutationString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPermutationString("aaac", "aaab"));
	}
	
	public static boolean isPermutationString(String inputStr1, String inputStr2) {
		int[] intArray = new int[256];
		if( inputStr1.length() != inputStr2.length()) return false;
		
		for (int i = 0; i < inputStr1.length(); i++) {
			intArray[inputStr1.charAt(i)]  = intArray[inputStr1.charAt(i)] + 1;
			System.out.print(inputStr1.charAt(i) +"  "+ intArray[inputStr1.charAt(i)] + "\t");
		}
		System.out.println();
		for (int i = 0; i < inputStr2.length(); i++) {
			intArray[inputStr2.charAt(i)]  = intArray[inputStr2.charAt(i)] - 1;
			System.out.print(inputStr2.charAt(i) +"  "+ intArray[inputStr2.charAt(i)] + "\t");
			if(intArray[inputStr2.charAt(i)] == -1){
				return false;
			}
		}
		System.out.println();
//		for (int i = 0; i < intArray.length; i++) {
//			System.out.print("  "+ intArray[i]);
//			if (intArray[i] > 0) {
//				System.out.println();
//				return false;
//			}
//		}
//		System.out.println();
		return true;
	}

}
