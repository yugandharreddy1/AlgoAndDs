package ds.io.LeetCode;

public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		int [] nums={3,4,5,1,2};
		findMin(nums);
	}
	public static int findMin(int[] nums) {
		if(nums == null || nums.length == 0){
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while(left < right - 1){   //leave the loop when only two elements left.
			int mid = left + (right - left)/2;
			if(nums[mid] > nums[right]){
				left = mid;  //I decide not to skip mid, 
			}else{
				right = mid;   
			}
		}
		return Math.min(nums[left], nums[right]);  //things will be easy when only two elements left
	}
}
