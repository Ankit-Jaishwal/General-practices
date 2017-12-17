package com.ankit.sortings;

import java.util.Arrays;

public class MergeSortWithInversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 7, 3, 8, 1, 2, 9 };
		int[] sortedArr = new int[arr.length];
		int inversionCount = mergeSort(arr, sortedArr, 0, arr.length - 1);
		System.out.println("inversionCount : " + inversionCount);
	}

	private static int mergeSort(int[] arr, int[] sortedArr, int left, int right) {
//		System.out.println("left : "+left);
//		System.out.println("right : "+right);
		int inversionCount = 0;
		if (left < right) {
			int mid = (left + right) / 2;
			inversionCount = mergeSort(arr, sortedArr, left, mid);
			inversionCount += mergeSort(arr, sortedArr, mid + 1, right);
			inversionCount += merge(arr, sortedArr, left, mid + 1, right);
			System.out.println("arr : " + Arrays.toString(arr));
			System.out.println("Sorted arr : " + Arrays.toString(sortedArr));
			return inversionCount;
		}
		return inversionCount;
	}

	private static int merge(int[] arr, int[] sortedArr, int left, int mid,
			int right) {
		int i = left;
		int j = mid;
		int k = left;
		int inversionCount = 0;
		
		while ((i < mid) && j <= right) {
			if(arr[i] < arr[j]){
				sortedArr[k++] = arr[i++];
			} else {
				sortedArr[k++] = arr[j++];
				inversionCount = inversionCount + (mid - i);
			}
		}
		
		while(i < mid){
			sortedArr[k++] = arr[i++];
		}
		
		while(j <= right){
			sortedArr[k++] = arr[j++];
		}
		
		for (i=left; i <= right; i++)
		    arr[i] = sortedArr[i];
		
		System.out.println("arr 1 : " + Arrays.toString(arr));
		System.out.println("Sorted arr 1  : " + Arrays.toString(sortedArr));
		return inversionCount;
	}

}
