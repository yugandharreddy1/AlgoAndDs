package ds.io.LeetCode;

public class ProductExceptSelf {
	public static void main(String[] args) {
		int[] nums=new int[]{1,2,3,4};
		productExceptSelf(nums);
	}
	public static int[] productExceptSelf(int[] nums) {
		int[] result=new int[nums.length];

		for(int i=0;i<nums.length;i++){
			result=prod(nums,result,i);
		}

		return result;
	}

	public static int[] prod(int[] nums,int[] result,int k){
		int prod=1;
		for(int i=0;i<nums.length;i++){
			if(i!=k)
				prod=prod*nums[i];
		}
		result[k]=prod;

		return result;
	}
}
