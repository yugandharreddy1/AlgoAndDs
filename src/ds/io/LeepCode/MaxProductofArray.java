package ds.io.LeepCode;

public class MaxProductofArray {
	public static void main(String[] args) {
		int[] nums=new int[]{2,3,-2,4};
		maxProduct(nums);

	}
	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = A[0], min = A[0], result = A[0];
		
		//Loop through the array, each time remember the max and min value for the previous product,
		//the most important thing is to update the max and min value: we have to compare among max * A[i], min * A[i] as well as A[i], 
		//since this is product, a negative * negative could be positive.
		
		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;
	}
}
