package com.altuhin.datastructure.stack;

public class StackMain {
	
	/**
	 *  ===== Stack Operation ======
	 *  1) push(int) // insert head
	 *  2) pop() // remove from head
	 *  3) peek() // return from head
	 *  4) length()
	 */
	
	Node head;
	
	public int length() {
		System.out.println("== print Stack===");
		Node root = head;
		int len = 0;
		while(root != null) {
			System.out.println(root.data);
			len++;
			root = root.next; 
		}
			return len;
	}
	
	public void push(int t) {
		Node newNode = new Node(t);
		Node root = head;
		if(root == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public void pop() {
		Node root = head;
		root = head.next;
		head = root;
	}
	
	public int peek() {
		Node root = head;
//		root = head.next;
//		head = root;
		return root.data;
	}
	
	public static void main(String[] args) {
		StackMain  stack = new StackMain();
		stack.push(15);
		stack.push(13);
		stack.push(28);
		stack.push(155);
		System.out.println(stack.length());
		stack.pop();
		System.out.println(stack.length());
		System.out.println("===peek value==");
		System.out.println(stack.peek());
	}
	
}
