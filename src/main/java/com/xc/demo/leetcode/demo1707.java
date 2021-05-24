package com.xc.demo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class demo1707 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[][] queries = {{3,1},{1,3},{5,6}};
        Arrays.stream(maximizeXor(nums, queries)).forEach(System.out::println);
    }

    public static int[] maximizeXor(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];

	    Arrays.sort(nums);
	    int[][] queriesNew = new int[queries.length][3];
	    for (int i = 0; i < queries.length; i++) {
		    queriesNew[i][0] = queries[i][0];
		    queriesNew[i][1] = queries[i][1];
		    queriesNew[i][2] = i;
	    }
	    Arrays.sort(queriesNew, (Comparator.comparingInt(o -> o[1])));

	    Trie2 trie = new Trie2();
	    int index = 0;
	    for (int i = 0; i < nums.length; i++) {
	    	while (index < queriesNew.length) {
			    if (nums[i] <= queriesNew[index][1]) {
				    trie.insert(nums[i]);
				    if (i != nums.length - 1) {
					    break;
				    } else {
					    result[queriesNew[index][2]] = trie.findMax(queriesNew[index][0]);
				    }
			    } else if (i == 0){
				    result[queriesNew[index][2]] = -1;
			    } else {
				    result[queriesNew[index][2]] = trie.findMax(queriesNew[index][0]);
			    }
			    index++;
		    }
	    }

        return result;
    }
}

class Trie2 {
	private static final int L = 30;
	private Trie2[] children = new Trie2[2];

	public void insert(int val) {
		Trie2 node = this;
		for (int i = L-1; i >= 0; i--) {
			int bit = (val >> i) & 1;
			if (node.children[bit] == null) {
				node.children[bit] = new Trie2();
			}
			node = node.children[bit];
		}
	}

	/**
	 * 查询最大的异或运算结果
	 *
	 * @param val 整数
	 * @return 最大的异或运算结果
	 */
	public int findMax(int val) {
		int result = 0;
		Trie2 node = this;
		for (int i = L-1; i >= 0; i--) {
			int bit = (val >> i) & 1;
			if (node.children[bit ^ 1] != null) {
				node = node.children[bit ^ 1];
				result |= 1<<i;
			} else {
				node = node.children[bit];
			}

		}
		return result;
	}

	/**
	 * 转化为二级制字符串，最大30位前面补0
	 *
	 * @param i 整数
	 * @return 30位二进制字符串
	 */
	private String getStringByInt(int i) {
		StringBuilder str = new StringBuilder(Integer.toBinaryString(i));
		int length = 30 -str.length();
		for (int j = 0; j < length; j++) {
			str.insert(0, "0");
		}
		return str.toString();
	}
}