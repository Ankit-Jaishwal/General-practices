package com.ankit.searching;

public class SearchInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Below is input matrix in form of
		 * | 1 2 3 |
		 * | 4 5 6 |
		 * | 7 8 9 |
		 * */
		int[][] inputMatrix = {{1,2,3},{4,5,6},{7,8,9}};
		int findEl = 4;
		findfromMatrix(inputMatrix, findEl);
		
	}
	 public static void findfromMatrix(int[][] inputMatrix, int findEl){
		 int rows = inputMatrix.length;
			int cols = inputMatrix[0].length;
			int i = 0;
			int j = cols-1;
			System.out.println(i +", "+ j);
			boolean found = false;
			while(i<rows) {
				while(j>=0) {
					if (findEl == inputMatrix[i][j]) {
						found = true;
						System.out.println("Found the Element co-ordinates i = " + i + ", J = "+j);
						break ;
					} else if(findEl > inputMatrix[i][j]){
						i++;//moving to next row if the element is greater
					} else {
						j--; //shifting to previous column if the element is lesser
					}
				}
				if (found) {
					break;
				}
			}
			if(!found){
				System.out.println("Given element is not in the Matrix!!!");
				
			}
	 }
	

}
