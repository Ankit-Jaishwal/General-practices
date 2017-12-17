package com.ankit.matrix;

import java.util.HashMap;
import java.util.Map;

public class ConnectedIslands {
	static int [][] arr =  {{1,0,0},
							{0,1,0},
							{1,0,0}};
	static int rows = arr.length;
	static int cols = arr[0].length;
	public static void main(String[] args) {
		int isLandsCount = 0;
		Map<Integer, Integer> connectedIslandCountMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 1){
					isLandsCount++;
					connectedIslandCountMap.put(isLandsCount, fillAndCountCells(i, j));
				}
			}
		}
		
		System.out.println(connectedIslandCountMap);
	}
	private static Integer fillAndCountCells(int r, int c ){
		if (r < 0 || r > rows-1 || c < 0 || c > cols-1 ) {
			return 0;
		}
		int count = 0;
		if (arr[r][c] == 1) {
			count++;
		}
		arr[r][c] = 0;
		
		count  = count + fillAndCountCells(r, c +1);
		count  = count + fillAndCountCells(r, c -1);
		count  = count + fillAndCountCells(r + 1, c);
		count  = count + fillAndCountCells(r-1, c);
		count  = count + fillAndCountCells(r +1, c +1);
		count  = count + fillAndCountCells(r -1, c -1);
		count  = count + fillAndCountCells(r -1, c +1);
		count  = count + fillAndCountCells(r +1, c -1);
		
		return count;
	}

	
}
