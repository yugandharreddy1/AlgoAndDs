package ds.io.LinkedList;


public class LinkedList {
	     Node head;
	  
	    /* Linked list Node.  This inner class is made static so that 
	       main() can access it */
	    static class Node { 
	        int data; 
	        Node next; 
	        Node(int d) 
	        { 
	            data = d; 
	            next = null; 
	        } // Constructor 
	    } 
	  
	    
	    
	    
	    
	    /* method to create a simple linked list with 3 nodes*/
	    public static void main(String[] args) 
	    { 
	        /* Start with the empty list. */
	        LinkedList llist = new LinkedList(); 
	  
	        llist.head = new Node(1); 
	        Node second = new Node(2); 
	        Node third = new Node(3); 
	  
	        /* Three nodes have been allocated dynamically. 
	          We have references to these three blocks as head,   
	          second and third 
	  
	          llist.head        second              third 
	             |                |                  | 
	             |                |                  | 
	         +----+------+     +----+------+     +----+------+ 
	         | 1  | null |     | 2  | null |     |  3 | null | 
	         +----+------+     +----+------+     +----+------+ */
	  
	        llist.head.next = second; // Link first node with the second node 
	  
	        /*  Now next of the first Node refers to the second.  So they 
	            both are linked. 
	  
	         llist.head        second              third 
	            |                |                  | 
	            |                |                  | 
	        +----+------+     +----+------+     +----+------+ 
	        | 1  |  o-------->| 2  | null |     |  3 | null | 
	        +----+------+     +----+------+     +----+------+ */
	  
	        second.next = third; // Link second node with the third node 
	  
	        /*  Now next of the second Node refers to third.  So all three 
	            nodes are linked. 
	  
	         llist.head        second              third 
	            |                |                  | 
	            |                |                  | 
	        +----+------+     +----+------+     +----+------+ 
	        | 1  |  o-------->| 2  |  o-------->|  3 | null | 
	        +----+------+     +----+------+     +----+------+ */
	        
	        llist.printList(); 
	        llist.push(4);
	        llist.printList(); 
	        
	        
	        
	        llist.insertAfter(second, 5);
            llist.printList(); 
            
            
	        llist.append(6);
	        llist.printList(); 
	        
	        
	        llist.deleteNodeByKey(6);
	        llist.printList(); 

	        llist.deleteNodeByPosition(1);
	        llist.printList(); 
	        
	        
	       System.out.println(llist.getCount());
	       
	       System.out.println(llist.search(llist.head, 5));
	       
	       llist.reverse(llist.head);
	       llist.printList(); 
	        
	        llist.deleteList();
	        llist.printList(); 
	        

	    } 
	    
	    
	    /* Function deletes the entire linked list */
	    void deleteList() 
	    { 
	        head = null; 
	    } 
	    
	    
	    
	    
	    

	    /* Function to reverse the linked list */
	    Node reverse(Node node) 
	    { 
	        Node prev = null; 
	        Node current = node; 
	        Node next = null; 
	        while (current != null) { 
	            next = current.next; 
	            current.next = prev; 
	            prev = current; 
	            current = next; 
	        } 
	        node = prev; 
	        return node; 
	    } 
	    
	    
	    
	    
	    
	    //Checks whether the value x is present in linked list 
	    public boolean search(Node head, int x) 
	    { 
	        Node current = head;    //Initialize current 
	        while (current != null) 
	        { 
	            if (current.data == x) 
	                return true;    //data found 
	            current = current.next; 
	        } 
	        return false;    //data not found 
	    } 
	    
	    
	    
	    
	    
	    /* Returns count of nodes in linked list */
	    public int getCount() 
	    { 
	        Node temp = head; 
	        int count = 0; 
	        while (temp != null) 
	        { 
	            count++; 
	            temp = temp.next; 
	        } 
	        return count; 
	    } 
	    
	    
	    
	    
	    
	    
	    /* Given a key, deletes the first occurrence of key in linked list */
	    void deleteNodeByKey(int key) 
	    { 
	        // Store head node 
	        Node temp = head, prev = null; 
	  
	        // If head node itself holds the key to be deleted 
	        if (temp != null && temp.data == key) 
	        { 
	            head = temp.next; // Changed head 
	            return; 
	        } 
	  
	        // Search for the key to be deleted, keep track of the 
	        // previous node as we need to change temp.next 
	        while (temp != null && temp.data != key) 
	        { 
	            prev = temp; 
	            temp = temp.next; 
	        }     
	  
	        // If key was not present in linked list 
	        if (temp == null) return; 
	  
	        // Unlink the node from linked list 
	        prev.next = temp.next; 
	    } 
	    
	    
	    
	    
	    
	    /* Given a reference (pointer to pointer) to the head of a list 
	       and a position, deletes the node at the given position */
	    void deleteNodeByPosition(int position) 
	    { 
	        // If linked list is empty 
	        if (head == null) 
	            return; 
	  
	        // Store head node 
	        Node temp = head; 
	  
	        // If head needs to be removed 
	        if (position == 0) 
	        { 
	            head = temp.next;   // Change head 
	            return; 
	        } 
	  
	        // Find previous node of the node to be deleted 
	        for (int i=0; temp!=null && i<position-1; i++) 
	            temp = temp.next; 
	  
	        // If position is more than number of ndoes 
	        if (temp == null || temp.next == null) 
	            return; 
	  
	        // Node temp->next is the node to be deleted 
	        // Store pointer to the next of node to be deleted 
	        Node next = temp.next.next; 
	  
	        temp.next = next;  // Unlink the deleted node from list 
	    } 
	    
	    
	    
	    
	    
	    
	    /* This function is in LinkedList class. Inserts a 
	    new Node at front of the list. This method is  
	    defined inside LinkedList class shown above */
	 public void push(int new_data) 
	 { 
	     /* 1 & 2: Allocate the Node & 
	               Put in the data*/
	     Node new_node = new Node(new_data); 
	   
	     /* 3. Make next of new Node as head */
	     new_node.next = head; 
	   
	     /* 4. Move the head to point to new Node */
	     head = new_node; 

	 } 
	 
	 
	 
	 
	 
	 /* This function is in LinkedList class. 
	   Inserts a new node after the given prev_node. This method is  
	   defined inside LinkedList class shown above */
	public void insertAfter(Node prev_node, int new_data) 
	{ 
	    /* 1. Check if the given Node is null */
	    if (prev_node == null) 
	    { 
	        System.out.println("The given previous node cannot be null"); 
	        return; 
	    } 
	  
	    /* 2. Allocate the Node & 
	       3. Put in the data*/
	    Node new_node = new Node(new_data); 
	  
	    /* 4. Make next of new Node as next of prev_node */
	    new_node.next = prev_node.next; 
	  
	    /* 5. make next of prev_node as new_node */
	    prev_node.next = new_node; 
	} 
	
	
	 
	
	/* Appends a new node at the end.  This method is  
	   defined inside LinkedList class shown above */
	public void append(int new_data) 
	{ 
	    /* 1. Allocate the Node & 
	       2. Put in the data 
	       3. Set next as null */
	    Node new_node = new Node(new_data); 
	  
	    /* 4. If the Linked List is empty, then make the 
	           new node as head */
	    if (head == null) 
	    { 
	        head = new Node(new_data); 
	        return; 
	    } 
	  
	    /* 4. This new node is going to be the last node, so 
	         make next of it as null */
	    new_node.next = null; 
	  
	    /* 5. Else traverse till the last node */
	    Node last = head;  
	    while (last.next != null) 
	        last = last.next; 
	  
	    /* 6. Change the next of last node */
	    last.next = new_node; 
	    return; 
	} 
	 
	 
	    /* This function prints contents of linked list starting from head */
	    public void printList() 
	    { 
	        Node n = head; 
	        while (n != null) { 
	            System.out.print(n.data + " "); 
	            n = n.next; 
	        } 
	        System.out.println("");
	    } 
	    
	    
	    
	    
	    
	    

}
