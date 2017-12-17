package com.ankit.matrix;

public class KeypadNumber {
	
	static String[][] s = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}};
	static int rows = s.length;
	static int col = s[0].length;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printInSpiralForm();
		
//		System.out.println(""+rows);
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < col; j++) {
//				generateNumber(i, j, 1, "");
//			}
//		}
	}
	
	public static void printInSpiralForm(){
		for (int i = 0; i < rows; i++) {
			boolean isOdd = (i%2 == 0);
			for (int j = 0, k = col-1; j < col || k>= 0; j++, k--) {
				if(isOdd)
				System.out.print(s[i][j]);
				else
				System.out.print(s[i][k]);
				
			}
			System.out.println();
		}
	}
	
	public static void generateNumber(int r, int c, int n, String str){
		if (r < 0 || r > rows-1 || c < 0 || c > col-1 || n >= 4) {
			return;
		}
		if(n == 3 ){
			str = str + s[r][c];
			if(!(str.contains("*") || str.contains("#"))){
				System.out.print(str+", ");
			}
			return;
		}
		str = str + s[r][c];
		n = n+1;
		generateNumber(r, c, n, str); 	//call for self
		generateNumber(r, c-1, n, str); // call for left
		generateNumber(r, c+1, n, str); // call for right
		generateNumber(r-1, c, n, str); // call for up
		generateNumber(r+1, c, n, str); // call for down
		
		
		
		
	}

}
