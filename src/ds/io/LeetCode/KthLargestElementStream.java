package ds.io.LeetCode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargestElementStream {
	  static PriorityQueue<Integer> queue;
      static int v;

	public static void main(String[] args) {
		int[] arr=new int[]{4,5,8,2};
		KthLargest(3,arr);
	}

	

     public static void KthLargest(int k, int[] a) {
         v = k;
         queue = new PriorityQueue<>(k);
         for (int n : a)
             add(n);
     }

     public static int add(int n) {
         if (queue.size() < v)
        	 queue.offer(n);
         else if (queue.peek() < n) {
        	 queue.poll();
        	 queue.offer(n);
         }
         return queue.peek();
     }
}
