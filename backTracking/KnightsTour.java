package com.ankit.backTracking;

public class KnightsTour {

	static int[][] a = { { -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 } };
	static int row = a.length;
	static int col = a[0].length;

	public static void main(String[] args) {
		solveKT();
	}
	
	static boolean solveKT() {
		// All possible moves for a Knight in a chess board.
		int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
		int[] yMoves = {1,2,2,1,-1,-2,-2,-1};
		
		
		//Start position for the knight, assuming knight is starting from 0,0
		a[0][0] = 0;
		
		if(!solveKtUtil( 0, 0, 1, xMoves, yMoves)){
			System.out.println("Path does not exist.");
			printSolution(a);
		}else {
			printSolution(a);
		}
		return false;
	}

	private static void printSolution(int[][] a2) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(a2[i][j]+"  ");
			}
			System.out.println();
		}
	}

	static boolean solveKtUtil(int x, int y, int moveCount, int[] xMoves, int[] yMoves) {
		if (moveCount == row*col) {
			return true;
		}
		int next_x = 0, next_y = 0;
		for (int i = 0; i < yMoves.length; i++) {
			next_x = x + xMoves[i];
			next_y = y + yMoves[i];
//			System.out.println("moveCount : " + moveCount + "  x : " + x + "  y : " + y);
			if (isSafe(a,next_x,next_y)) {
				a[next_x][next_y] = moveCount;
//				printSolution(a);
//				System.out.println();

				if (solveKtUtil(next_x, next_y, moveCount + 1, xMoves, yMoves)) {
					return true;
				} else {
					a[next_x][next_y] = -1;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] a2, int nextX, int nextY) {
		if (nextX >=0 && nextX < row && nextY >=0 && nextY < row && a2[nextX][nextY] == -1) {
			return true;
		}
		return false;
	}
}
