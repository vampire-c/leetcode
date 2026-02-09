package leetcode.problems;

import leetcode.TreeNode;

/*
 * Definition for a binary tree node
 * public class TreeNode
 *     int val
 *     TreeNode left
 *     TreeNode right
 *     TreeNode() {
 *     TreeNode(int val) { this.val = val;
 *     TreeNode(int val, TreeNode left, TreeNode right)
 *         this.val = val
 *         this.left = left
 *         this.right = right
 *
 * }
 */
class Solution0108 {

    public static void main(String[] args) {
        new Solution0108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode dfs = dfs(nums, 0, nums.length);
        return dfs;
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int m = (left + right) >>> 1;
        TreeNode dfs1 = dfs(nums, left, m);
        TreeNode dfs2 = dfs(nums, m + 1, right);
        int num = nums[m];
        return new TreeNode(num, dfs1, dfs2);
    }
}
