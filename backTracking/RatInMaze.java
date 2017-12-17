package com.ankit.backTracking;

public class RatInMaze {
	
	static int [][] a = { 
		{1, 1, 1, 1},
        {1, 0, 0, 0},
        {1, 1, 0, 0},
        {0, 1, 1, 1}
    };
	static int [][] sol ={ {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };
	
	static int row = a.length;
	static int col = a[0].length;
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		findPathInMaze();

	}
	static void findPathInMaze(){
		
		if(findPathInMazeUtility(0,0)){
			System.out.println("Path exist");
		} else {
			System.out.println("Does not");
		}
	}
	
	static boolean findPathInMazeUtility(int x, int y){		
		if(x == row - 1 && y == col - 1){
			return true;
		}	
		boolean flag = false;
		if(isSafe(x,y)){
			sol[x][y]=1;
			flag = findPathInMazeUtility(x+1,y);
			if(!flag){
				flag = findPathInMazeUtility(x,y+1);
			}
			if(!flag) {
				sol[x][y]=0;
			}
		}
		return flag;
	}
	
	static boolean isSafe(int x , int y){
		if(x >= 0 && x < row && y >= 0 && y < col && a[x][y] == 1 )
			return true;
		else
			return false;
	}
	
	

}
