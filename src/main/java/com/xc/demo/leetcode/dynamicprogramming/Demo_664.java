package com.xc.demo.leetcode.dynamicprogramming;

/**
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 * 示例 1：
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 *
 * 示例 2：
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 */
public class Demo_664 {
    public static void main(String[] args) {
        System.out.println(strangePrinter("aba"));
    }

    /**
     * 动态规划：
     *  dp[i][j] = dp[i][j-1] (s[i] == s[j])
     *  dp[i][j] = min(dp[i][i+k] + dp[i+k+1][j]) (s[i] != s[j] &&  0<=k<=j-i-1)
     */
    public static int strangePrinter(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j + i< length; j++) {
                if (s.charAt(j) == s.charAt(j+i)) {
                    dp[j][j+i] = dp[j][j+i-1];
                } else {
                    int min = i + 1;
                    for (int k = 0; k < i; k++) {
                        min = Math.min(min, dp[j][j+k]+dp[j+k+1][j+i]);
                    }
                    dp[j][j+i] = min;
                }
            }
        }
        return dp[0][length-1];
    }

}
