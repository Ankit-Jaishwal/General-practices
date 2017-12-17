package com.ankit.arrays;

import java.util.Arrays;

public class MultiplyElements {

	public static int[] a = {3,5,6,1};
	public static int length = a.length; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiplyWithoutDivide();
	}
	
	public static void multiplyWithoutDivide() {
		int[] outArr = new int[a.length]; 
		int[] fwdArr = new int[a.length];
		int[] bkwdArr = new int[a.length];
		fwdArr[0] = a[0];
		bkwdArr[length-1] = a[length - 1];
		for (int i = 1, j= length-2 ; i < length; i++, j--) {
			fwdArr[i] = fwdArr[i-1]*a[i];
			bkwdArr[j] = a[j]*bkwdArr[j+1];
		}
		System.out.println("fwdArr : "+Arrays.toString(fwdArr));
		System.out.println("bkwdArr : "+Arrays.toString(bkwdArr));
		
		
		for (int i = 0; i < length; i++) {
			int prev = 1;
			int next = 1;
			if (i-1>= 0)
				prev = fwdArr[i-1];
			if (i+1 < length)
				next = bkwdArr[i+1];
			outArr[i] = prev * next;
			
		}
		
		System.out.println("outArr : "+Arrays.toString(outArr));
		
		
		
	}

}
