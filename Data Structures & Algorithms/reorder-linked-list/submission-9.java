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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode hare = head;
        ListNode tortoise = head;
        while (hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        if (hare.next != null) {
            hare = hare.next;
        }

        ListNode temp = tortoise;
        tortoise = tortoise.next;
        temp.next = null; // severed

        tortoise = reverseList(tortoise);

        ListNode dummy = new ListNode(0); // merge
        ListNode curr = dummy;
        
        ListNode temp1;
        ListNode temp2;
        while (curr != null && head != null && tortoise != null) {
            temp1 = head.next;
            temp2 = tortoise.next;

            curr.next = head;
            curr = curr.next;
            curr.next = tortoise;
            curr = curr.next;

            head = temp1;
            tortoise = temp2;
        }

        if (tortoise != null) {
            curr.next = tortoise;
            curr = tortoise;
            curr = curr.next;
        }

        if (head != null) {
            curr.next = head;
            curr = head;
            curr = curr.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
