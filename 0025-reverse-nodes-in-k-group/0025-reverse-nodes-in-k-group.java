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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        while (true) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;

            // Check if we have enough nodes for the next group
            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) return dummy.next; // Not enough nodes
            }
            
            ListNode nextGroupStart = groupEnd.next; // Save the next group's start
            
            // Reverse the current group
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next; // Save the next node
                curr.next = prev; // Reverse the link
                prev = curr; // Move prev to current node
                curr = temp; // Move to the next node
            }
            
            // Connect the previous group to the new head of the reversed group
            prevGroupEnd.next = prev;
            // Connect the end of the reversed group to the start of the next group
            groupStart.next = nextGroupStart;
            // Move the prevGroupEnd pointer to the end of the current reversed group
            prevGroupEnd = groupStart;
        }
    }
}
