package com.ankit.matrix;

public class SpiralPrint {
	// Input array
	static int [][] arr =  {{1,2,3,11},
							{4,5,6,12},
							{7,8,9,13}};
	static int rows = arr.length;
	static int cols = arr[0].length;
	

	public static void main(String[] args) {
		matrixSpiralPrint();
	}
	
	public static void matrixSpiralPrint() {
		int minRow = 0;
		int maxRow = rows-1;
		int minCol = 0;
		int maxCol = cols-1;
		
		while (minRow <= maxRow || minCol <= maxCol){
			
			//print top row
			for (int i = minCol; i <= maxCol; i++) {
				System.out.print(arr[minRow][i]+"   ");
			}
			minRow++;
			//System.out.println("***minRow"+minRow);
			//print last col
			for (int i = minRow; i <= maxRow; i++) {
				System.out.print(arr[i][maxCol]+"   ");
			}
			maxCol--;
			
			//print last row reverse
			for (int i = maxCol; i >= minCol; i--) {
				System.out.print(arr[maxRow][i]+"   ");
			}
			maxRow--;
			
			//print first col reverse
			for (int i = maxRow; i >= minRow ; i--) {
				System.out.print(arr[i][minCol]+"   ");
			}
			minCol++;
			System.out.println();
			System.out.println("minRow"+minRow);
			System.out.println("maxRow"+maxRow);
			System.out.println("minCol"+minCol);
			System.out.println("maxCol"+maxCol);
			
		}
		
	}

}
