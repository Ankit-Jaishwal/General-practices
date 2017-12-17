package com.ankit.searching;

public class BlankSpaceSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inputStrArr = {"at","","","","ball","","","car","","","dad","",""};
		System.out.println(inputStrArr.length);
		String searchStr = "aja";
		int index = search(inputStrArr, searchStr, 0, inputStrArr.length-1);
		if (index == -1 ) {
			System.out.println("Given string is not in the Array");
		} else {
			System.out.println("index of the search string is : " + index);
		}
		

	}
	
	public static int search(String[] inputStr, String searchStr, int first, int last ) {
		int low  = first;
		int high = last;
		int mid = 0;
		if (searchStr == null || "".equals(searchStr)) {
			return -1;
		}
		while(low<high) {
			mid = (low + high)/2;
			if (inputStr[mid].equals(searchStr)) {
				return mid;
			}
			else {
				// Find the closest mid if the current mid is empty (i.e. "")
				if ("".equals(inputStr[mid])) {
					mid = searchClosestMid(inputStr, first, last, mid); 
				}
				if (mid != -1) {
					int compare = searchStr.compareTo(inputStr[mid]);
					if (compare == 0) { //element found and return the mid
						return mid;
					} else if (compare > 0) { // Element must be in the right half, hence update low
						low = mid + 1;
					} else { // Element must be in the left half, hence update high
						high = mid - 1;
					}
				} else {
					return -1;
				}
				
			}
		}
		return -1;
	}

	private static int searchClosestMid(String[] inputStr, int first, int last ,int mid) {
		int left = mid - 1;
		int right = mid + 1;
		while(left>=first || right<=last) {
			if (left>=first && !inputStr[left].isEmpty()) {
				return left;
			} else if(right<=last && !inputStr[right].isEmpty()){
				return right;
			}
			left--;
			right++;
		}
		return -1;
	}
}
