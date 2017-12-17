package com.ankit.trees;

public class TreeNode {
	private Integer key;
	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Integer key, TreeNode parent, TreeNode left, TreeNode right) {
		super();
		this.key = key;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return this.key.toString();
	}
}