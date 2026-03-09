package leetcode.problems;

import leetcode.Pair;
import leetcode.TreeNode;

/*
给你两棵二叉树 root 和 subRoot 。
检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
如果存在，返回 true ；否则，返回 false 。
二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。
tree 也可以看做它自身的一棵子树。
 */
class Solution0572 {

    static void main(String[] args) {

        TreeNode root =
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(2)
                        ),
                        new TreeNode(5)
                );

        TreeNode subRoot =
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)
                );

        new Solution0572().isSubtree1(root, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int height = getHeight(subRoot);
        return dfs(root, subRoot, height).getValue();
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    private Pair<Integer, Boolean> dfs(TreeNode node, TreeNode subRoot, int subHeight) {
        if (node == null) {
            return new Pair<>(0, false);
        }
        Pair<Integer, Boolean> left = dfs(node.left, subRoot, subHeight);
        Pair<Integer, Boolean> right = dfs(node.right, subRoot, subHeight);
        if (left.getValue() || right.getValue()) {
            return new Pair<>(0, true);
        }
        int nodeHeight = Math.max(left.getKey(), right.getKey()) + 1;
        return new Pair<>(nodeHeight, nodeHeight == subHeight && isSameTree(node, subRoot));
    }


    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        boolean isSameTree1 = isSameTree1(root, subRoot);
        boolean isSubtreeLeft = isSubtree1(root.left, subRoot);
        boolean isSubtreeRight = isSubtree1(root.right, subRoot);
        return isSameTree1 || isSubtreeLeft || isSubtreeRight;
    }

    private boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        boolean val = p.val == q.val;
        boolean isSameTreeLeft = isSameTree1(p.left, q.left);
        boolean isSameTreeRight = isSameTree1(p.right, q.right);
        return val && isSameTreeLeft && isSameTreeRight;
    }


}
