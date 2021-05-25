package com.xc.demo.leetcode.dynamicprogramming;

/**
 * @author changxu13
 * @date 2021/5/25 20:27
 */
public class Demo_96 {

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}

	public static int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = dp[j-1]*dp[i-j] + dp[i];
			}
		}
		return dp[n];
	}
}
