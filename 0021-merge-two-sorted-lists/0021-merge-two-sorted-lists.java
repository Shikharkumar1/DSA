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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode dummyNode = new ListNode(-1);  // Dummy node to simplify edge cases
        ListNode temp = dummyNode;  // Initialize temp to dummyNode

        // Traverse both lists and merge them in sorted order
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                temp.next = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;  // Move temp to the next node
        }

        // If there are remaining nodes in either list, append them
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }

        return dummyNode.next;  // Return the merged list, starting from the next of dummyNode
    }
}
