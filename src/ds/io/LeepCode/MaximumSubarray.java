package ds.io.LeepCode;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] i=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(i));
	}

    public static int maxSubArray(int[] nums) {
        
//        2 loops solution
//		int sum=0;
//		for(int i=0;i<nums.length;i++){
//			for(int j=i;j<nums.length;j++){
//				sum=Math.max(sum, getSum(nums,i,j));
//			}
//		}
	
//		return sum;

//	}
//	private static int getSum(int[] s, int k, int l) {
//		int sum=0;
//		for(int i=k;i<=l;i++){
//			sum=sum+s[i];
//		}
//		return sum;
		
            
        int maxSum=nums[0];
        int currSum=maxSum;
        
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(nums[i]+currSum,nums[i]);
            maxSum=Math.max(maxSum,currSum);
        }
            
       return maxSum;     
	}
}
