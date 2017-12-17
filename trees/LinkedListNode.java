package com.ankit.trees;

public class LinkedListNode {
	public int key;
	public LinkedListNode next;
	
	public LinkedListNode() {
		// TODO Auto-generated constructor stub
	}

	public LinkedListNode(int key, LinkedListNode next) {
		super();
		this.key = key;
		this.next = next;
	}
	
	public static LinkedListNode getListOfNSize(int n) {
		if (n <= 0) 
			return null;
		LinkedListNode header = new LinkedListNode(1, null);
		LinkedListNode curr = header;
		LinkedListNode temp = null;
		for (int i = 2; i <= n; i++) {
			temp = new LinkedListNode(i, null);
			curr.next = temp;
			curr = temp;
		}
		return header;
	}
	
	@Override
	public String toString() {
		return this.key+"-->"+(next == null ? "null":"");
	}
	
	
	public static void main(String[] args) {
		LinkedListNode header= getListOfNSize(10);
		LinkedListNode curr = header;
		while(curr != null){
			System.out.print(curr.toString());
			curr = curr.next;
		}
	}
}
