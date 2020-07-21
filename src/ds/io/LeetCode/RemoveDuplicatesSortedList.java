package ds.io.LeetCode;

public class RemoveDuplicatesSortedList {
	public static void main(String[] args) {
		ListNode head = new ListNode();
		deleteDuplicates(head);
	}
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode cur=head;
		while (cur!=null){
			while (cur.next!=null && cur.val==cur.next.val){
				cur.next=cur.next.next;
			}       
			cur=cur.next;
		}
		return head;
	}
}
