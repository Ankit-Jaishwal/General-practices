package com.ankit.trees;

public class BinarySearchTree {
	static Integer[] bsTree = new Integer[11];
	static int rootIndex = 0;

	public static void main(String[] args)  {
		// printing default tree
		printBSTree();
		try {
			insert(rootIndex, 9);
			insert(rootIndex, 5);
			insert(rootIndex, 15);
			insert(rootIndex, 6);
			insert(rootIndex, 7);
			insert(rootIndex, 4);
			insert(rootIndex, 3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		printBSTree();
		System.out.println("Min Key of the tree == "+minKey(rootIndex));
		System.out.println("Max Key of the tree == "+maxKey(rootIndex));
		
		int searchItem = 6;
		System.out.println("Find index of elment " + searchItem + ", index = "+ search(searchItem, rootIndex));
		System.out.println();
		System.out.println("Successor of the given item = "+ searchItem +"  is = " +findSuccessor(searchItem));
		
		
	}
	
	/**
	 * This Method insert the item into the array based Binary Search tree.
	 * It throws error if the index where the item to be inserted. 
	 * @param currIndex
	 * @param item
	 * @throws Exception
	 */
	public static void insert(int currIndex, int item) throws Exception {
		if (currIndex>=bsTree.length) {
			throw new Exception("insertion index is out of the range of the BST -- index = " + currIndex);
		}
		if (bsTree[currIndex] == null) {
			bsTree[currIndex] = item;
		} else {
			if(item < bsTree[currIndex])
				insert(getLeftChildIndex(currIndex), item);
			else
				insert(getRightChildIndex(currIndex), item);
		}
	}

	/**
	 * This method finds the minimum value/element in the tree, starting from the Root index. 
	 * @param index
	 * @return
	 */
	public static Integer minKey(int index){
		int leftChildIndex = getLeftChildIndex(index);
		if (leftChildIndex >= bsTree.length || bsTree[leftChildIndex] == null) {
			return bsTree[index];
		}
		else {
			return minKey(leftChildIndex);
		}
	}
	
	/**
	 * This method finds the maximun value/element in the tree, starting from the Root index. 
	 * @param index
	 * @return
	 */
	public static Integer maxKey(int index){
		int rightChildIndex = getRightChildIndex(index);
		if (rightChildIndex >= bsTree.length || bsTree[rightChildIndex] == null) {
			return bsTree[index];
		}
		else {
			return maxKey(rightChildIndex);
		}
	}
	
	/**
	 * This method returns the index of an item for the gin tree and returns -1 if the item not found.
	 * @param item
	 * @param index
	 * @return
	 */
	public static int search(Integer item, int index) {
		int itemIndex = -1;
		if (index>= bsTree.length || null == bsTree[index]) {
			return itemIndex;
		} 
		if(bsTree[index] == item) {
			itemIndex = index;
		}
		else {
			if(item < bsTree[index])
				itemIndex = search(item, getLeftChildIndex(index));
			else
				itemIndex = search(item, getRightChildIndex(index));
		}
		return itemIndex;
	}
	
	// This methos finds the successor item for the given item.
	public static int findSuccessor(int item) {
		int searchItemIndex = search(item, rootIndex);
		if (searchItemIndex == -1) {
			return -1; // this means the item is not in the tree
		}
		int rightChildIndex = getRightChildIndex(searchItemIndex);
		
		if(rightChildIndex < bsTree.length && bsTree[rightChildIndex] != null) {
			return minKey(rightChildIndex); // get the minimum from the Right Subtree.
		} else {
			int index = findSuccessorFromParent(searchItemIndex);
			if(index < 0){
				return -1;
			}
			return bsTree[index]; // else get that node above the current node which is left child of its Parent 
		}
	}
	
	// this method return the successor index of the given index, traversing towards parent.
	public static int findSuccessorFromParent(int searchItemIndex) {
		int parentIndex = getParentIndex(searchItemIndex);
		if (parentIndex < 0) { // this implies that 
			return -1; 
		}
		if (isLeftChild(searchItemIndex,parentIndex)) {
			return parentIndex;
		} else {
			return findSuccessorFromParent(parentIndex);
		}
	}


	public static boolean isLeftChild(int searchItemIndex, int parentIndex) {
		if (bsTree[searchItemIndex] < bsTree[parentIndex]) { //if the item @searchItemIndex is less than the item @parentIndex then it is left child.
			return true;
		}
		return false;
	}
	
	public static boolean isRightChild(int searchItemIndex, int parentIndex) {
		if (bsTree[searchItemIndex] > bsTree[parentIndex]) { //if the item @searchItemIndex is greater than the item @parentIndex then it is right child.
			return true;
		}
		return false;
	}


	static void printBSTree() {
		for (int i = 0; i < bsTree.length; i++) {
			System.out.print("i = "+i +", value - "+bsTree[i] + "\t");
		}
		System.out.println();
	} 
	
	static int getLeftChildIndex(int i) {
		return 2*i+1;
	}
	
	static int getRightChildIndex(int i) {
		return 2*i+2;
	}

	static int getParentIndex(int i) {
		if(i <= 0)
			return -1;
		return (i-1)/2;
	}
}
