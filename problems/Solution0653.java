package leetcode.problems;

import leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/*
给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
class Solution0653 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        5,
                        new TreeNode(
                                3,
                                new TreeNode(2),
                                new TreeNode(4)
                        ),
                        new TreeNode(
                                6,
                                null,
                                new TreeNode(7)
                        )
                );

        boolean target = new Solution0653().findTarget(treeNode, 28);
        System.out.println(target);
    }

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}
