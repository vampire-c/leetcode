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

