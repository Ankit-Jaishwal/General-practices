package com.ankit.queueNstacks;
import java.util.Stack;

public class QueueUsingStack {
	Stack<Integer> pushStack = new Stack<>();
	Stack<Integer> popStack = new Stack<>();
	public static void main(String[] args) {
		
		QueueUsingStack queue = new QueueUsingStack();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.dequeue();
		queue.enqueue(7);
		queue.dequeue();
		queue.enqueue(9);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
	}
	
	public void enqueue(int n){
		pushStack.push(n);
		System.out.println(n + " inserted successfully : ");
	}
	
	public int dequeue(){
		if (popStack.isEmpty()) {
			while(!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
		}
		if(!popStack.isEmpty()){
			int item = popStack.pop();
			System.out.println(" item dequeued : "+item);
			return item;
		}
		System.out.println("No more items to dequeue");
		return Integer.MIN_VALUE;
	}

}