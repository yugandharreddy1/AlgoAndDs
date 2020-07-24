package ds.io.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowProb {

	public static void main(String[] args) {
		//System.out.println(smallestSubArraySum(new int[]{4,2,2,7,8,1,2,8,1,0},8));
		//System.out.println(findMaxSumSubArray(new int[]{4,2,1,7,8,1,2,8,1,0},3));
		System.out.println(longestSubStringwithKDistinctChar(new char[]{'A','A','A','H','H','I','B','C'},2));
	}

	public static int findMaxSumSubArray(int[] arr,int k){
		int maxValue=Integer.MIN_VALUE;
		int currSum=0;
		for(int i=0;i<arr.length;i++){
			currSum=currSum+arr[i];
			if(i>=k-1){
				maxValue=Math.max(currSum,maxValue);
				currSum=currSum-arr[i-(k-1)];
			}
		}

		return maxValue;
	}

	public static int smallestSubArraySum(int[] arr,int smallSum){
		int subArrSize=Integer.MAX_VALUE;
		int currSum=0;
		int start=0;
		for(int end=0;end<arr.length;end++){
			currSum=currSum+arr[end];
			while(currSum>=smallSum){
				subArrSize=Math.min(subArrSize,end-start+1);
				currSum=currSum-arr[start]; //shriking process
				start++;                     //add process
			}
		}

		return subArrSize;
	}

	public static int longestSubStringwithKDistinctChar(char[] ch,int k){
		int result=0;
		Map<Character,Integer> map=new HashMap<>();
		int start=0;
		for(int end=0;end<ch.length;end++){
			map.put(ch[end],map.getOrDefault(ch[end],0)+1);
			//shrink the sliding window,untill we are left with 'k' distint char in the map
			while(map.size()>k){
				map.put(ch[start],map.get(ch[start])-1);
				if(map.get(ch[start])==0){
					map.remove(ch[start]);
				}
				start++;
			}
			result=Math.max(result,end-start+1);
		}
		return result;
	}
}
