package ds.io.Queue;

//Java program to demonstrate ConcurrentLinkedQueue 

import java.util.concurrent.*; 

class ConcurrentLinkedQueueDemo { 
	public static void main(String[] args) 
	{ 
		// Create a ConcurrentLinkedQueue 
		// using ConcurrentLinkedQueue() contructor 
		ConcurrentLinkedQueue<Integer> 
			clq = new ConcurrentLinkedQueue<Integer>(); 

		clq.add(12); 
		clq.add(70); 
		clq.add(1009); 
		clq.add(475); 

		// Displaying the existing LinkedQueue 
		System.out.println("ConcurrentLinkedQueue: "
						+ clq); 

		
		   // Displaying the first element 
        // using peek() method 
        System.out.println("First Element is: "
                           + clq.peek()); 
  
        // Remove and display the first element 
        // using poll() method 
        System.out.println("Head Element is: "
                           + clq.poll()); 
  
        // Displaying the existing LinkedQueue 
        System.out.println("ConcurrentLinkedQueue: "
                           + clq); 
  
        // Get the size using size() method 
        System.out.println("Size: "
                           + clq.size()); 
        
        
		// Create a ConcurrentLinkedQueue 
		// using ConcurrentLinkedQueue(Collection c) contructor 
		ConcurrentLinkedQueue<Integer> 
			clq1 = new ConcurrentLinkedQueue<Integer>(clq); 

		// Displaying the existing LinkedQueue 
		System.out.println("ConcurrentLinkedQueue1: "
						+ clq1); 
	} 
} 

