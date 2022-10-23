package com.altuhin.datastructure.linked;

public class LinkedListMain {	
	Node root;
	
	public static void printLinkedList(LinkedListMain linkedList) {
		Node head = linkedList.root;
		System.out.println("===========Linked List print=========");
		while(head != null) {
			System.out.println(head.data +" ");
			head = head.nextNode;
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
		
	Node head = linkedList.root;
	
	if(head == null) {
		head = node;
		return;
	}
	Node last = head;
		while(last.nextNode != null) {
			last = last.nextNode;
		}
		
		last.nextNode = node;
		
	}
		
	
	
	public static void main(String[] args) {
		
		LinkedListMain studentLinkedList = new LinkedListMain();
		studentLinkedList.root = new Node(10);
		Node studentTwo = new Node(20);
		studentLinkedList.root.nextNode = studentTwo;
		Node studentThree = new Node(30);
		studentLinkedList.root.nextNode.nextNode = studentThree;
		Node studentFour = new Node(40);
		studentLinkedList.root.nextNode.nextNode.nextNode = studentFour;
		Node studentFive = new Node(50);
		studentLinkedList.root.nextNode.nextNode.nextNode.nextNode = studentFive;
		Node studentSix = new Node(60);
		studentLinkedList.root.nextNode.nextNode.nextNode.nextNode.nextNode = studentSix;
		Node studentSeven = new Node(70);
		studentSeven.nextNode = null;
		Node goodStudent = new Node(88);
		studentLinkedList.root.nextNode.nextNode
		.nextNode.nextNode.nextNode.nextNode = studentSeven;
		LinkedListMain.insert(studentLinkedList, goodStudent);
		LinkedListMain.printLinkedList(studentLinkedList);
	}
	
}
