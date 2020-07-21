package ds.io.LeetCode;

import java.util.Arrays;

public class FindKthLargestinArray {
	public static void main(String[] args) {
		int[] nums=new int[]{3,2,3,1,2,4,5,5,6};
		int k=2;
		findKthLargest(nums,k);
	}
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);

		return nums[nums.length-k];
	}
}
