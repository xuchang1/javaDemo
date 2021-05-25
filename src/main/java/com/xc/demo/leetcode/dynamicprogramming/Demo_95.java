package com.xc.demo.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changxu13
 * @date 2021/5/25 20:47
 */
public class Demo_95 {


	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = new ArrayList<>();
		if (n == 1) {
			result.add(new TreeNode(1));
			return result;
		}

		for (int i = 2; i <= n; i++) {
			for (TreeNode generateTree : generateTrees(i - 1)) {

			}
		}

		return result;
	}
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
