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

        int result = 0;
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
                if (result > Integer.MAX_VALUE/10 && flag) {
                    return Integer.MIN_VALUE;
                } else if (result > Integer.MAX_VALUE/10 && !flag){
                    return Integer.MIN_VALUE;
                }
                result = 10*result + Integer.parseInt(str);
            } else {
                break;
            }
        }
        return flag?result:-result;
    }
}
