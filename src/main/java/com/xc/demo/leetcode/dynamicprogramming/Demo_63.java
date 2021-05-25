package com.xc.demo.leetcode.dynamicprogramming;

/**
 * @author changxu13
 * @date 2021/5/25 15:25
 */
public class Demo_63 {

	public static void main(String[] args) {
		int[][] obstacleGrid = {{1}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n =obstacleGrid[0].length;
		int[][] dp = new int[m+1][n+1];

		dp[1][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != 1 || j != 1) {
					if (obstacleGrid[i-1][j-1] == 1) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
		}
		return dp[m][n];
	}
}
