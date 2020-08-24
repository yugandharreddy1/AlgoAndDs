package ds.io.LeetCode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums={10,9,2,5,3,7,101,18};
		lengthOfLIS(nums);

	}
	public static int lengthOfLIS(int[] nums) {
		if(nums.length<=1){
			return nums.length;
		}

		int[] dp=new int[nums.length];
		int max=-1;

		Arrays.fill(dp,1);

		for(int i=1;i<nums.length;i++){
			for(int j=0;j<i;j++){
				if(nums[j]<nums[i]){
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
			max=Math.max(max,dp[i]);
		}
		return max;
	}
}
