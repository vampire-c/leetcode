package leetcode.problems;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：
题目数据 保证 整个链式结构中不存在环。
注意，函数返回结果后，链表必须 保持其原始结构 。
自定义评测：
评测系统 的输入如下（你设计的程序 不适用 此输入）：
intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。
如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案。
 */
public class Solution0160 {


    static void main(String[] args) {

        ListNode a4 = new ListNode(4);
        ListNode a1 = new ListNode(1);

        ListNode b5 = new ListNode(5);
        ListNode b6 = new ListNode(6);
        ListNode b1 = new ListNode(1);

        ListNode c8 = new ListNode(8);
        ListNode c4 = new ListNode(4);
        ListNode c5 = new ListNode(5);

        c8.next = c4;
        c4.next = c5;

        a4.next = a1;
        a1.next = c8;

        b5.next = b6;
        b6.next = b1;
        b1.next = c8;

        new Solution0160().getIntersectionNode(a4, b5);
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            if (node1 != null) {
                node1 = node1.next;
            } else {
                node1 = headB;
            }
            if (node2 != null) {
                node2 = node2.next;
            } else {
                node2 = headA;
            }
        }
        return node1;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

