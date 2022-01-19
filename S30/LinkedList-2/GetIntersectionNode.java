/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode refA = headA, refB = headB;
        int lenA = LinkedListLen(refA), lenB = LinkedListLen(refB);         
        int diff = Math.abs(lenA - lenB);
        
        if (lenA > lenB) {
            refA = skipToEqualLL(refA, diff);
        }
        else {
            refB = skipToEqualLL(refB, diff);
        } 
      
        while (refA != null && refB != null) {
            if (refA == refB) return refA;
            
            refA = refA.next;
            refB = refB.next;
        }
        
        return null;
    }
    
    private int LinkedListLen(ListNode ptr) {
        int lenOfLinkedList = 0;
        
         while (ptr != null) {
            lenOfLinkedList += 1;
            ptr = ptr.next;
        }
        
        return lenOfLinkedList;
    }
    
    private ListNode skipToEqualLL(ListNode ptr, int diff) {
        while (ptr != null && diff > 0) {
            ptr = ptr.next;
            diff--;
        }
        
        return ptr;
    }
}