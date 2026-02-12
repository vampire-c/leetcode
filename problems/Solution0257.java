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
 *
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
叶子节点 是指没有子节点的节点。
 */
class Solution0257 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(1,
                        new TreeNode(2,
                                null,
                                new TreeNode(5)
                        ),
                        new TreeNode(3)
                );
        new Solution0257().binaryTreePaths(treeNode);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode node, String path, List<String> ans) {
        if (node == null) {
            return;
        }
        path += node.val;
        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }
        path += "->";
        dfs(node.left, path, ans);
        dfs(node.right, path, ans);
    }

}
