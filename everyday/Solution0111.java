package leetcode.everyday;

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
class Solution0111 {
    public static void main(String[] args) {
        new Solution0111().minDepth(
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                )
        );
    }

    int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return root == null ? 0 : ans;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null || ++cnt >= ans) {
            return;
        }
        if (node.left == null && node.right == null) {
            ans = cnt;
            return;
        }
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }


}
