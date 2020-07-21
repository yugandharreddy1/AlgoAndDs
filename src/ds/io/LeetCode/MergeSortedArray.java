package ds.io.LeetCode;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] i=new int[]{1,2,3,0,0,0};
		int[] j=new int[]{2,5,6};
		int  m = 3,n=3;
		merge(i,m,j,n);
	}
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

		for(int i=0;i<n;i++){
			nums1[m+i]=nums2[i];
		}
		Arrays.sort(nums1);
		
		return nums1;
	}
}
