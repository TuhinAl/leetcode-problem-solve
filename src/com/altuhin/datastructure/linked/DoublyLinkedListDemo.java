package com.altuhin.datastructure.linked;

public class DoublyLinkedListDemo {
	DNode head;
	// insert into head
	public  void insertAtHead(int data) {
		if(head != null) {
//			System.out.println("inside if");
			DNode newNode = new DNode(data);
			newNode.next = head; 
			newNode.prev = null; 
			head.prev = newNode;
		}else {
//			System.out.println("inside else");
			DNode newNode = new DNode(data);
			head = newNode;
		}
	}
	// insert given position
	public  void insertAfterGivenKey(DNode pre, int data) {
		System.out.println("prev data: "+pre.data);
		DNode root = head, prev = null;
		DNode newNode = new DNode(data);
		while (root != null) {
			prev = root;
			if(root.data == pre.data) {
				newNode.next = pre.next;
				pre.next = newNode;
				root = newNode.next;
				if(newNode.next != null) {
					newNode.next.prev = newNode;
				}
			}
			
			root = root.next;
		}
	
	}
	// insert from end 
	
	
		// delete from head
		// delete from given position
		// delete from end
	
	public void traverseDLL() {
		System.out.println("print linked list: ");
		DNode root = head;
		while (root != null) {
			System.out.println(root.data);
			root = root.next;
		}
	}
	
public static void main(String[] args) {
	DoublyLinkedListDemo dll = new DoublyLinkedListDemo();
	dll.insertAtHead(25);
	dll.insertAtHead(27);
	dll.insertAtHead(29);
	dll.insertAtHead(31);
	dll.traverseDLL();
	dll.insertAfterGivenKey(dll.head.next, 33);
	dll.traverseDLL();

}
}
