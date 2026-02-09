package leetcode.problems;

import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution0101 {

    public static void main(String[] args) {
        new Solution0101().isSymmetric(
                new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2, new TreeNode(4), new TreeNode(3))
                )
        );
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }

}
