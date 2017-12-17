package com.ankit.sortings;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {2,7,5,1,3,-15};
		mergeSort(arr);
		print(arr);
	}
	
	public static void mergeSort(int[] arr) {
		int arrLength = arr.length;
		if (arrLength < 2)
			return;
		int mid = arrLength/2;
		int[] a1 = new int[mid];
		int[] a2 = new int[arrLength - mid];
		for (int i = 0; i < mid; i++) {
			a1[i] = arr[i];
		}
		for (int i = mid, j= 0; i < arr.length; i++, j++) {
			a2[j] = arr[i];
		}
		mergeSort(a1);
		mergeSort(a2);
		merge(a1, a2, arr);
	}
	

	public static void merge(int[] a1, int[] a2, int[] mergedArray) {
		int i = 0;
		int j = 0;
		int k = 0;
		// keep running the loop, till either of the Array exhausts
		while(i < a1.length && j < a2.length) {
			if(a1[i] < a2[j]) {
				mergedArray[k] = a1[i];
				i++;
			} else {
				mergedArray[k] = a2[j];
				j++;
			}
			k++;
			System.out.println("k -- "+k);
		}
		
		while(i < a1.length ) {
			mergedArray[k++] = a1[i++];
		}
		
		while(j < a2.length ) {
			mergedArray[k++] = a2[j++];
		}
	}
	
	public static void print (int [] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i] + "\t");
		}
		System.out.println();
	}

}
