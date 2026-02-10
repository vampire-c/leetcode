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
 *
 * 给定一个二叉树，判断它是否是 平衡二叉树(平衡二叉树 是指该树所有节点的左右子树的高度相差不超过 1。)
 */
public class Solution0110 {
    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                );
        new Solution0110().isBalanced(treeNode);
    }


    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
