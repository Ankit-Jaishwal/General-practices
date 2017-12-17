package com.ankit.searching;

import java.util.ArrayList;
import java.util.Collections;


public class LongestSequence {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeightWeight htWt1 = new HeightWeight(50,60);
		HeightWeight htWt2 = new HeightWeight(60,59);
		HeightWeight htWt3 = new HeightWeight(45,50);
		HeightWeight htWt4 = new HeightWeight(83,100);
		HeightWeight htWt5 = new HeightWeight(30,60);
		ArrayList<HeightWeight> list = new ArrayList<HeightWeight>();
		list.add(htWt1);
		list.add(htWt2);
		list.add(htWt3);
		list.add(htWt4);
		list.add(htWt5);
		System.out.println("List before sorting == >");
		printSeq(list, 0, list.size()-1);
		Collections.sort(list);
		System.out.println();
		System.out.println("List after sorting == >");
		printSeq(list, 0, list.size()-1);
		System.out.println();
		findLongestSeq(list);
	}
	
	public static void findLongestSeq(ArrayList<HeightWeight> list) {
		int maxSeqCount = 1;
		int currSeqCount = 1;
		int seqSI = 0;
		int seqEI = 0;
		int maxSI = 0;
		int maxEI = 0;
		for (int i = 1; i < list.size(); i++) {
			HeightWeight heightWeight = list.get(i-1);
			HeightWeight heightWeight1 = list.get(i);
			if (heightWeight.wt<heightWeight1.wt) {
				seqEI = i;
				currSeqCount++;
				System.out.println("currSeqCount = "+currSeqCount);
				if (currSeqCount>maxSeqCount) {
					maxSI = seqSI;
					maxEI = seqEI;
					maxSeqCount = currSeqCount;
				} 
			} 
			else {
			seqSI = i;
			seqEI = i;
			currSeqCount = 1;}
		}
		System.out.println("Longest seq from index = "+maxSI + " to index = "+maxEI);
		printSeq(list, maxSI, maxEI);
	}

	private static void printSeq(ArrayList<HeightWeight> list, int seqSI,
			int seqEI) {
		for (int i = seqSI; i <= seqEI; i++) {
			System.out.print(list.get(i).toString());
		}
	}
}



class HeightWeight implements Comparable<HeightWeight>{
	int ht;
	int wt;
	public HeightWeight(int ht, int wt) {
		this.ht = ht;
		this.wt = wt;
	}
	@Override
	public int compareTo(HeightWeight o) {
		if (this.ht != o.ht){
			return ((Integer)this.ht).compareTo(o.ht);
		} else {
			return ((Integer)this.wt).compareTo(o.wt);
		}
	}
	
	@Override
	public String toString() {
		return "(" + this.ht + "," + this.wt + ")";
	}
}


