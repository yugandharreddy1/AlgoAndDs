package ds.io.LeetCode;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		int nums[] = new int[] {2,5,5,11};
		int target = 10;
		StringBuffer sb=new StringBuffer();
		char[] ch=new char[]{};
		sb.toString().contains(String.valueOf(ch[0]));
		System.out.println(twoSum(nums,target));
	}
	
	 public static int[] twoSum(int[] nums, int target) {
		 
		int[] temp=nums;
		 //O(n2) Solution
		 for(int i=0;i<nums.length;i++) {
			 for(int j=1;j<temp.length;j++) {
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
