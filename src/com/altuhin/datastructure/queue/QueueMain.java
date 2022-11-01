package com.altuhin.datastructure.queue;

public class QueueMain {
	Node head;
	/**
	 * 1) offer(int)
	 * 2) poll()
	 * 3) peek()
	 * 4) length
	 */
	
	public void poll() {
		Node  root = head;
		root = head.next;
		head = root;
	}

	public int peek() {
		Node  root = head;
		root = head.next;
		return root.data;
	}

	public int length() {
		Node root = head;
		int len = 0;
		System.out.println("===length==");
		while(root != null) {
			len++;
			System.out.print(root.data+" ");
			root = root.next;
		}
		return len;
	}
	
	public void offer(int value) {
		Node newNode = new Node(value);
		Node last = head;
		if(last == null) {
			head = newNode;
			return;
		}
		while(last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		return;
	}
	
	public static void main(String[] args) {
		QueueMain queue = new QueueMain();
		System.out.println("initial queue size: "+queue.length());
		queue.offer(5);
		queue.offer(8);
		queue.offer(13);
		queue.offer(22);
		queue.offer(27);
		
		queue.length();
		queue.poll();
		queue.length();
		queue.poll();
		queue.length();
		
//		System.out.println(queue.length());
	}

}
