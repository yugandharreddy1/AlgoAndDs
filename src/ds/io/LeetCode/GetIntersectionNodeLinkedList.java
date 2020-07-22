package ds.io.LeetCode;

public class GetIntersectionNodeLinkedList {


	public static void main(String[] args) {
		ListNode head = new ListNode();
		getIntersectionNode(head,head);
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		//boundary check
		if(headA == null || headB == null) return null;

		ListNode a = headA;
		ListNode b = headB;

		//if a & b have different len, then we will stop the loop after second iteration
		while( a != b){
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			a = a == null? headB : a.next;
			b = b == null? headA : b.next;    
		}

		return a;
	}


}
