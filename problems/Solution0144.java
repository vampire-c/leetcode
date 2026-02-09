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
class Solution0144 {

    static void main(String[] args) {
        List<Integer> integers = new Solution0144().preorderTraversal(
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                new TreeNode(3),
                                null
                        )
                )
        );

        List<Integer> integers1 = new Solution0144().preorderTraversal(
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
        // System.out.println(integers);
        System.out.println(integers1);


    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return ans;
    }
}
