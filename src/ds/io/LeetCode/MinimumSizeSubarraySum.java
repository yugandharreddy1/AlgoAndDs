package ds.io.LeetCode;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int [] nums={2,3,1,2,4,3};
		int s=7;
		System.out.println(minSubArrayLen(s,nums));

	}
	public static int minSubArrayLen(int s, int[] nums) {
		int result=Integer.MAX_VALUE;
		int left=0;
		int curr_sum=0;
		for(int right=0;right<nums.length;right++){
			curr_sum=curr_sum+nums[right];
			while(curr_sum>=s){
				result=Math.min(result,right+1-left);
				curr_sum=curr_sum-nums[left];
				left++;
			}
		}
		return (result!=Integer.MAX_VALUE)?result:0; 
	}
}
