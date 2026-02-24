package leetcode.problems;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
差值是一个正数，其数值等于两值之差的绝对值。
 */
class Solution0530 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)
                        ),
                        new TreeNode(6)
                );

        new Solution0530().getMinimumDifference(treeNode);
    }

    List<Integer> ret = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < ret.size(); i++) {
            ans = Math.min(ans, ret.get(i) - ret.get(i - 1));
        }
        return ans;
    }


    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ret.add(root.val);
        dfs(root.right);
    }
}
