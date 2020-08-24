package ds.io.LeetCode;

public class PaintFence {

	public static void main(String[] args) {
		numWays(3,2);

	}
	public static int numWays(int n, int k) {
	    int dp[] = {0, k , k*k, 0};
	 
	    if(n <= 2)
	        return dp[n];
	 
	    for(int i = 2; i < n; i++){
	        dp[3] = (k - 1) * (dp[1] + dp[2]);
	        dp[1] = dp[2];
	        dp[2] = dp[3];
	    }
	 
	    return dp[3];
	}

}
