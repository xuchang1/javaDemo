package com.xc.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Demo_1074 {

    public static void main(String[] args) {
        int[][] matrix = {{1,-1}, {-1,1}};
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int[] nums = new int[m];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    nums[k] += matrix[j][k];
                }
                count += subarraySum(nums, target);
            }
        }

        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre-k)) {
                count += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
