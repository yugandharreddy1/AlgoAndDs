package ds.io.LeetCode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode head=new ListNode();
		isPalindrome(head);
	}
	public static boolean isPalindrome(ListNode head) {
		StringBuffer sb=new StringBuffer();
		if(head==null){
			return true;
		}

		while(head!=null){
			sb.append(head.val+":");
			head=head.next;
		}

		String[] st=sb.toString().split(":");
		return isP(st);

	}

	public static boolean isP(String[] arr){

		int flag = 0; 
		int n=arr.length;
		for (int i = 0; i <= n / 2 && n != 0; i++) { 
			if (!arr[i].equalsIgnoreCase(arr[n - i - 1])) { 
				flag = 1; 
				break; 
			} 
		} 
		if (flag == 1) 
			return false; 
		else
			return true; 
	}
}
