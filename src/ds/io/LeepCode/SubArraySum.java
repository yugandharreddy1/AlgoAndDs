package ds.io.LeepCode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
	public static void main(String[] args) {
		int[] nums=new int[]{1,3,6,4,2,3,1};
		int k=6;
		subarraySum(nums,k);
	}
	public static int subarraySum(int[] nums, int k) {   
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}
}
