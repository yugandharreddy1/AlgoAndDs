package ds.io.LeetCode;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(6,4));
	}
	public static int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == 1|| n ==1) return 1;
        int [] dp = new int[n];
        Arrays.fill(dp,1);//The only place I change
        for(int i = 1;i<m;i++){//loop m-1 times
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }
}
