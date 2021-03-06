package com.ankit.trees;

public class InOrderTraverse {

	public static void main(String[] args) {
		/*
		Let us assume our tree is like below (numbers beside each node/string represent their array index)
			     0-a 		--------- level 0
			     / \		
				/   \
			 1-b     2-e 	--------- level 1
			 /\       /\
			/  \	 /  \
		 3-c  4-d  5-f	6-g --------- level 2
		 					   
	 */
	
	String[] tree = {"a","b","e","c","d","f","g"};
	inOrderTraverse(tree, 0);

	}

	public static void inOrderTraverse(String[] tree, int index) {
		if(index >= tree.length) // checking if the tree has reached to its limit, if yes then return. 
			return;
		inOrderTraverse(tree, (2*index+1)); //traverse the left child
		visit(tree[index]); //visit the current node/item of the tree after traversing the left child
		inOrderTraverse(tree, (2*index+2)); //traverse the left child
	}
	
	// As of now we are just printing the element as part of visiting the node 
	private static void visit(String i) {
		System.out.print(i + "\t");
	}
}
