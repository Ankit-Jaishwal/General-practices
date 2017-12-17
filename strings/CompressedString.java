package com.ankit.strings;

public class CompressedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inputStr = "aabbccddeeeeeed";
		char tempChar = inputStr.charAt(0);
		int tempCount = 1;
		StringBuffer outputStrBfr = new StringBuffer("");
		outputStrBfr.append(tempChar);
		for (int i = 1; i < inputStr.length(); i++) {
			if(tempChar == inputStr.charAt(i)){
				tempCount++;
			} else {
				outputStrBfr.append(tempCount).append(inputStr.charAt(i));
				tempChar = inputStr.charAt(i);
				tempCount = 1;
			}
		}
		outputStrBfr.append(tempCount);
		if (outputStrBfr.length()< inputStr.length())
			System.out.println(outputStrBfr.toString());
		else
			System.out.println(inputStr);
	}
	public static int fibonacciValue(int input) {
    	int temp1 = 0;
    	int temp2 = 1;
    	int next = 0;
    	if (input == 0) return 0;
    	if (input == 1) return 1;
    	next = fibonacciValue(input - 1) + fibonacciValue(input - 2);
    	return next;
//    	for(int i = 2; i<= input ; i++) {
//    	  next =  temp1 + temp2 ; 
//    	  temp1 = temp2;
//    	  temp2 = next;
//    	}
//    	System.out.println(next);
//    	return next;
    }

}
