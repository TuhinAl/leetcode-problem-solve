package com.altuhin.datastructure.linked;

public class LinkedListMain {	
	Node head;
	
	public static void printLinkedList(LinkedListMain linkedList) {
		Node head = linkedList.head;
		System.out.println("===========Linked List print=========");
		while(head != null) {
			System.out.println(head.data +" ");
			head = head.next;
		}
	}
	
	/**
	 *  For insert into a linkedList
	 * @param node
	 * here remember 2 CASE
	 * CASE-1: Does this Node is the first Node of this LinkedList? 
	 * if so root = null, if not
	 * 
	 * CASE-2: traverse through the LL and find the last node, and the append the new node
	 * 
	 */
	
	public static void insert(LinkedListMain linkedList, Node node) {
		
	Node head = linkedList.head;
	
	if(head == null) {
		head = node;
		return;
	}
	Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = node;
		
	}
		
	
	public  void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head; 
		head = newNode;
	}
	
	public  void insertAfterGivenNode(Node previousNode, int data) {
		if (previousNode == null) {
			System.out.println("Previous Node cannot be null.");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = previousNode.next;
		previousNode.next = newNode;	
	}
	
	// delete from head

	public  void deleteFromHead() {
		Node temp = head;
		head = temp.next;
	}
	
	// delete given key
	public  void deleteByGivenKey(int key) {
		Node temp = head, prev = null;
		if(temp == null && temp.data == key) {
			head = temp.next;
		}
		
		while(temp != null && temp.data != key) {
			prev =temp;
			temp = temp.next;
		}
		if(temp == null) {
			System.out.println("This key wasn't present in the linked List");
			return;
		}
		
		prev.next = temp.next;
	}
	// delete last node
	// find length
	public  int length() {
		Node temp = head;
		int count = 0;
		
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}	
	
	//check loop cycle
	/**
	 * Floyd's Cycle detection algorithms - Hare and Tortoise 
	 * define the linked list into 3 paths - 
	 * 			x = path before the cycle,
	 * 			y = path before the meeting point
	 * 			z = path start the meeting point
	 *  
	 *f stand for fast(hare)
	 *s stand for slow (tortoise)
	 *
	 * f = x + c1L + y	[ L = y + z ]
	 * s = x + c2L + y
	 * 
	 * from the law, 2s = f
	 * 				 2(x + c2L + y) = x + c1L + y
	 * 				 2x + 2c2L + 2y = x + c1L + y
	 * 				 2x + 2y - x - y = c1L - 2c2L
	 * 				 		x + y = (c1 - 2c2)L 
	 * 
	 */
	public boolean haveCycle() {
		Node head = this.head;
		/**
		 * traverse trough two pointers, first one traverse 2 step 
		 * and second traverse one step, if first == second 
		 * then the linkedList has a loop cycle
		 */
		Node first = head.next;
		Node second = head;
		while(first != null && first.next != null) {
			if(first == second) {
				return true;
			}
			first = first.next.next;
			second = second.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		LinkedListMain studentLinkedList = new LinkedListMain();
		studentLinkedList.head = new Node(10);
		Node studentTwo = new Node(20);
		studentLinkedList.head.next = studentTwo;
		Node studentThree = new Node(30);
		studentLinkedList.head.next.next = studentThree;
		Node studentFour = new Node(40);
		studentLinkedList.head.next.next.next = studentFour;
		Node studentFive = new Node(50);
		studentLinkedList.head.next.next.next.next = studentFive;
		Node studentSix = new Node(60);
		studentLinkedList.head.next.next.next.next.next = studentSix;
		Node studentSeven = new Node(70);
		studentSeven.next = null;
		Node goodStudent = new Node(88);
		studentLinkedList.head.next.next
		.next.next.next.next = studentSeven;
		LinkedListMain.insert(studentLinkedList, goodStudent);
//		LinkedListMain.printLinkedList(studentLinkedList);
		studentLinkedList.insertAtHead(122);
//		LinkedListMain.printLinkedList(studentLinkedList);
		studentLinkedList.insertAfterGivenNode(studentLinkedList.head.next.next, 777);
//		LinkedListMain.printLinkedList(studentLinkedList);
		studentLinkedList.deleteFromHead();
		System.out.println("after deleted head: ");
		LinkedListMain.printLinkedList(studentLinkedList);
		System.out.println("after deleted key 50: ");
		studentLinkedList.deleteByGivenKey(50);
		LinkedListMain.printLinkedList(studentLinkedList);

		System.out.println("after deleted key 88: ");
		studentLinkedList.deleteByGivenKey(88);
		LinkedListMain.printLinkedList(studentLinkedList);
		//invalid key
		System.out.println("after deleted key 33: ");
		studentLinkedList.deleteByGivenKey(33);
		LinkedListMain.printLinkedList(studentLinkedList);
		System.out.println(studentLinkedList.length());
		System.out.println(studentLinkedList.haveCycle());
	}
	
}
