package com.ankit.trees;

import java.util.Arrays;

public class TreeFromInandPreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] tree = {"a","b","e","c","d","f","g"};
		String[] preOrderT = {"a","b","c","d","e","f","g"};
		String[] inOrderT = {"c","b","d","a","f","e","g"};
		String[] opTree = new String[tree.length];
		int index = 0;
		try {
			treeFromInAndPreOrder(preOrderT, inOrderT, index, opTree);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		printOutPutTree(opTree);
		System.out.println("Above tree is equal to Original label tree : "+ Arrays.equals(tree, opTree));
		
	}

	private static void printOutPutTree(String[] opTree) {
		for (int i = 0; i < opTree.length; i++) {
			System.out.print(opTree[i] + "\t");
		}
		System.out.println();
	}

	public static void treeFromInAndPreOrder(String[] preOrderT,
			String[] inOrderT, int index, String[] opTree) throws Exception {
		if (preOrderT.length != inOrderT.length) {
			throw new Exception("Both the trees length shd be same");
		}
		//Step 1 : 
		//getting the first element from the preorder Array as that will be root by convention 
		String root = preOrderT[0];
		//put in output array
		opTree[index] = root;
		
		if (preOrderT.length<= 1) 
			return;
		//Step 2 : 
		//now search the root item in Inorder array using which we will find out Left sub tree (LST) and Right Sub Tree(RST)
		int rootIndex = search(inOrderT, root);
		if (rootIndex == -1)
			throw new Exception("root not found in Inorder Array");
		//Getting the Inorder LST and RST
		String[] inLST = Arrays.copyOfRange(inOrderT, 0, rootIndex);
		String[] inRST = Arrays.copyOfRange(inOrderT, rootIndex + 1,
				inOrderT.length);
		//Step 3: 
		// getting the Preorder LST and PreOrder RST
		String[] preLST = Arrays.copyOfRange(preOrderT, 1, inLST.length + 1);
		String[] preRST = Arrays.copyOfRange(preOrderT, inLST.length + 1,
				preOrderT.length);
		// Step 4: 
		//recursively call the treeFromInandOrder method providing the inorder and preorder LST and RSTs
		treeFromInAndPreOrder(preLST, inLST, (2 * index + 1), opTree); // FOR LST
		treeFromInAndPreOrder(preRST, inRST, (2 * index + 2), opTree); // FOR RST
		
		
	}

	private static int search(String[] inOrderT, String root) {
		for (int i = 0; i < inOrderT.length; i++) {
			if (root.equals(inOrderT[i])) {
				return i;
			}
		}
		return -1;
	}

}
