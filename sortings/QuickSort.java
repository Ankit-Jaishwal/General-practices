package com.ankit.sortings;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {2,7,5,9,3,-15};
		print(arr);
		quickSort(arr, 0, arr.length-1);
		print(arr);

	}
	
	// 
	public static void quickSort(int[] arr, int left, int right) {
		int partitionIndex = partition(arr, left, right);
		System.out.println("after partitioning - - - " + partitionIndex);
		print(arr);
		
		if(left < partitionIndex - 1)
			quickSort(arr, left, partitionIndex-1);
		if (right > partitionIndex )
			quickSort(arr, partitionIndex , right);
	}
	
	// this method will do the partitioning of the array and return the index of partitioned Array 
	public static int partition(int[] arr, int left, int right){
		int pivot = arr[(left+right)/2];
		int i = 0;
		while(left <= right)  {
			
			System.out.println("while"+i++ );
			//if the condition is true, it imply that the item is in correct partition,
			//and hence moving to next item. If not we get our misplaced item in the left partition
			while(arr[left] < pivot)
				left++;
			
			//if the condition is true, it imply that the item is in correct partition,
			//and hence moving to previous index. If not we get our misplaced item in the right partition
			while(arr[right] > pivot)
				right--;
			
			// after getting our misplaced items from the respective partitions, 
			// we will swap the element and increment/decrement the indexes accordingly if and only if left is less than right
			if (left <= right)
			{
				if (left < right)
				swap(arr, left, right);
				
				left++;
				right--;
			}
			
		}
		//return the left index 
		return left;
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
