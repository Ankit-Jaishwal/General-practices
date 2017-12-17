package com.ankit.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import sun.security.util.Length;

public class TreeUtil {
	
	/**
	 * This util method recursively computes the height of a tree
	 * @param node
	 * @return
	 */
	public static int getHeight(TreeNode node) {
		if(node == null) 
			return 0;
		return (Math.max(getHeight(node.getLeft()), getHeight(node.getRight()))+1);
	}
	
	public static int checkHeight(TreeNode node) {
		if(node == null) 
			return 0;
		int leftNodeHeight = checkHeight(node.getLeft());
		if (leftNodeHeight == -1) {
			return -1;
		}
		int RightNodeHeight = checkHeight(node.getRight());
		if (RightNodeHeight == -1) {
			return -1;
		}
		int diff = Math.abs(RightNodeHeight-leftNodeHeight);
		if(diff > 1){
			return -1;
		}
		
		return (Math.max(leftNodeHeight, RightNodeHeight)+1);
	}
	
	/**
	 * This method checks and returns whether the given tree is balanced or not,
	 * balanced means: that for each node, the two subtrees differ in height by no more than one
	 * Though the below one works fine, but takes O(n^2) time, which is not efficient enough. 
	 * @param node
	 * @return
	 */
	public static boolean isBalanced(TreeNode node) {
		int LSTHeight = getHeight(node.getLeft());
		int RSTHeight = getHeight(node.getRight());
		int diff = LSTHeight - RSTHeight;
		if (Math.abs(diff) > 1) {
			return false;
		} else {
			// recurse and find 
			return isBalanced(node.getLeft()) && isBalanced(node.getRight());
		}
	}
	
	
	
	public static boolean isBalancedOptimized(TreeNode node) {
		int LSTHeight = getHeight(node.getLeft());
		int RSTHeight = getHeight(node.getRight());
		int diff = LSTHeight - RSTHeight;
		if (Math.abs(diff) > 1) {
			return false;
		} else {
			// recurse and find 
			return isBalanced(node.getLeft()) && isBalanced(node.getRight());
		}
	}
	
	
	//TODO : yet to write optimized util code for checking if a tree is balanced or not
	
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		// A null tree is always a subtree, hence return true.
		if(t2 == null)
			return true;
		// verified above that t2 is not null, hence proceed to find if t2 is Subtree of t1 or not
		return subTree(t1, t2);
	}
	
	
	
	public static boolean subTree(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return false; //t2 Still not found and t1 reached to null.
		}
		
		if(t1.getKey() == t2.getKey()){
			if(matchTree(t1,t2))
				return true; 
		}
		return (subTree(t1.getLeft(), t2) || subTree(t1.getRight(), t2));
	}


	public static boolean matchTree(TreeNode t1, TreeNode t2) {
		// This implies that t2 is completed and it matching till now
		if (t2 == null) {
			return true;
		}
		
		// This implies that t1 is completed but t2 is still not exhausted, which implies tree did not match
		if (t1 == null) {
			return false;
		}
		
		// if there is mismatch, then surely t2 is not subtree of t1  
		if (t1.getKey() != t2.getKey()) {
			return false;
		}
		
		// keep expanding towards left and right.
		return (matchTree(t1.getLeft(), t2.getLeft()) && matchTree(t1.getRight(), t2.getRight()));
	}
	
	
	public static void findSum(TreeNode node, int sumToMatch) {
		int height = getHeight(node);
		int[] path = new int[height];
		findSum(node, sumToMatch, path, 0);
	}
	
	public static void findSum(TreeNode node, int sumToMatch, int[] path, int level) {
		if (node == null) {
			return;
		}
		
		path[level] = node.getKey();
		int sum = 0;
		for (int i = level; i >=0; i--) {
			sum = sum + path[i];
			if (sum == sumToMatch) {
				printPath(path, i, level);
			}
		}
		findSum(node.getLeft(), sumToMatch, path, level+1);
		findSum(node.getRight(), sumToMatch, path, level+1);
	}
	
	public static void treeSpiralPrint(TreeNode node){
		Stack<TreeNode> s1 = new Stack<TreeNode>(); // this stack will store node from right to left
		Stack<TreeNode> s2 = new Stack<TreeNode>(); // this stack will store node from left to right
		s1.push(node);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			TreeNode temp = null;
			while (!s1.isEmpty()){
				temp = s1.pop();
				if(temp.getLeft() != null)
					s2.push(temp.getLeft());
				if(temp.getRight() != null)
					s2.push(temp.getRight());
			}
			while (!s2.isEmpty()){
				temp = s2.pop();
				if(temp.getRight() != null)
					s1.push(temp.getRight());
				if(temp.getLeft() != null)
					s1.push(temp.getLeft());
			}
			System.out.println(temp.getKey());
		}
	}

	
	public static LinkedListNode reverseLinkedList(LinkedListNode node) {
		LinkedListNode header = node;
		LinkedListNode prev = null;
		LinkedListNode curr = header;
		LinkedListNode temp = null;
		while (curr != null){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		printLinkedList(prev);
		return prev;
	}
	
	public static LinkedList<LinkedListNode> reverseLinkedList(LinkedListNode node, int k) {
		LinkedList<LinkedListNode> revList = new LinkedList<LinkedListNode>();
		LinkedListNode header = node;
		
		LinkedListNode prev = null;
		LinkedListNode curr = header;
		LinkedListNode temp = null;
		int i=0;
		while (i < k && curr != null){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			i++;
		}
		revList.add(prev);
		revList.add(header);
		revList.add(curr);
		printLinkedList(prev);
		return revList;
	}
	
	public static LinkedListNode reverseLLinGrp(LinkedListNode node, int k){
		LinkedList<LinkedListNode> revList = reverseLinkedList(node, k);
		LinkedListNode header = revList.getFirst();
		LinkedListNode last = revList.get(1); // getting the last node of the reversed list
		LinkedListNode nextOfLast = revList.getLast();
		while(nextOfLast != null){
			revList = reverseLinkedList(nextOfLast, k);
			last.next = revList.getFirst();
			nextOfLast = revList.getLast();
			last = revList.get(1);
		}
		return header;
	}
	
	
	
	public static void printLinkedList(LinkedListNode header) {
		LinkedListNode curr = header;
		while(curr != null){
			System.out.print(curr.toString());
			curr = curr.next;
		} System.out.println();
	}

	private static void printPath(int[] path, int i, int level) {
		for (int j = i; j <= level; j++) {
			System.out.print(path[j]+ ", ");
		} 
	}
	
	
	public static void main(String[] args) {
		LinkedListNode header= LinkedListNode.getListOfNSize(4);
		
		System.out.println("before");
		printLinkedList(header);
		
		System.out.println("after");
		header = reverseLLinGrp(header,3);
		printLinkedList(header);
		//reverseLinkedList(header);
	}
}
