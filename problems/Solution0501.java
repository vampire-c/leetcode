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
给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
如果树中有不止一个众数，可以按 任意顺序 返回。
假定 BST 满足如下定义：
结点左子树中所含节点的值 小于等于 当前节点的值
结点右子树中所含节点的值 大于等于 当前节点的值
左子树和右子树都是二叉搜索树
 */
class Solution0501 {

    static void main(String[] args) {
        /*
              1
            /   \
           0     2
          / \    /
        -1   0  2
         */
        TreeNode treeNode =
                new TreeNode(
                        1,
                        new TreeNode(
                                0,
                                new TreeNode(-1),
                                new TreeNode(0)
                        ),
                        new TreeNode(
                                2,
                                new TreeNode(2),
                                null
                        )
                );
        new Solution0501().findMode(treeNode);
    }


    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    List<Integer> ans = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode1(TreeNode root) {
        dfs(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    /**
     * 更新当前节点值，中序遍历，相同的值连续出现
     *
     * @param val
     */
    private void update(int val) {
        if (val == base) {
            // 相同值，计数加1
            count++;
        } else {
            // 不同值，计数重置为1
            count = 1;
            // 更新当前值
            base = val;
        }
        if (count == maxCount) {
            // 计数等于最大值，添加众数
            ans.add(base);
        }

        if (count > maxCount) {
            // 计数大于最大值，更新最大值，并清空众数，添加当前众数
            maxCount = count;
            ans.clear();
            ans.add(base);
        }
    }


}
