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
 */
class Solution0876 {

    static void main(String[] args) {
        ListNode listNode1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5
                                                )))));

        ListNode listNode2 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6
                                                        ))))));

        new Solution0876().middleNode2(listNode1);
    }

    public ListNode middleNode2(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            k++;
            cur = cur.next;
        }
        return cur;
    }

    public ListNode middleNode1(ListNode head) {
        ListNode[] listNodes = new ListNode[100];
        int t = 0;
        while (head != null) {
            listNodes[t++] = head;
            head = head.next;
        }
        return listNodes[t / 2];
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
