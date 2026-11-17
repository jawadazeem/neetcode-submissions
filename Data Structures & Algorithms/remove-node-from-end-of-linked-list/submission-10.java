/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reference = head;
        int sz = 1;

        while(reference.next != null) {
            sz++;
            reference = reference.next;
        }

        if (sz == 1) return null;
        if (n == sz) {
            return head.next;
        }
        reference = head;
        if (n == 1) {
            ListNode prev = reference;
            while (reference.next != null) {
                prev = reference;
                reference = reference.next;
            }

            prev.next = null;
            return head;
        }

        int rm = sz-n; // node before the one to remove.
        reference = head;
        for (int i=1; i<rm; i++) {
            reference = reference.next;
        }

        if (reference.next.next != null) {
            reference.next = reference.next.next;
        }

        return head;
    }
}
