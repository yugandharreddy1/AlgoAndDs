package ds.io.LeepCode;

public class TwoSum {

	public static void main(String[] args) {
		int nums[] =  {3,2,4};
		int target = 6;
		System.out.println(twoSum(nums,target));
	}
	
	 public static int[] twoSum(int[] nums, int target) {
		 
		 int temp[]=nums;
		 int i;
		 int j;
		 for(i=0;i<nums.length;i++) {
			 for(j=1;j<temp.length;j++) {
				 if(nums[i]==temp[j]) {
					 break; 
				 }
				 if((nums[i]+temp[j])==target) {
					 System.out.println(i+""+j);
					 return new int[] {i,j};
				 }
			 } 
		 }
		return temp;
		 
	        
	    }
}
