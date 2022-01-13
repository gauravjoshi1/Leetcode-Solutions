/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        int count;

        while (fastPtr != null) {
            count = 0;

            while (count < 2) {
                if (fastPtr == null) return false;

                fastPtr = fastPtr.next;
                count = count + 1;
            }

            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) return true;
        }

        return false;
    }
}
