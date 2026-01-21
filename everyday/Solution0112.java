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
class Solution0112 {

    static void main(String[] args) {

        new Solution0112().hasPathSum(
                new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(11,
                                        new TreeNode(7),
                                        new TreeNode(2)
                                ),
                                null
                        ),
                        new TreeNode(8,
                                new TreeNode(13),
                                new TreeNode(4,
                                        null,
                                        new TreeNode(1)
                                )
                        )
                ),
                22
        );

        // new Solution0112().hasPathSum(
        //         new TreeNode(1,
        //                 new TreeNode(2),
        //                 new TreeNode(3)
        //         ),
        //         4
        // );
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        boolean bl = hasPathSum(root.left, targetSum);
        boolean br = hasPathSum(root.right, targetSum);
        return bl || br;
    }

}
