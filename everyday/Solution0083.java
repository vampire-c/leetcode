package leetcode.problems;

import leetcode.ListNode;

public class Solution0083 {

    public static void main(String[] args) {
        new Solution0083().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
