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
给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
class Solution0145 {

    static void main(String[] args) {
        List<Integer> integers = new Solution0145().postorderTraversal(
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                new TreeNode(3),
                                null
                        )
                )
        );

        List<Integer> integers1 = new Solution0145().postorderTraversal(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(7)
                                )
                        ),
                        new TreeNode(3,
                                null,
                                new TreeNode(8,
                                        new TreeNode(9),
                                        null
                                )
                        )
                )
        );
        System.out.println(integers);
        System.out.println(integers1);
    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            ans.add(root.val);
        }
        return ans;
    }
} 
