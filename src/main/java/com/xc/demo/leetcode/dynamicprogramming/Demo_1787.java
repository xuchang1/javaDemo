package com.xc.demo.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author changxu13
 * @date 2021/5/25 11:19
 */
public class Demo_1787 {

	// x 的范围为 [0, 2^10)
	static final int MAXX = 1 << 10;
	// 极大值，为了防止整数溢出选择 INT_MAX / 2
	static final int INFTY = Integer.MAX_VALUE / 2;

	public static void main(String[] args) {
		int[] nums = {3,4,5,2,1,7,3,4,7};
		int k = 3;
		System.out.println(minChanges(nums, k));
	}

	public static int minChanges(int[] nums, int k) {
		int n = nums.length;
		int[] f = new int[MAXX];
		Arrays.fill(f, INFTY);
		// 边界条件 f(-1,0)=0
		f[0] = 0;

		for (int i = 0; i < k; ++i) {
			// 第 i 个组的哈希映射
			Map<Integer, Integer> cnt = new HashMap<>();
			int size = 0;
			for (int j = i; j < n; j += k) {
				cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
				++size;
			}

			// 求出 t2
			int t2min = Arrays.stream(f).min().getAsInt();

			int[] g = new int[MAXX];
			Arrays.fill(g, t2min);
			for (int mask = 0; mask < MAXX; ++mask) {
				// t1 则需要枚举 x 才能求出
				for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
					int x = entry.getKey(), countx = entry.getValue();
					g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
				}
			}

			// 别忘了加上 size
			for (int j = 0; j < MAXX; ++j) {
				g[j] += size;
			}
			f = g;
		}

		return f[0];
	}
}
