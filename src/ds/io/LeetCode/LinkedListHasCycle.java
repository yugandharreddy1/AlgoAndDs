package ds.io.LeetCode;

public class LinkedListHasCycle {
	public static void main(String[] args) {
		ListNode head = new ListNode();
		hasCycle(head);
	}
	public static boolean hasCycle(ListNode head) {

		
		//Use two pointers, walker and runner.
		//walker moves step by step. runner moves two steps at time.
		//if the Linked List has a cycle walker and runner will meet at some point.
		if(head==null) return false;
		ListNode walker = head;
		ListNode runner = head;
		while(runner.next!=null && runner.next.next!=null) {
			walker = walker.next;
			runner = runner.next.next;
			if(walker==runner) return true;
		}
		return false;

	}
}
