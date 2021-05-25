package com.xc.demo.leetcode.dynamicprogramming;

/**
 * @author changxu13
 * @date 2021/5/25 15:37
 */
public class Demo_64 {

	public static void main(String[] args) {
		int[][] grid = {{1,2,3}, {4,5,6}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m+1][n+1];
		dp[1][1] = grid[0][0];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= n; i++) {
			dp[0][i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != 1 || j != 1) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
				}
			}
		}

		return dp[m][n];
	}
}
