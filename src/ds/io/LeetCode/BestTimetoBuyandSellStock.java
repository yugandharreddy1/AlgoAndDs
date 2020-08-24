package ds.io.LeetCode;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		int[] nums={7,1,5,3,6,4};

		System.out.println(maxProfit(nums));
	}
	public static int maxProfit(int[] prices) {
		int min=Integer.MAX_VALUE,max=0;
		for(int price: prices){
			min=Math.min(min,price);
			max=Math.max(max, price-min);
		}
		return max;

	}
}
