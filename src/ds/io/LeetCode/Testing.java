package ds.io.LeetCode;

import java.io.IOException;

public class Testing {
	public static void main(String[] args) throws IOException {
		maxArea(new int[]{1,0,1,1,0,1});

	}
	public static int maxArea(int[] nums) {
		int count=0;
		int maxCount=0;
		for(int i:nums){
			if(i==1){
				count++;
				if(count>=maxCount){
					maxCount=count;
				}
			}else{
				count=0;
			}
		}
		return count; }
}
