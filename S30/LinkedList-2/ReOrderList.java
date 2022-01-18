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
        if (head == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // get the mid element of the Linked List
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse LL
        ListNode backPtr = reverseLL(slow);        
        ListNode frontPtr = head;
        
        while (backPtr.next != null) {        
            ListNode currNext = frontPtr.next;
            frontPtr.next = backPtr;
            frontPtr = currNext;
            
            currNext = backPtr.next;
            backPtr.next = frontPtr;
            backPtr = currNext;
        }
        
        
    }
    
    private ListNode reverseLL(ListNode ptr) {
        ListNode prev = null;
        
        while (ptr != null) {
            ListNode nextRef = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = nextRef;
        }
        
        return prev;
       
    }
}