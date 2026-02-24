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
给你一棵二叉树的根节点，返回该树的 直径 。
二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
这条路径可能经过也可能不经过根节点 root 。
两节点之0间路径的 长度 由它们之间边数表示。
 */
class Solution0543 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)
                        ),
                        new TreeNode(3)
                );
        new Solution0543().diameterOfBinaryTree(treeNode);
    }

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftLength = dfs(node.left) + 1;
        int rightLength = dfs(node.right) + 1;
        ans = Math.max(ans, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }

}
