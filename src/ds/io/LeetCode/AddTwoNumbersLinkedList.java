package ds.io.LeetCode;

import java.util.Collections;
import java.util.Stack;

public class AddTwoNumbersLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode();
		addTwoNumbers(head,head);
	}
	  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(-1);
	        ListNode cur = dummy;
	        
	        ListNode cur1 = l1;
	        ListNode cur2 = l2;
	        int carry = 0;
	        while(cur1 != null || cur2 != null || carry != 0){
	            int num1 = cur1 == null ? 0 : cur1.val;
	            int num2 = cur2 == null ? 0 : cur2.val;
	            
	            int sum = num1 + num2 + carry;            
	            int newNum = sum % 10;
	            carry = sum / 10;
	            cur.next = new ListNode(newNum);
	            cur = cur.next;
	            
	            cur1 = cur1 == null ? null: cur1.next;
	            cur2 = cur2 == null ? null: cur2.next;
	        }
	        
	        return dummy.next;}

}
