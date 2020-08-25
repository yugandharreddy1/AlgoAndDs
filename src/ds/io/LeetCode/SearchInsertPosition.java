package ds.io.LeetCode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums={1,3,5,6};
		int target=5;

		searchInsert(nums,target);
	}
	public static int searchInsert(int[] nums, int target) {

		int mid,low = 0;
		int high = nums.length-1;

		while(low <= high){
			mid = low + (high-low)/2;

			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] > target){
				high= mid -1;               //decrease high
			}else{
				low = mid+1;                //increase low
			}
		}

		return low;
	}
}
