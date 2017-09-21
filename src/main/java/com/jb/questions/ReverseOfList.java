package com.jb.questions;

import com.jb.model.Node;

public class ReverseOfList {
	
	//Time Complexity is O(n), Space Complexity is O(1)
	public Node reverse(Node head) {

		Node prev = null;
		Node current = head;
		Node next = null;

		while (current != null) {

			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
		return head;

	}

}
