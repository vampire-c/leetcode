package leetcode.problems;


import leetcode.Node;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
class Solution0589 {

    static void main(String[] args) {
        List<Node> list3 = new ArrayList<>();
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());
        list3.add(node5);
        list3.add(node6);
        Node node3 = new Node(3, list3);

        List<Node> list1 = new ArrayList<>();
        list1.add(node3);
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        list1.add(node2);
        list1.add(node4);
        Node node1 = new Node(1, list1);

        new Solution0589().preorder(node1);
    }


    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        for (Node n : node.children) {
            dfs(n);
        }
    }
}
