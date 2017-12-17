package com.ankit.trees;


public class LinkedListBST {
	public static TreeNode root = new TreeNode(null, null, null, null);
	public static final String LEAF_NODE = "LEAF_NODE";
	public static final String ONE_CHILD_NODE = "ONE_CHILD_NODE";
	public static final String PROPER_NODE = "PROPER_NODE";
	public static final String LEFT_CHILD = "LEFT_CHILD";
	public static final String RIGHT_CHILD = "RIGHT_CHILD";
	
	
	public static void main(String[] args) {
		//TreeNode root = new TreeNode(null, null, null, null);
		insert(root, 25);
		insert(root, 12);
		insert(root, 37);
		insert(root, 6);
		insert(root, 18);
		insert(root, 31);
		insert(root, 43);
		insert(root, 3);
		insert(root, 15);
		insert(root, 34);
		insert(root, 14);
		//Print the List in PreOrder way
		System.out.println("PreOrder walk : " );
		preOrderTraverse(root);
		System.out.println();
		//Print the List in inOrder way
		System.out.println("PreOrder walk : " );
		inOrderTraverse(root);
		
		// Search a given item/key
		TreeNode searchNode = searchNode(root, 43);
		System.out.println();
		System.out.println("Node found = "+searchNode);
		
		// Delete a given item/key
		// Case 1: if the node is leaf node. Here node with key 3, 14, 34, 43 are Leaf Nodes
		System.out.println("Deleting a leaf Node having key 3");
		searchAndDeleteNode(root, 3);
		inOrderTraverse(root);
		System.out.println();
		// Case 2 : if the node have only one child (either left or right). Here node with key 6,  15, 18, 31 have one child 
		
		System.out.println("Deleting a Node which have one child and having key 15");
		searchAndDeleteNode(root, 15);
		inOrderTraverse(root);
		System.out.println();
		// Case 3 : if the node have both the child.
		System.out.println("Deleting Node with two child having key 12");
		searchAndDeleteNode(root, 12);
		inOrderTraverse(root);
		System.out.println();
		
	}
	
	/**
	 * This method searches a node with given item and then deletes it.
	 * @param node
	 * @param item
	 */
	public static void searchAndDeleteNode(TreeNode node, int item){
		TreeNode nodeToBeDeleted = searchNode(node, item);
		if (null == nodeToBeDeleted) {
			System.out.println("Node not found.!!");
		} else {
			deleteNode(nodeToBeDeleted);
		}
	}
	
	
	/**
	 * This is a generic method which will delete a given Node, 
	 * which might be a LEAF_NODE or ONE_CHILD_NODE or PROPER_NODE (having both the childs)
	 * @param nodeToBeDeleted
	 */
	public static void deleteNode(TreeNode nodeToBeDeleted){
		String nodeType = getNodeType(nodeToBeDeleted);
		// Case 1 : if the node is leaf node.
		if (LEAF_NODE.equals(nodeType)) {
			deleteLeafNode(nodeToBeDeleted);
		} 
		// Case 2 : if the node have only one child (either left or right).
		else if (ONE_CHILD_NODE.equals(nodeType)) {
			deleteNodeWithOneChild(nodeToBeDeleted);
		}
		// Case 3 : if the node have both the child.
		else{
			deleteNodeWithTwoChild(nodeToBeDeleted);
		}
	}
	
	
	/**
	 * This method deletes a node which have both childs
	 * @param nodeToBeDeleted
	 */
	private static void deleteNodeWithTwoChild(TreeNode nodeToBeDeleted) {
		TreeNode successorNode = findSuccessor(nodeToBeDeleted);
		// copy the successor node's key to nodeToBeDeletednode and delete the successorNode
		nodeToBeDeleted.setKey(successorNode.getKey());
		// here successorNode can be a node with no child (LeafNode) or max One Child. Hence Calling the deleteNode method which will decide and delete the node accordingly.
		deleteNode(successorNode);
	}

	
	/**
	 * This method deletes a node which is of type @ONE_CHILD_NODE
	 * @param nodeToBeDeleted
	 */
	private static void deleteNodeWithOneChild(TreeNode nodeToBeDeleted) {
		TreeNode parent = nodeToBeDeleted.getParent(); // get the parent node
		TreeNode childNode = null;
		// get the child node whether its Left or right and set it as null for the nodeToBeDeleted
		if (nodeToBeDeleted.getLeft() != null) { 
			childNode = nodeToBeDeleted.getLeft();
			nodeToBeDeleted.setLeft(null);
		} else {
			childNode = nodeToBeDeleted.getRight();
			nodeToBeDeleted.setRight(null);
		}
		// Set the child node (of the nodeToBeDeleted) to its parent node as left or right child based on the Key of the nodeToBeDeleted 
		if(nodeToBeDeleted.getKey() < parent.getKey())
			parent.setLeft(childNode);
		else 
			parent.setRight(childNode);
		childNode.setParent(parent);
		// set null as the parent for nodeToBeDeleted .
		nodeToBeDeleted.setParent(null);
		System.out.println("Node deleted == "+nodeToBeDeleted.toString());
	}

	
	/**
	 * This method deletes a node which is of type LEAF_NODE
	 * @param nodeToBeDeleted
	 */
	private static void deleteLeafNode(TreeNode nodeToBeDeleted) {
		TreeNode parent = nodeToBeDeleted.getParent();
		if(nodeToBeDeleted.getKey() < parent.getKey())
			parent.setLeft(null);
		else 
			parent.setRight(null);
		nodeToBeDeleted.setParent(null);
		System.out.println("Node deleted == "+nodeToBeDeleted.toString());
	}
	

	/**
	 * This method searches a node having the given key and return that node.
	 * And returns null if not found.
	 * @param node
	 * @param item
	 * @return
	 */
	public static TreeNode searchNode(TreeNode node, int item){
		if(node == null){
			return null;
		}
		if (node.getKey() == item) {
			return node;
		} else {
			if (item < node.getKey()) {
				return searchNode(node.getLeft(), item);
			} else {
				return searchNode(node.getRight(), item);
			}
		}
	}
	
	
	/**
	 * This method inserts item in given Linked List having the header @ root.
	 * @param node
	 * @param item
	 */
	public static void insert(TreeNode node, int item) {
		if (node.getKey() == null) {
			node.setKey(item);
		} else {
			if (item < node.getKey()) {
				if(node.getLeft() == null){
					node.setLeft(new TreeNode(item, node, null, null));
				} else {
					insert(node.getLeft(), item);
				}
			} else {
				if(node.getRight() == null){
					node.setRight(new TreeNode(item, node, null, null));
				} else {
					insert(node.getRight(), item);
				}
			}
		}
	}
	
	
	/**
	 * This method returns the successor node for a given node.
	 * @param node
	 * @return
	 */
	private static TreeNode findSuccessor(TreeNode node) {
		// TODO : here not checking for the null case scenario for right child as it cant be null in this case, need to enhance this method with that case as well
		return minNode(node.getRight());
	}

	
	/**
	 * This method returns the min node in a Tree.
	 * @param node
	 * @return
	 */
	private static TreeNode minNode(TreeNode node) {
		if (null == node.getLeft()) {
			return node;
		} else {
			return minNode(node.getLeft());
		}
	}
	
	
	/**
	 * This method returns the max node in a Tree.
	 * @param node
	 * @return
	 */
	@SuppressWarnings("unused")
	private static TreeNode maxNode(TreeNode node) {
		if (null == node.getRight()) {
			return node;
		} else {
			return maxNode(node.getRight());
		}
	}

	/**
	 * This method return the mode type i.e LEAF_NODE, ONE_CHILD_NODE or PROPER_NODE (with two child)
	 * @param node
	 * @return
	 */
	private static String getNodeType(TreeNode node) {
		if(node.getLeft() == null && node.getRight() == null)
			return LEAF_NODE;
		else if (node.getLeft() == null || node.getRight() == null) 
			return ONE_CHILD_NODE;
		else
			return PROPER_NODE;
	}
	
	/**
	 * This method prints the list in InOrder way
	 * @param node
	 */
	public static void inOrderTraverse(TreeNode node) {
		if (node == null) {
			return;
		} else {
			inOrderTraverse(node.getLeft());
			System.out.print(node.getKey() + "\t");
			inOrderTraverse(node.getRight());
		}
	}
	
	/**
	 * This method prints the list in preOrder way
	 * @param node
	 */
	public static void preOrderTraverse(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.print(node.getKey() + "\t");
			preOrderTraverse(node.getLeft());
			preOrderTraverse(node.getRight());
		}
	}
	
	/**
	 * This method prints the list in post order way
	 * @param node
	 */
	public static void postOrderTraverse(TreeNode node) {
		if (node == null) {
			return;
		} else {
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			System.out.print(node.getKey() + "\t");
		}
	}
}


