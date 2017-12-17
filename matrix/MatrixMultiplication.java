package com.ankit.matrix;


public class MatrixMultiplication {
	int [][] a1 = {{1,2},{3,4}};
	int a1Rows = a1.length;
	int a1Cols = a1[0].length;
	int [][] a2 = {{1,2},{3,4}};
	int a2Rows = a2.length;
	int a2Cols = a2[0].length;
	int [][] opMatrix = new int[a1.length][a2[0].length];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixMultiplication multiplication = new MatrixMultiplication();
		multiplication.multiplyMatrix();
		//System.out.println(Arrays.toString(multiplication.opMatrix));
	}
	
	public void multiplyMatrix() {
		if(a1Cols != a2Rows){
			return;
		}
		for (int i = 0; i < a1Rows; i++) {
			for (int j = 0; j < a2Cols; j++) {
				int sum = 0;
				for (int k = 0; k < a1Cols; k++) {
					sum = sum + (a1[i][k]*a2[k][j]);
				}
				opMatrix[i][j] = sum;
				System.out.print(sum + "   ");
			}System.out.println();
		}
	}
	
	public void printMatrix() {
		for (int i = 0; i < a1Rows ; i++) {
			
		}
	}

}
