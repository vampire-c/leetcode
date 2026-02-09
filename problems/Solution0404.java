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
class Solution0404 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(3,
                        new TreeNode(9,
                                new TreeNode(2),
                                new TreeNode(15)
                        ),
                        new TreeNode(20,
                                new TreeNode(9),
                                new TreeNode(7)
                        )
                );
        int i = new Solution0404().sumOfLeftLeaves1(treeNode);
        System.out.println(i);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) {
            sum += left.val;
        }
        return sum;
    }

    private int ans = 0;

    public int sumOfLeftLeaves1(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) {
            ans += left.val;
        }
    }
}
