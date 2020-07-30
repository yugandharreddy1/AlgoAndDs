package ds.io.LeetCode;

public class SortedArrayToBST {
	public static void main(String[] args) {
		int[] num=new int[]{-10,-3,0,5,9};

		sortedArrayToBST(num);
	}

	private static TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
		TreeNode head = helper(num, 0, num.length - 1);
		return head;
	}

	private static TreeNode helper(int[] num, int low, int high) {
		if(low>high){//Done
			return null;
		}

		int mid=low + (high-low)/2; // avoids integer overflow
		TreeNode head=new TreeNode(num[mid]);
		head.left=helper(num, low, mid-1);
		head.right=helper(num,mid+1,high);



		return head;
	}
}
