package ds.io.LeepCode;

import java.util.Stack;

public class ReverseLinkedList {
public static void main(String[] args) {
	 ListNode l=new ListNode();
	 l.val=1;
	 l.next.val=2;
	
	 
}
public ListNode reverseList(ListNode head) {
	
	//InPlace solution
    // base case
   /* if(head == null || head.next == null) return head;
    
    ListNode newHead = reverseList(head.next);
    
    head.next.next = head;
    head.next = null;

    return newHead;*/
	

    if(head == null) {
        return null;
    }
    Stack<ListNode> nodes = new Stack<>();
    ListNode toAdd = head;
    while(toAdd != null) {
        nodes.push(toAdd);
        toAdd = toAdd.next;
    }
    head = nodes.pop();
    ListNode next = head;
    while(!nodes.isEmpty()) {
        ListNode p = nodes.pop();
        next.next = p;
        next = p;
    }
    next.next = null;
    return head;

}
}
