package com.xc.demo.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class demo8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String s) {
        Set<String> set = new HashSet<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

        long result = 0;
        boolean flag = true;
        int startIndex = -1;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i) && startIndex == -1) {
                continue;
            } else if (startIndex == -1) {
                startIndex = i;
            }

            str = String.valueOf(s.charAt(i));
            if (startIndex == i && "-".equals(str)) {
                flag = false;
            } else if (startIndex == i && "+".equals(str)) {
                flag = true;
            } else if (set.contains(str)) {
                result = 10*result + Integer.parseInt(str);
                if (flag && result > Integer.MAX_VALUE) {
                	return Integer.MAX_VALUE;
                } else if (!flag && -result < Integer.MIN_VALUE) {
                	return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }

        return (int)(flag?result:-result);
    }
}
