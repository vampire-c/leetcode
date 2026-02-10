package leetcode.problems;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
class Solution1382 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                new TreeNode(3,
                                        null,
                                        new TreeNode(4)
                                )
                        )
                );

        TreeNode node = new Solution1382().balanceBST(treeNode);
        System.out.println(node);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = inorder(root);
        return sortedArrayToBST(list);
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    public void dfs(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(ans, root.left);
        ans.add(root.val);
        dfs(ans, root.right);
    }

    public TreeNode sortedArrayToBST(List<Integer> list) {
        return buildBST(list, 0, list.size());
    }

    public TreeNode buildBST(List<Integer> list, int left, int right) {
        if (left == right) {
            return null;
        }
        int m = left + ((right - left) >> 1);
        Integer val = list.get(m);
        TreeNode leftNode = buildBST(list, left, m);
        TreeNode rightNode = buildBST(list, m + 1, right);
        return new TreeNode(val, leftNode, rightNode);
    }


}
