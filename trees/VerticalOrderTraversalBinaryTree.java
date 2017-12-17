package com.ankit.trees;

public class VerticalOrderTraversalBinaryTree {

	/**
	 * @param args
	 */
	static int min = 0 , max = 0; 
	public static void main(String[] args) {
//		int min = 0 , max = 0; 
		TreeNode root = new TreeNode(null, null, null, null);
		LinkedListBST.insert(root, 19);
		LinkedListBST.insert(root, 14);
		LinkedListBST.insert(root, 20);
		LinkedListBST.insert(root, 18);
		LinkedListBST.insert(root, 16);
		LinkedListBST.insert(root, 15);
		
		System.out.println("root="+root);
		minMaxHorizontal(root , 0);
		System.out.println("min ="+min);
		System.out.println("max ="+max);
	}
	
	public static void minMaxHorizontal(TreeNode root , int val){
		
		if(root == null){
			return;
		}
		
		if(val < min) min = val;
		if(val > max) max = val;
		System.out.println("min ="+min);
		System.out.println("left="+root.getLeft());
		minMaxHorizontal(root.getLeft() , val - 1);
		System.out.println("left="+root.getLeft());
		minMaxHorizontal(root.getRight() , val + 1);
		
	}

}
