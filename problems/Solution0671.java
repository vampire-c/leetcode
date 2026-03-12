package leetcode.problems;


import leetcode.TreeNode;

/*
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
如果第二小的值不存在的话，输出 -1 。
 */
class Solution0671 {

    static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(
                        2,
                        new TreeNode(2),
                        new TreeNode(5,
                                new TreeNode(5),
                                new TreeNode(7)
                        ));
        new Solution0671().findSecondMinimumValue(treeNode);
    }

    int ans;
    int rootValue;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootValue = root.val;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootValue) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }

}
