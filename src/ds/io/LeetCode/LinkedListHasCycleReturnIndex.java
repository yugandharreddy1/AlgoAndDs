package ds.io.LeetCode;

public class LinkedListHasCycleReturnIndex {
	public static void main(String[] args) {
		ListNode head = new ListNode();
		hasCycle(head);
	}
	public static ListNode hasCycle(ListNode head) {


		//Use two pointers, walker and runner.
		//walker moves step by step. runner moves two steps at time.
		//if the Linked List has a cycle walker and runner will meet at some point.
		if(head==null) return null;
		ListNode walker = head;
		ListNode runner = head;
		while(runner.next!=null && runner.next.next!=null) {
			walker = walker.next;
			runner = runner.next.next;
			if(walker==runner){

				ListNode walker2 = head; 
				while (walker2 != walker){
					walker = walker.next;
					walker2 = walker2.next;
				}
				return walker;
			}
		}
		return null;

	}
}
