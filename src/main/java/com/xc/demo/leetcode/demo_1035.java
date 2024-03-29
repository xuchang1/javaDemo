package com.xc.demo.leetcode;

/**
 * @author changxu13
 * @date 2021/5/21 12:54
 */
public class demo_1035 {
	public static void main(String[] args) {
		int[] nums1 = {1,3,7,1,7,5};
		int[] nums2 = {1,9,2,5,1};
		System.out.println(maxUncrossedLines(nums1, nums2));
	}

	public static int maxUncrossedLines(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[m][n];
	}
}
