package com.ankit.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoinChangeDP {
	public static int[] denom = {1,2,5,3,6}; // array of denomination of available coins
	public static int[] coinArr ;
	public static Map<Integer, List<Integer>> coinMap = new HashMap<Integer, List<Integer>>();
	//public static 
	
	public static void main(String[] args) {
		int amt = 4;
		coinArr = new int[amt+1];
		coinArr[0] = 0;
		System.out.println(Arrays.toString(coinArr));
		System.out.println("Coins req : "+getMinCoin(amt));
		System.out.println("rec : ");
		System.out.println("Coins req Rec : "+getMinCoinRec(amt));
	}
	
	public static int getMinCoin(int amt) {
		
		// our target is to find min number of coins for all the money value from 1 to amt
		Map<Integer, List<Integer>> coinMap = new HashMap<Integer, List<Integer>>();
		 for(int rupee = 1; rupee <= amt; rupee++) {
			 //Initialize min coin for each rupee as the max value
			 coinArr[rupee] = Integer.MAX_VALUE-1;
			 List<Integer> coinList = new LinkedList<Integer>();
			 //iterate the denominations array and find the min number of coins
			 for (int i = 0; i < denom.length; i++) {
				 if(rupee - denom[i] >= 0) {
					int coins = coinArr[rupee - denom[i]];
					if( coins+1 < coinArr[rupee]) {
						coinArr[rupee] = coins + 1; // +1 is for above operation
						coinList.add(denom[i]);
//						if ((rupee - denom[i]) > 0 ) {
//							coinList.addAll(coinMap.get(rupee - denom[i]));
//						}
					}
				 }
			} coinMap.put(rupee, coinList);
		 } 
		 System.out.println(Arrays.toString(coinArr));
		// System.out.println("Coin set : " + coinMap);
		return coinArr[amt];
	}
	
	
	public static int getMinCoinRec(int remAmt) {
		if(remAmt == 0){
			return 0;
		}
		if(coinArr[remAmt] != 0) {
			return coinArr[remAmt];
		}
		coinArr[remAmt] = Integer.MAX_VALUE-1;
		for (int i = 0; i < denom.length; i++) {
			if (remAmt - denom[i] >= 0) {
				coinArr[remAmt] = Math.min((getMinCoinRec(remAmt - denom[i]) + 1), coinArr[remAmt]);
			}
		}
		return coinArr[remAmt];
	}
	

}
