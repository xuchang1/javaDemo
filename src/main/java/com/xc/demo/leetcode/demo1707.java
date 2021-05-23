package com.xc.demo.leetcode;

import java.util.Arrays;
import java.util.function.IntSupplier;

public class demo1707 {
    public static void main(String[] args) {
        int[] nums = {5,2,4,6,6,3};
        int[][] queries = {{12,4},{8,1},{6,3}};
        Arrays.stream(maximizeXor(nums, queries)).forEach(System.out::println);
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        IntSupplierNum intSupplierNum = new IntSupplierNum();
        int[] newNums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = Arrays.stream(newNums)
                    .filter(x -> x <= query[1])
                    .map(y -> y ^ query[0])
                    .max()
                    .orElseGet(intSupplierNum);
        }
        return result;
    }
}

class IntSupplierNum implements IntSupplier {

    @Override
    public int getAsInt() {
        return -1;
    }
}