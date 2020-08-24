package ds.io.LeetCode;

public class UniquePathsWithObstacles {

	public static void main(String[] args) {
		int[][] nums={
				{0,0,0},
				{0,1,0},
				{0,0,0}
		};
		System.out.println(uniquePathsWithObstacles(nums));
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}
}
