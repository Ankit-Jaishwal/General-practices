package com.ankit.sortings;

public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] inputArr = {2,7,5,1,3,-15, 4};
		
		//call the heapify method to rearrange the in Heap Order
		heapify(inputArr, inputArr.length);
		int end = inputArr.length - 1;
		while (end > 0) {
			// swap the first element to last, as after the Heapify/shiftDown call, the max element will at 0th index
			swap(inputArr, 0, end);
			end--;
			shiftDown(inputArr, 0, end);
		}
		print(inputArr);
		
	}
	
	// this method will arrange the array in Heap order (the max element will be at the top of the array)
	public static void heapify(int[] arr, int count) {
		int start = (count - 1 - 1)/2; //getting the last parental node from the formula -- iParent     = floor((i-1) / 2), i being the last node
		int end = count - 1;
		while(start >= 0){
			shiftDown(arr, start, end);
			start--;
		}
	}
	
	public static void shiftDown(int[] arr, int start, int end) {
		int leftChild ;
		int root = start;
		int swap;
		while (2*root+1 <= end) { 	//checking if any child exist after this
			leftChild = 2*root+1; 	//getting the left child
			swap = root; 			// by default assigning the root to be as the swap element
			
			if (arr[leftChild] > arr[swap]) {
				swap = leftChild;
			}
			
			if (leftChild + 1 < end && arr[leftChild+1] > arr[swap]){
				swap = leftChild+1;
			}
			
			if (root == swap){
				return;
			} else {
				// swap the elements
				swap(arr, root, swap);
				root  = swap;
			}
		}
	}
	
	public static void swap (int [] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void print (int [] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i] + "\t");
		}
		System.out.println();
	}

}
