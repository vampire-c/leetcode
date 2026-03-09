package leetcode.problems;


import leetcode.TreeNode;

/*
给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
整个树 的坡度就是其所有节点的坡度之和。
 */
class Solution0563 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        4,
                        new TreeNode(
                                2,
                                new TreeNode(3),
                                new TreeNode(5)
                        ),
                        new TreeNode(
                                9,
                                null,
                                new TreeNode(7)
                        )
                );

        new Solution0563().findTilt(treeNode);
    }

    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }


}
