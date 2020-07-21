package ds.io.LeetCode;

public class RemoveAllDuplicatesSortedList {

	public static void main(String[] args) {
		ListNode head = new ListNode();
		deleteDuplicates(head);
	}
	public static ListNode deleteDuplicates(ListNode head) {
	  
	        
        if(head==null||head.next==null) return head;
        
        if(head.val!=head.next.val){
            head.next=deleteDuplicates(head.next);
            return head;
        }
        else{
            while(head.next!=null&&head.val==head.next.val)
                head=head.next;
            
            return   deleteDuplicates(head.next);
        }}


}
