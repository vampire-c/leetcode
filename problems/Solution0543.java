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
