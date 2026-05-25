package leetcode.problems;

import leetcode.ListNode;

/*
给你两个 非空 的链表，表示两个非负的整数。
它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
class Solution0002 {

    static void main(String[] args) {

        ListNode l1 = new ListNode(
                2, new ListNode(
                4, new ListNode(
                3)));
        ListNode l2 = new ListNode(
                5, new ListNode(
                6, new ListNode(
                4)));
        ListNode listNode = new Solution0002().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // n1 + n2 + 本位进位数
            int sum = n1 + n2 + carry;
            // 下一位进位数
            carry = sum / 10;
            // 本位值
            sum = sum % 10;
            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
