package ds.io.LeetCode;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		int[] nums={7,1,5,3,6,4};

		System.out.println(maxProfit(nums));

	}
    
	public static int maxProfit(int[] prices) {
        
        /*
            profit: maximum total profit.
            buy: the day when buy stock.
            sell: the day when sell stock.
            days: maximum trade days.
        */
        int profit = 0, buy = 0, sell = 0, days = prices.length;
        
        while(buy < days && sell < days)
        {
            while(buy < days - 1 && prices[buy + 1] < prices[buy])
                buy++; // find the valley of prices               
            
            sell = buy;
            
            while(sell < days - 1 && prices[sell + 1] > prices[sell])
                sell++; // find the peak of prices
            
            profit += prices[sell] - prices[buy];
                
            buy = sell + 1;
        }
        
        return profit;
    }
}
