package leetcode.problems;

import leetcode.TreeNode;

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
给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 */
class Solution1022 {
    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        1,
                        new TreeNode(0,
                                new TreeNode(0),
                                new TreeNode(1)
                        ),
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(1)
                        )
                );

        new Solution1022().sumRootToLeaf1(treeNode);
    }

    int sum = 0;

    public int sumRootToLeaf1(TreeNode root) {
        dfs1(root, 0);
        return sum;
    }

    private void dfs1(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        num = (num << 1) | node.val;
        if (node.left == null && node.right == null) {
            sum += num;
            return;
        }
        dfs1(node.left, num);
        dfs1(node.right, num);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        val = (val << 1) | node.val;
        if (node.left == null && node.right == null) {
            return val;
        }
        int dfs1 = dfs(node.left, val);
        int dfs2 = dfs(node.right, val);
        return dfs1 + dfs2;
    }


}
