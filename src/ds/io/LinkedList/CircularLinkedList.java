package ds.io.LinkedList;

public class CircularLinkedList {



	static class Node 
	{ 
		int data; 
		Node next; 
	}; 

	
	
	  // Function to insert a node at the beginning 
    // of a Circular linked list 
    static Node push(Node head_ref, int data) 
    { 
        Node ptr1 = new Node(); 
        Node temp = head_ref; 
        ptr1.data = data; 
        ptr1.next = head_ref; 
  
        // If linked list is not null then 
        // set the next of last node 
        if (head_ref != null) { 
            while (temp.next != head_ref) 
                temp = temp.next; 
            temp.next = ptr1; 
            return head_ref; 
        } 
        else
// For the first node 
            ptr1.next = ptr1;  
  
        head_ref = ptr1; 
        return head_ref; 
    } 
    
    
    
    
    
    // Delete the node if it is odd 
    static Node deleteNode(Node head_ref, Node del) 
    { 
        Node temp = head_ref; 
        // If node to be deleted is head node 
  
        if (head_ref == del) 
            head_ref = del.next; 
  
        // Traverse list till not found 
        // delete node 
        while (temp.next != del) { 
            temp = temp.next; 
        } 
  
        // Copy address of node 
        temp.next = del.next; 
  
        return head_ref; 
    } 
  
    
    
    
    // Function to delete all odd nodes 
    // from the singly circular linked list 
    static Node deleteoddNodes(Node head) 
    { 
        Node ptr = head; 
  
        Node next; 
  
        // Traverse list till the end 
        // if the node is odd then delete it 
        do { 
            // If node is odd 
            if (ptr.data % 2 == 1) 
                deleteNode(head, ptr); 
  
            // point to next node 
            next = ptr.next; 
            ptr = next; 
        } while (ptr != head); 
        return head; 
    } 
  
    
    
    
    
    
	static Node addToEmpty(Node last, int data) 
	{ 
		// This function is only for empty list 
		if (last != null) 
		return last; 

		// Creating a node dynamically. 
		Node temp = new Node(); 

		// Assigning the data. 
		temp.data = data; 
		last = temp; 

		// Creating the link. 
		last.next = last; 

		return last; 
	} 

	static Node addBegin(Node last, int data) 
	{ 
		if (last == null) 
			return addToEmpty(last, data); 

		Node temp = new Node(); 

		temp.data = data; 
		temp.next = last.next; 
		last.next = temp; 

		return last; 
	} 

	static Node addEnd(Node last, int data) 
	{ 
		if (last == null) 
			return addToEmpty(last, data); 
		
		Node temp = new Node(); 

		temp.data = data; 
		temp.next = last.next; 
		last.next = temp; 
		last = temp; 

		return last; 
	} 

	static Node addAfter(Node last, int data, int item) 
	{ 
		if (last == null) 
			return null; 

		Node temp, p; 
		p = last.next; 
		do
		{ 
			if (p.data == item) 
			{ 
				temp = new Node(); 
				temp.data = data; 
				temp.next = p.next; 
				p.next = temp; 

				if (p == last) 
					last = temp; 
				return last; 
			} 
			p = p.next; 
		} while(p != last.next); 

		System.out.println(item + " not present in the list."); 
		return last; 

	} 

	static void traverse(Node last) 
	{ 
		Node p; 

		// If list is empty, return. 
		if (last == null) 
		{ 
			System.out.println("List is empty."); 
			return; 
		} 

		// Pointing to first Node of the list. 
		p = last.next; 

		// Traversing the list. 
		do
		{ 
			System.out.print(p.data + " "); 
			p = p.next; 

		} 
		while(p != last.next); 

	} 

	// Driven code 
	public static void main(String[] args) 
	{ 
		Node last = null; 

		last = addToEmpty(last, 6); 
		last = addBegin(last, 4); 
		last = addBegin(last, 2); 
		last = addEnd(last, 8); 
		last = addEnd(last, 12); 
		last = addAfter(last, 10, 8); 

		traverse(last); 
	} 
	} 

	/* This code contributed by PrinciRaj1992 */
