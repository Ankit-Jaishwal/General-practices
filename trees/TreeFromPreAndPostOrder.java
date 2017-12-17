package com.ankit.trees;

import java.util.Arrays;

public class TreeFromPreAndPostOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] tree = {"a","b","e","c","d","f","g"};
		String[] preOrderT = {"a","b","c","d","e","f","g"};
		String[] postOrderT = {"c","d","b","f","g","e","a"};
		String[] opTree = new String[tree.length];
		int index = 0;
		try {
			treeFromPreAndPostOrder(preOrderT, postOrderT, index, opTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		printOutPutTree(opTree);
		System.out.println("Above tree is equal to Original label tree : "+ Arrays.equals(tree, opTree));
	}

	public static void treeFromPreAndPostOrder(String[] preOrderT,
		String[] postOrderT, int index, String[] opTree) throws Exception {
		
		if (preOrderT.length != postOrderT.length) {
			throw new Exception("Both the trees length shd be same");
		}
		//Step 1: 	
		String root = preOrderT[0];
		opTree[index] = root;
		
		if (preOrderT.length<=1) {
			return;
		}
		//Step 2: getting the left child from the PreOrder array, which will be followed by the root item.
		String lstRoot = preOrderT[1];
		//find the left child in PostOrder Array, which will imply that all the element before that in Post Array will be part of LST and after that will be part of RST.
		//accordingly determine the same in Preorder Array using the count of the elements in PostOrder LST and RST.
		int lstRootIndex = search(postOrderT, lstRoot);
		String[] postLST = Arrays.copyOfRange(postOrderT, 0, lstRootIndex+1);
		String[] postRST = Arrays.copyOfRange(postOrderT, lstRootIndex+1, postOrderT.length-1);
		
		//Step 3: 
		String[] preLST = Arrays.copyOfRange(preOrderT, 1, postLST.length+1);
		String[] preRST = Arrays.copyOfRange(preOrderT, postLST.length+1, preOrderT.length);
		
		//Step 4:
		treeFromPreAndPostOrder(preLST, postLST, (2*index+1), opTree);
		treeFromPreAndPostOrder(preRST, postRST, (2*index+2), opTree);
		
		
	}

	private static void printOutPutTree(String[] opTree) {
		for (int i = 0; i < opTree.length; i++) {
			System.out.print(opTree[i] + "\t");
		}
		System.out.println();
	}
	
	private static int search(String[] postOrderT, String lstRoot) {
		for (int i = 0; i < postOrderT.length; i++) {
			if (lstRoot.equals(postOrderT[i])) {
				return i;
			}
		}
		return -1;
	}
}
