package com.xc.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Demo_560 {

    public static void main(String[] args) {
        int nums[] = {1,2,1,2,1};
        int k = 3;
        System.out.println(subarraySum(nums, k));
        System.out.println(subarraySum2(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
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
