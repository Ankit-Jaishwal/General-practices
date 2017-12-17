package com.ankit.strings;

public class UniqueCharString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(recFibo(10));
		//System.out.println(isUnique("abcdef*g"));
	}
	
	public static boolean isUnique(String inputStr){
		int[] intArray = new int[256];
		for (int i = 0; i < inputStr.length(); i++) {
			intArray[inputStr.charAt(i)] = intArray[inputStr.charAt(i)] + 1 ;
			if(intArray[inputStr.charAt(i)] > 1) return false;
		}
		
		return true;
	}
	
	public static int recFibo(int n){
		if (n <= 0) {
			return 0;
		}
		if(n == 1 || n == 2)
			return 1;
		return recFibo(n-1)+recFibo(n-2);
		
	}
	
	
	

}
