package com.ankit.creditSuisse;
public class Branches {
    public static int count(int[] tree) {
    	int branches = 0;
    	if(tree.length == 0){
    		throw new UnsupportedOperationException("Waiting to be implemented.");
    	}
    	int len = tree.length;
    	for (int i = 0; i < len; i++) {
			if (2*i+1 < len) {
				branches++;
			}
		}
    	return branches;
    }

    public static void main(String[] args) {
        System.out.println(Branches.count(new int[] { 1, 3, 1, -1, 3 }));
        System.out.println(Branches.count(new int[] { 1,0,4,1 }));
    }
}