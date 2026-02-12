package leetcode.problems;

import leetcode.ListNode;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
class Solution0206 {

    static void main(String[] args) {

        ListNode listNode =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)

                                        )
                                )
                        )
                );


        ListNode listNode1 = new Solution0206().reverseList(listNode);
        System.out.println();

    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode temp = null;
        while (head != null) {
            temp = new ListNode(head.val, temp);
            head = head.next;
        }
        return temp;
    }

}
