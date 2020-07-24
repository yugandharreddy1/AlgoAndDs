package ds.io.LeetCode;

public class RemoveNthfromLinkedList {
	public static void main(String[] args) {
		//two pointer Templeat 

		// Initialize slow & fast pointers
		//	ListNode slow = head;
		//	ListNode fast = head;
		//	/**
		//	 * Change this condition to fit specific problem.
		//	 * Attention: remember to avoid null-pointer error
		//	 **/
		//	while (slow != null && fast != null && fast.next != null) {
		//	    slow = slow.next;           // move slow pointer one step each time
		//	    fast = fast.next.next;      // move fast pointer two steps each time
		//	    if (slow == fast) {         // change this condition to fit specific problem
		//	        return true;
		//	    }
		//	}
		//	return false;   // change return value to fit specific problem

	}


	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start=new ListNode(0),slow=start,fast=start;
		start.next=head;
		for(int i=0;i<n;i++){
			fast=fast.next;
		} 

		while(fast.next!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		//The basic idea is the fast pointer is n nodes ahead of slow pointer. So when fast.next is null, slow is in the right position that its next node can be removed by statement slow.next = slow.next.next;.
		slow.next=slow.next.next;
		return start.next;
	}
}