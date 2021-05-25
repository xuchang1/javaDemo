package com.xc.demo.leetcode.dynamicprogramming;

import java.util.List;

public class Demo_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size+1][size+1];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[1][1] = triangle.get(0).get(0);

        for (int i = 2; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i-1).get(j-1);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= size; i++) {
            result = Math.min(result, dp[size][i]);
        }
        return result;
    }
}
