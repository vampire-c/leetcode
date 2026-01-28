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
class Solution0222 {

    static void main(String[] args) {

        TreeNode treeNode =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)
                        ),
                        new TreeNode(3,
                                new TreeNode(6),
                                null
                        )
                );
        new Solution0222().countNodes(treeNode);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            int i1 = countNodes(root.right) + (1 << left);
            return i1;
        } else {
            int i2 = countNodes(root.left) + (1 << right);
            return i2;
        }
    }

    public int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }


    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


}
