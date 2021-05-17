package com.xc.demo.leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 */
public class demo7 {
    public static void main(String[] args) {
        System.out.println(reverse(12));
    }

    public static int reverse(int x) {
        int result = 0;
        while (x!=0) {
            if (result > Integer.MAX_VALUE/10 || result<Integer.MIN_VALUE/10) {
                return 0;
            }
            result = 10*result + x%10;
            x = x/10;
        }
        return result;
    }
}
