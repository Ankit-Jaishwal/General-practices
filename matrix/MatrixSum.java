package com.ankit.matrix;

import java.util.HashMap;

public class MatrixSum {
	static int [][] a = {{1,2,3},{4,5,6},{7,8,9}};
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(150000));
		
		
//		printMatrix();
//		System.out.println();
//		calcualteSumMatrix();
//		System.out.println(calcualteSumSubMatrix(1,-1,2, 1));
//		
//		HashMap m = new HashMap();
//		m.entrySet();
//		Math.sqrt(5);
		
	}
	
	public static double sqrt(int number) {
		double t;
	 
		double squareRoot = number / 2;
	 int count = 1;
		do {
			System.out.println("count++ : "+count++);
			
			t = squareRoot;
			System.out.println("t : "+t);
			squareRoot = (t + (number / t)) / 2;
			System.out.println("squareRoot : "+squareRoot);
		} while ((t - squareRoot) != 0);
	 System.out.println("count : "+count);
		return squareRoot;
	}
	
	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}
	
	public static int calcualteSumSubMatrix(int i, int j, int k, int l){
		if(i<0 || j < 0 || k<0 || l < 0)
			return -1;
		
		int cornerleft = 0;
		int cornerRight = 0;
		int diag = 0;
		if(i>0 && j>0){
			cornerleft = a[i-1][l];
			cornerRight = a[k][j-1];
			diag = a[i-1][j-1];
		} else if (i > 0){
			cornerleft = a[i-1][l];
		} else if (j> 0) {
			cornerRight = a[k][j-1];
		}
		
		return (a[k][l] - cornerleft - cornerRight + diag);
	}
	
	public static void calcualteSumMatrix(){
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				int left = 0, up = 0, diag = 0;
				if(i>0 && j>0){
					left = a[i][j-1];
					up = a[i-1][j];
					diag = a[i-1][j-1];
				} else if (i > 0){
					up = a[i-1][j];
				} else if (j> 0) {
					left = a[i][j-1];
				}
				a[i][j] = a[i][j] + left + up - diag;
			} 
		} printMatrix();
	}
	

	public static void printMatrix(){
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j]+" \t");
			} System.out.println();
		}
	}
}
