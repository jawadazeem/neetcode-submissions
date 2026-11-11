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
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head; 
        boolean first = true;
        
        while (tortoise != null && hare != null && hare.next != null) {
            if (tortoise.next == null || hare.next.next == null) {
                return false;
            } else if (hare == tortoise && !first) {
                return true;
            } else {
                tortoise = tortoise.next;
                hare = hare.next.next;
            }
            first = false;
        }

        return false;
    }
}
