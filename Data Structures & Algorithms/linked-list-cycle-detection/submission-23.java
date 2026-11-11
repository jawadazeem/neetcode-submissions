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
        HashSet<ListNode> set = new HashSet<>();

        if (head == null) {
            return false;
        } else {
            set.add(head);
        }

        while (head.next != null) {
            head = head.next;
            
            if (set.add(head.next) == false) {
                return true;
            }
        }
        return false;
    }
}
